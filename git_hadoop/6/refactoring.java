  @VisibleForTesting
  void check(String parent, HdfsFileStatus file, Result res) throws IOException {
    String path = file.getFullName(parent);
    boolean isOpen = false;

    if (file.isDir()) {
      if (snapshottableDirs != null && snapshottableDirs.contains(path)) {
        String snapshotPath = (path.endsWith(Path.SEPARATOR) ? path : path
            + Path.SEPARATOR)
            + HdfsConstants.DOT_SNAPSHOT_DIR;
        HdfsFileStatus snapshotFileInfo = namenode.getRpcServer().getFileInfo(
            snapshotPath);
        check(snapshotPath, snapshotFileInfo, res);
      }
      byte[] lastReturnedName = HdfsFileStatus.EMPTY_NAME;
      DirectoryListing thisListing;
      if (showFiles) {
        out.println(path + " <dir>");
      }
      res.totalDirs++;
      do {
        assert lastReturnedName != null;
        thisListing = namenode.getRpcServer().getListing(
            path, lastReturnedName, false);
        if (thisListing == null) {
          return;
        }
        HdfsFileStatus[] files = thisListing.getPartialListing();
        for (int i = 0; i < files.length; i++) {
          check(path, files[i], res);
        }
        lastReturnedName = thisListing.getLastName();
      } while (thisListing.hasMore());
      return;
    }
    if (file.isSymlink()) {
      if (showFiles) {
        out.println(path + " <symlink>");
      }
      res.totalSymlinks++;
      return;
    }

    long fileLen = file.getLen();
    // Get block locations without updating the file access time 
    // and without block access tokens
    LocatedBlocks blocks = null;
    FSNamesystem fsn = namenode.getNamesystem();
    fsn.readLock();
    try {
      blocks = fsn.getBlockLocations(path, 0, fileLen, false, false).blocks;
    } catch (FileNotFoundException fnfe) {
      blocks = null;
    } finally {
      fsn.readUnlock();
    }

    if (blocks == null) { // the file is deleted
      return;
    }
    
    isOpen = blocks.isUnderConstruction();
    if (isOpen && !showOpenFiles) {
      // We collect these stats about open files to report with default options
      res.totalOpenFilesSize += fileLen;
      res.totalOpenFilesBlocks += blocks.locatedBlockCount();
      res.totalOpenFiles++;
      return;
    }
    res.totalFiles++;
    res.totalSize += fileLen;
    res.totalBlocks += blocks.locatedBlockCount();
    if (showOpenFiles && isOpen) {
      out.print(path + " " + fileLen + " bytes, " +
        blocks.locatedBlockCount() + " block(s), OPENFORWRITE: ");
    } else if (showFiles) {
      out.print(path + " " + fileLen + " bytes, " +
        blocks.locatedBlockCount() + " block(s): ");
    } else if (showprogress) {
      out.print('.');
    }
    if ((showprogress) && res.totalFiles % 100 == 0) {
      out.println();
      out.flush();
    }
    int missing = 0;
    int corrupt = 0;
    long missize = 0;
    int underReplicatedPerFile = 0;
    int misReplicatedPerFile = 0;
    StringBuilder report = new StringBuilder();
    int i = 0;
    for (LocatedBlock lBlk : blocks.getLocatedBlocks()) {
      ExtendedBlock block = lBlk.getBlock();
      boolean isCorrupt = lBlk.isCorrupt();
      String blkName = block.toString();
      BlockManager bm = namenode.getNamesystem().getBlockManager();
      NumberReplicas numberReplicas = bm.countNodes(block.getLocalBlock());
      int liveReplicas = numberReplicas.liveReplicas();
      int decommissionedReplicas = numberReplicas.decommissioned();;
      int decommissioningReplicas = numberReplicas.decommissioning();
      res.decommissionedReplicas +=  decommissionedReplicas;
      res.decommissioningReplicas += decommissioningReplicas;
      int totalReplicas = liveReplicas + decommissionedReplicas +
          decommissioningReplicas;
      res.totalReplicas += totalReplicas;
      Collection<DatanodeDescriptor> corruptReplicas = null;
      if (showReplicaDetails) {
        corruptReplicas = bm.getCorruptReplicas(block.getLocalBlock());
      }
      short targetFileReplication = file.getReplication();
      res.numExpectedReplicas += targetFileReplication;
      if(totalReplicas < minReplication){
        res.numUnderMinReplicatedBlocks++;
      }
      if (liveReplicas > targetFileReplication) {
        res.excessiveReplicas += (liveReplicas - targetFileReplication);
        res.numOverReplicatedBlocks += 1;
      }
      //keep track of storage tier counts
      if (this.showStoragePolcies && lBlk.getStorageTypes() != null) {
        StorageType[] storageTypes = lBlk.getStorageTypes();
        storageTypeSummary.add(Arrays.copyOf(storageTypes, storageTypes.length),
            fsn.getBlockManager().getStoragePolicy(file.getStoragePolicy()));
      }
      // Check if block is Corrupt
      if (isCorrupt) {
        corrupt++;
        res.corruptBlocks++;
        out.print("\n" + path + ": CORRUPT blockpool " + block.getBlockPoolId() + 
            " block " + block.getBlockName()+"\n");
      }
      if (totalReplicas >= minReplication)
        res.numMinReplicatedBlocks++;
      if (totalReplicas < targetFileReplication && totalReplicas > 0) {
        res.missingReplicas += (targetFileReplication - totalReplicas);
        res.numUnderReplicatedBlocks += 1;
        underReplicatedPerFile++;
        if (!showFiles) {
          out.print("\n" + path + ": ");
        }
        out.println(" Under replicated " + block +
                    ". Target Replicas is " +
                    targetFileReplication + " but found " +
                    liveReplicas + " live replica(s), " +
                    decommissionedReplicas + " decommissioned replica(s) and " +
                    decommissioningReplicas + " decommissioning replica(s).");
      }
      // verify block placement policy
      BlockPlacementStatus blockPlacementStatus = bpPolicy
          .verifyBlockPlacement(path, lBlk, targetFileReplication);
      if (!blockPlacementStatus.isPlacementPolicySatisfied()) {
        res.numMisReplicatedBlocks++;
        misReplicatedPerFile++;
        if (!showFiles) {
          if(underReplicatedPerFile == 0)
            out.println();
          out.print(path + ": ");
        }
        out.println(" Replica placement policy is violated for " + 
                    block + ". " + blockPlacementStatus.getErrorDescription());
      }
      report.append(i + ". " + blkName + " len=" + block.getNumBytes());
      if (totalReplicas == 0) {
        report.append(" MISSING!");
        res.addMissing(block.toString(), block.getNumBytes());
        missing++;
        missize += block.getNumBytes();
      } else {
        report.append(" repl=" + liveReplicas);
        if (showLocations || showRacks || showReplicaDetails) {
          StringBuilder sb = new StringBuilder("[");
          Iterable<DatanodeStorageInfo> storages = bm.getStorages(block.getLocalBlock());
          for (Iterator<DatanodeStorageInfo> iterator = storages.iterator(); iterator.hasNext();) {
            DatanodeStorageInfo storage = iterator.next();
            DatanodeDescriptor dnDesc = storage.getDatanodeDescriptor();
            if (showRacks) {
              sb.append(NodeBase.getPath(dnDesc));
            } else {
              sb.append(new DatanodeInfoWithStorage(dnDesc, storage.getStorageID(), storage
                  .getStorageType()));
            }
            if (showReplicaDetails) {
              LightWeightLinkedSet<Block> blocksExcess =
                  bm.excessReplicateMap.get(dnDesc.getDatanodeUuid());
              sb.append("(");
              if (dnDesc.isDecommissioned()) {
                sb.append("DECOMMISSIONED)");
              } else if (dnDesc.isDecommissionInProgress()) {
                sb.append("DECOMMISSIONING)");
              } else if (corruptReplicas != null && corruptReplicas.contains(dnDesc)) {
                sb.append("CORRUPT)");
              } else if (blocksExcess != null && blocksExcess.contains(block.getLocalBlock())) {
                sb.append("EXCESS)");
              } else if (dnDesc.isStale(this.staleInterval)) {
                sb.append("STALE_NODE)");
              } else if (storage.areBlockContentsStale()) {
                sb.append("STALE_BLOCK_CONTENT)");
              } else {
                sb.append("LIVE)");
              }
            }
            if (iterator.hasNext()) {
              sb.append(", ");
            }
          }
          sb.append(']');
          report.append(" " + sb.toString());
        }
      }
      report.append('\n');
      i++;
    }
    if ((missing > 0) || (corrupt > 0)) {
      if (!showFiles && (missing > 0)) {
        out.print("\n" + path + ": MISSING " + missing
            + " blocks of total size " + missize + " B.");
      }
      res.corruptFiles++;
      if (isOpen) {
        LOG.info("Fsck: ignoring open file " + path);
      } else {
        if (doMove) copyBlocksToLostFound(parent, file, blocks);
        if (doDelete) deleteCorruptedFile(path);
      }
    }
    if (showFiles) {
      if (missing > 0) {
        out.print(" MISSING " + missing + " blocks of total size " + missize + " B\n");
      }  else if (underReplicatedPerFile == 0 && misReplicatedPerFile == 0) {
        out.print(" OK\n");
      }
      if (showBlocks) {
        out.print(report.toString() + "\n");
      }
    }
  }

------------------------------------------------------------------------------
  /**
  * The lengthy body of method check() is extracted into checkDir(), getBlockLocations(),
  * collectFileSummary(), collectBlocksSummary().
  */
  @VisibleForTesting
  void check(String parent, HdfsFileStatus file, Result res) throws IOException {
    String path = file.getFullName(parent);
    if (file.isDir()) {
      checkDir(path, res);
      return;
    }
    if (file.isSymlink()) {
      if (showFiles) {
        out.println(path + " <symlink>");
      }
      res.totalSymlinks++;
      return;
    }
    LocatedBlocks blocks = getBlockLocations(path, file);
    if (blocks == null) { // the file is deleted
      return;
    }
    collectFileSummary(path, file, res, blocks);
    collectBlocksSummary(parent, file, res, blocks);
  }

  private void checkDir(String path, Result res) throws IOException {
    if (snapshottableDirs != null && snapshottableDirs.contains(path)) {
      String snapshotPath = (path.endsWith(Path.SEPARATOR) ? path : path
          + Path.SEPARATOR)
          + HdfsConstants.DOT_SNAPSHOT_DIR;
      HdfsFileStatus snapshotFileInfo = namenode.getRpcServer().getFileInfo(
          snapshotPath);
      check(snapshotPath, snapshotFileInfo, res);
    }
    byte[] lastReturnedName = HdfsFileStatus.EMPTY_NAME;
    DirectoryListing thisListing;
    if (showFiles) {
      out.println(path + " <dir>");
    }
    res.totalDirs++;
    do {
      assert lastReturnedName != null;
      thisListing = namenode.getRpcServer().getListing(
          path, lastReturnedName, false);
      if (thisListing == null) {
        return;
      }
      HdfsFileStatus[] files = thisListing.getPartialListing();
      for (int i = 0; i < files.length; i++) {
        check(path, files[i], res);
      }
      lastReturnedName = thisListing.getLastName();
    } while (thisListing.hasMore());
  }

  private LocatedBlocks getBlockLocations(String path, HdfsFileStatus file)
      throws IOException {
    long fileLen = file.getLen();
    LocatedBlocks blocks = null;
    FSNamesystem fsn = namenode.getNamesystem();
    fsn.readLock();
    try {
      blocks = fsn.getBlockLocations(path, 0, fileLen, false, false).blocks;
    } catch (FileNotFoundException fnfe) {
      blocks = null;
    } finally {
      fsn.readUnlock();
    }
    return blocks;
  }

  private void collectFileSummary(String path, HdfsFileStatus file, Result res,
      LocatedBlocks blocks) throws IOException {
    long fileLen = file.getLen();
    boolean isOpen = blocks.isUnderConstruction();
    if (isOpen && !showOpenFiles) {
      // We collect these stats about open files to report with default options
      res.totalOpenFilesSize += fileLen;
      res.totalOpenFilesBlocks += blocks.locatedBlockCount();
      res.totalOpenFiles++;
      return;
    }
    res.totalFiles++;
    res.totalSize += fileLen;
    res.totalBlocks += blocks.locatedBlockCount();
    if (showOpenFiles && isOpen) {
      out.print(path + " " + fileLen + " bytes, " +
        blocks.locatedBlockCount() + " block(s), OPENFORWRITE: ");
    } else if (showFiles) {
      out.print(path + " " + fileLen + " bytes, " +
        blocks.locatedBlockCount() + " block(s): ");
    } else if (showprogress) {
      out.print('.');
    }
    if ((showprogress) && res.totalFiles % 100 == 0) {
      out.println();
      out.flush();
    }
  }

  private void collectBlocksSummary(String parent, HdfsFileStatus file, Result res,
      LocatedBlocks blocks) throws IOException {
    String path = file.getFullName(parent);
    boolean isOpen = blocks.isUnderConstruction();
    int missing = 0;
    int corrupt = 0;
    long missize = 0;
    int underReplicatedPerFile = 0;
    int misReplicatedPerFile = 0;
    StringBuilder report = new StringBuilder();
    int blockNumber = 0;
    for (LocatedBlock lBlk : blocks.getLocatedBlocks()) {
      ExtendedBlock block = lBlk.getBlock();
      BlockManager bm = namenode.getNamesystem().getBlockManager();

      // count decommissionedReplicas / decommissioningReplicas
      NumberReplicas numberReplicas = bm.countNodes(block.getLocalBlock());
      int decommissionedReplicas = numberReplicas.decommissioned();;
      int decommissioningReplicas = numberReplicas.decommissioning();
      res.decommissionedReplicas +=  decommissionedReplicas;
      res.decommissioningReplicas += decommissioningReplicas;

      // count total replicas
      int liveReplicas = numberReplicas.liveReplicas();
      int totalReplicasPerBlock = liveReplicas + decommissionedReplicas +
          decommissioningReplicas;
      res.totalReplicas += totalReplicasPerBlock;

      // count expected replicas
      short targetFileReplication = file.getReplication();
      res.numExpectedReplicas += targetFileReplication;

      // count under min repl'd blocks
      if(totalReplicasPerBlock < minReplication){
        res.numUnderMinReplicatedBlocks++;
      }

      // count excessive Replicas / over replicated blocks
      if (liveReplicas > targetFileReplication) {
        res.excessiveReplicas += (liveReplicas - targetFileReplication);
        res.numOverReplicatedBlocks += 1;
      }

      // count corrupt blocks
      boolean isCorrupt = lBlk.isCorrupt();
      if (isCorrupt) {
        corrupt++;
        res.corruptBlocks++;
        out.print("\n" + path + ": CORRUPT blockpool " + block.getBlockPoolId() + 
            " block " + block.getBlockName()+"\n");
      }

      // count minimally replicated blocks
      if (totalReplicasPerBlock >= minReplication)
        res.numMinReplicatedBlocks++;

      // count missing replicas / under replicated blocks
      if (totalReplicasPerBlock < targetFileReplication && totalReplicasPerBlock > 0) {
        res.missingReplicas += (targetFileReplication - totalReplicasPerBlock);
        res.numUnderReplicatedBlocks += 1;
        underReplicatedPerFile++;
        if (!showFiles) {
          out.print("\n" + path + ": ");
        }
        out.println(" Under replicated " + block +
                    ". Target Replicas is " +
                    targetFileReplication + " but found " +
                    liveReplicas + " live replica(s), " +
                    decommissionedReplicas + " decommissioned replica(s) and " +
                    decommissioningReplicas + " decommissioning replica(s).");
      }

      // count mis replicated blocks block
      BlockPlacementStatus blockPlacementStatus = bpPolicy
          .verifyBlockPlacement(path, lBlk, targetFileReplication);
      if (!blockPlacementStatus.isPlacementPolicySatisfied()) {
        res.numMisReplicatedBlocks++;
        misReplicatedPerFile++;
        if (!showFiles) {
          if(underReplicatedPerFile == 0)
            out.println();
          out.print(path + ": ");
        }
        out.println(" Replica placement policy is violated for " + 
                    block + ". " + blockPlacementStatus.getErrorDescription());
      }

      // count storage summary
      if (this.showStoragePolcies && lBlk.getStorageTypes() != null) {
        countStorageTypeSummary(file, lBlk);
      }

      // report
      String blkName = block.toString();
      report.append(blockNumber + ". " + blkName + " len=" + block.getNumBytes());
      if (totalReplicasPerBlock == 0) {
        report.append(" MISSING!");
        res.addMissing(block.toString(), block.getNumBytes());
        missing++;
        missize += block.getNumBytes();
      } else {
        report.append(" repl=" + liveReplicas);
        if (showLocations || showRacks || showReplicaDetails) {
          StringBuilder sb = new StringBuilder("[");
          Iterable<DatanodeStorageInfo> storages = bm.getStorages(block.getLocalBlock());
          for (Iterator<DatanodeStorageInfo> iterator = storages.iterator(); iterator.hasNext();) {
            DatanodeStorageInfo storage = iterator.next();
            DatanodeDescriptor dnDesc = storage.getDatanodeDescriptor();
            if (showRacks) {
              sb.append(NodeBase.getPath(dnDesc));
            } else {
              sb.append(new DatanodeInfoWithStorage(dnDesc, storage.getStorageID(), storage
                  .getStorageType()));
            }
            if (showReplicaDetails) {
              LightWeightLinkedSet<Block> blocksExcess =
                  bm.excessReplicateMap.get(dnDesc.getDatanodeUuid());
              Collection<DatanodeDescriptor> corruptReplicas =
                  bm.getCorruptReplicas(block.getLocalBlock());
              sb.append("(");
              if (dnDesc.isDecommissioned()) {
                sb.append("DECOMMISSIONED)");
              } else if (dnDesc.isDecommissionInProgress()) {
                sb.append("DECOMMISSIONING)");
              } else if (corruptReplicas != null && corruptReplicas.contains(dnDesc)) {
                sb.append("CORRUPT)");
              } else if (blocksExcess != null && blocksExcess.contains(block.getLocalBlock())) {
                sb.append("EXCESS)");
              } else if (dnDesc.isStale(this.staleInterval)) {
                sb.append("STALE_NODE)");
              } else if (storage.areBlockContentsStale()) {
                sb.append("STALE_BLOCK_CONTENT)");
              } else {
                sb.append("LIVE)");
              }
            }
            if (iterator.hasNext()) {
              sb.append(", ");
            }
          }
          sb.append(']');
          report.append(" " + sb.toString());
        }
      }
      report.append('\n');
      blockNumber++;
    }

    // count corrupt file & move or delete if necessary
    if ((missing > 0) || (corrupt > 0)) {
      if (!showFiles && (missing > 0)) {
        out.print("\n" + path + ": MISSING " + missing
            + " blocks of total size " + missize + " B.");
      }
      res.corruptFiles++;
      if (isOpen) {
        LOG.info("Fsck: ignoring open file " + path);
      } else {
        if (doMove) copyBlocksToLostFound(parent, file, blocks);
        if (doDelete) deleteCorruptedFile(path);
      }
    }

    if (showFiles) {
      if (missing > 0) {
        out.print(" MISSING " + missing + " blocks of total size " + missize + " B\n");
      }  else if (underReplicatedPerFile == 0 && misReplicatedPerFile == 0) {
        out.print(" OK\n");
      }
      if (showBlocks) {
        out.print(report.toString() + "\n");
      }
    }
  }



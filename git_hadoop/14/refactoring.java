  BlockSender(ExtendedBlock block, long startOffset, long length,
              boolean corruptChecksumOk, boolean chunkOffsetOK,
              boolean verifyChecksum, DataNode datanode, String clientTraceFmt)
      throws IOException {
    try {
      ...
      synchronized(datanode.data) { 
        this.replica = datanode.data.getReplica(block.getBlockPoolId(), 
            block.getBlockId());
        if (replica == null) {
          throw new ReplicaNotFoundException(block);
        }
        this.replicaVisibleLength = replica.getVisibleLength();
      }
      ...
  }
  ----------------------------------------------------------------
  /**
  * The code fragment to get a replica instance is extracted as method getReplica()
  */
  BlockSender(ExtendedBlock block, long startOffset, long length,
              boolean corruptChecksumOk, boolean chunkOffsetOK,
              boolean verifyChecksum, DataNode datanode, String clientTraceFmt)
      throws IOException {
    try {
      ...
      synchronized(datanode.data) { 
        this.replica = getReplica(block, datanode);
        this.replicaVisibleLength = replica.getVisibleLength();
      }
    }
    ...
  }

  private static Replica getReplica(ExtendedBlock block, DataNode datanode)
      throws ReplicaNotFoundException {
    Replica replica = datanode.data.getReplica(block.getBlockPoolId(),
        block.getBlockId());
    if (replica == null) {
      throw new ReplicaNotFoundException(block);
    }
    return replica;
  }

*******************case 2***************************************************
/**
  * The code fragment for waiting is extracted as a new method waitForMinLength().
  */
  BlockSender(ExtendedBlock block, long startOffset, long length,
              boolean corruptChecksumOk, boolean chunkOffsetOK,
              boolean verifyChecksum, DataNode datanode, String clientTraceFmt)
      throws IOException {
    ...
      // if this is a write in progress
      ChunkChecksum chunkChecksum = null;
      if (replica instanceof ReplicaBeingWritten) {
        for (int i = 0; i < 30 && replica.getBytesOnDisk() < minEndOffset; i++) {
          try {
            Thread.sleep(100);
          } catch (InterruptedException ie) {
            throw new IOException(ie);
          }
        }

        long currentBytesOnDisk = replica.getBytesOnDisk();
        
        if (currentBytesOnDisk < minEndOffset) {
          throw new IOException(String.format(
            "need %d bytes, but only %d bytes available",
            minEndOffset,
            currentBytesOnDisk
          ));
        }

        ReplicaInPipeline rip = (ReplicaInPipeline) replica;
        chunkChecksum = rip.getLastChecksumAndDataLen();
      }

      ...
  }

  -----------------------------------------------------------
  
  BlockSender(ExtendedBlock block, long startOffset, long length,
              boolean corruptChecksumOk, boolean chunkOffsetOK,
              boolean verifyChecksum, DataNode datanode, String clientTraceFmt)
      throws IOException {
    ...
      // if there is a write in progress
      ChunkChecksum chunkChecksum = null;
      if (replica instanceof ReplicaBeingWritten) {
        long minEndOffset = startOffset + length;
        waitForMinLength((ReplicaBeingWritten)replica, minEndOffset);
        ReplicaInPipeline rip = (ReplicaInPipeline) replica;
        chunkChecksum = rip.getLastChecksumAndDataLen();
      }
      ...
  }
  private static void waitForMinLength(ReplicaBeingWritten rbw, long len)
      throws IOException {
    // Wait for 3 seconds for rbw replica to reach the minimum length
    for (int i = 0; i < 30 && rbw.getBytesOnDisk() < len; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException ie) {
        throw new IOException(ie);
      }
    }
    long bytesOnDisk = rbw.getBytesOnDisk();
    if (bytesOnDisk < len) {
      throw new IOException(
          String.format("Need %d bytes, but only %d bytes available", len,
              bytesOnDisk));
    }
  }


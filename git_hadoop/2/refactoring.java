public boolean commitOrCompleteLastBlock(BlockCollection bc,
      Block commitBlock) throws IOException {
  if(commitBlock == null)
    return false; // not committing, this is a block allocation retry
  BlockInfo lastBlock = bc.getLastBlock();
  if(lastBlock == null)
    return false; // no blocks in file yet
  if(lastBlock.isComplete())
    return false; // already completed (e.g. by syncBlock)
  
  final boolean b = commitBlock(
      (BlockInfoUnderConstruction) lastBlock, commitBlock);
  if(countNodes(lastBlock).liveReplicas() >= minReplication)
    completeBlock(bc, bc.numBlocks()-1, false);
  return b;
}

------------------------------------------------------------------------------

/**
* A combination of ExtractMethod and SelfEncapsulate Field.
* The conditional statement "countNodes(lastBlock).liveReplicas() >= minReplication" 
* is extracted as method "hasMinStorage()" and the direct access to minReplication
* is replaced by getMinStorageNum().
*/
public boolean commitOrCompleteLastBlock(BlockCollection bc,
    Block commitBlock) throws IOException {
  if (commitBlock == null) {
    return false; // not committing, this is a block allocation retry
  }
  BlockInfo lastBlock = bc.getLastBlock();
  if (lastBlock == null) {
    return false; // no blocks in file yet
  }
  if (lastBlock.isComplete()) {
    return false; // already completed (e.g. by syncBlock)
  }

  final boolean b = commitBlock(
      (BlockInfoUnderConstruction) lastBlock, commitBlock);
  if(hasMinStorage(lastBlock)) {
    completeBlock(bc, bc.numBlocks()-1, false);
  }
  return b;
}

public boolean hasMinStorage(BlockInfo block) {
  return hasMinStorage(block, countNodes(block).liveReplicas());
}

public boolean hasMinStorage(BlockInfo block, int liveNum) {
  return liveNum >= getMinStorageNum(block);
}

public short getMinStorageNum(BlockInfo block) {
  return minReplication;
}


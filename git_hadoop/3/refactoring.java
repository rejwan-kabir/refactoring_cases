  @Override
  protected synchronized void writeChunk(byte[] b, int offset, int len,
      byte[] checksum, int ckoff, int cklen) throws IOException {
    ......

    // If packet is full, enqueue it for transmission
    //
    if (currentPacket.getNumChunks() == currentPacket.getMaxChunks() ||
        getStreamer().getBytesCurBlock() == blockSize) {
      if (DFSClient.LOG.isDebugEnabled()) {
        DFSClient.LOG.debug("DFSClient writeChunk packet full seqno=" +
            currentPacket.getSeqno() +
            ", src=" + src +
            ", bytesCurBlock=" + getStreamer().getBytesCurBlock() +
            ", blockSize=" + blockSize +
            ", appendChunk=" + getStreamer().getAppendChunk());
      }
      getStreamer().waitAndQueuePacket(currentPacket);
      currentPacket = null;

      adjustChunkBoundary();

      endBlock();
    }
  }

  ------------------------------------------------------------------------
  /** remove the conditional for debug log.
  * extract method enqueueCurrentPacketFull() and enqueueCurrentPacket().
  */
   @Override
  protected synchronized void writeChunk(byte[] b, int offset, int len,
      byte[] checksum, int ckoff, int cklen) throws IOException {
    ......

    // If packet is full, enqueue it for transmission
    //
    if (currentPacket.getNumChunks() == currentPacket.getMaxChunks() ||
        getStreamer().getBytesCurBlock() == blockSize) {
      enqueueCurrentPacketFull();
    }
  }

  void enqueueCurrentPacketFull() throws IOException {
    LOG.debug("enqueue full {}, src={}, bytesCurBlock={}, blockSize={},"
        + " appendChunk={}, {}", currentPacket, src, getStreamer()
        .getBytesCurBlock(), blockSize, getStreamer().getAppendChunk(),
        getStreamer());
    enqueueCurrentPacket();
    adjustChunkBoundary();
    endBlock();
  }
  void enqueueCurrentPacket() throws IOException {
    getStreamer().waitAndQueuePacket(currentPacket);
    currentPacket = null;
  }

  


****************************** case 2 ************************************

  protected void endBlock() throws IOException {
    if (getStreamer().getBytesCurBlock() == blockSize) {
      currentPacket = createPacket(0, 0, getStreamer().getBytesCurBlock(),
          getStreamer().getAndIncCurrentSeqno(), true);
      currentPacket.setSyncBlock(shouldSyncBlock);
      getStreamer().waitAndQueuePacket(currentPacket);
      currentPacket = null;
      getStreamer().setBytesCurBlock(0);
      lastFlushOffset = 0;
    }
  }

------------------------------------------------------------------------
  /**
  *  Extract method setCurrentPacketToEmpty() and reuse the enqueueCurrentPacket()
  *  method that has been extracted.
  */
  protected void endBlock() throws IOException {
    if (getStreamer().getBytesCurBlock() == blockSize) {
      setCurrentPacketToEmpty();
      enqueueCurrentPacket();
      getStreamer().setBytesCurBlock(0);
      lastFlushOffset = 0;
    }
  }

  void setCurrentPacketToEmpty() throws InterruptedIOException {
    currentPacket = createPacket(0, 0, getStreamer().getBytesCurBlock(),
        getStreamer().getAndIncCurrentSeqno(), true);
    currentPacket.setSyncBlock(shouldSyncBlock);
  }
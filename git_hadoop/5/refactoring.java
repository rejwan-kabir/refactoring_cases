  @Override
  public void run() {
      ...
      DFSPacket one;
      try {
        // process datanode IO errors if any
        boolean doSleep = false;
        if (hasError && (errorIndex >= 0 || restartingNodeIndex.get() >= 0)) {
          doSleep = processDatanodeError();
        }

      ...
          while ((!streamerClosed && !hasError && dfsClient.clientRunning
              && dataQueue.size() == 0 &&
              (stage != BlockConstructionStage.DATA_STREAMING ||
                  stage == BlockConstructionStage.DATA_STREAMING &&
                      now - lastPacket < halfSocketTimeout)) || doSleep ) {
            ...
          }
          if (streamerClosed || hasError || !dfsClient.clientRunning) {
            continue;
          }
          ...
  
          if (streamerClosed || hasError || !dfsClient.clientRunning) {
            continue;
          }
          stage = BlockConstructionStage.PIPELINE_CLOSE;
        }

      ...

        if (streamerClosed || hasError || !dfsClient.clientRunning) {
          continue;
        }

        // Is this block full?
        if (one.isLastPacketInBlock()) {
          // wait for the close packet has been acked
          synchronized (dataQueue) {
            while (!streamerClosed && !hasError &&
                ackQueue.size() != 0 && dfsClient.clientRunning) {
              dataQueue.wait(1000);// wait for acks to arrive from datanodes
            }
          }
          if (streamerClosed || hasError || !dfsClient.clientRunning) {
            continue;
          }

          endBlock();
        }
        ...
  }

  ---------------------------------------------------------------------

  /** Decompose Conditional?
  * The complex conditional (streamerClosed || errorState.hasError() || !dfsClient.clientRunning) 
  * is extracted as method shouldStop() and being reused.
  */
  private boolean shouldStop() {
    return streamerClosed || errorState.hasError() || !dfsClient.clientRunning;
  }

  public void run() {
        ...
          while ((!shouldStop() && dataQueue.size() == 0 &&
              (stage != BlockConstructionStage.DATA_STREAMING ||
                  stage == BlockConstructionStage.DATA_STREAMING &&
                      now - lastPacket < halfSocketTimeout)) || doSleep ) {
            ...
          }
          if (shouldStop()) {
            continue;
          }
          ...
          if (shouldStop()) {
            continue;
          }
          stage = BlockConstructionStage.PIPELINE_CLOSE;
        }

        ...

        if (shouldStop()) {
          continue;
        }

        // Is this block full?
        if (one.isLastPacketInBlock()) {
          // wait for the close packet has been acked
          synchronized (dataQueue) {
            while (!shouldStop() && ackQueue.size() != 0) {
              dataQueue.wait(1000);// wait for acks to arrive from datanodes
            }
          }
          if (shouldStop()) {
            continue;
          }

          endBlock();
        }
        ...
  }

**********************case 2******************************

/** Replace Data Value With Object
  * The data and behavior related to the error state become members and 
  * methods of the ErrorState class.
  */
  public void run() {
    ...
      if (hasError && response != null) {
        try {
          response.close();
          response.join();
          response = null;
        } catch (InterruptedException  e) {
          LOG.warn("Caught exception", e);
        }
      }
      ...

        hasError = true;
        if (errorIndex == -1 && restartingNodeIndex.get() == -1) {
          // Not a datanode issue
          streamerClosed = true;
        }
      } finally {
        scope.close();
      }
    }
    closeInternal();
  }

  -----------------------------------------------------------------
  public void run() {
    ...
      if (errorState.hasError() && response != null) {
        try {
          response.close();
          response.join();
          response = null;
        } catch (InterruptedException  e) {
          LOG.warn("Caught exception", e);
        }
      }
      ...
     
        errorState.setError(true);
        if (!errorState.isNodeMarked()) {
          // Not a datanode issue
          streamerClosed = true;
        }
      } finally {
        scope.close();
      }
    }
    closeInternal();
  }

  static class ErrorState {
    private boolean error = false;
    private int badNodeIndex = -1;
    private int restartingNodeIndex = -1;
    private long restartingNodeDeadline = 0;
    private final long datanodeRestartTimeout;

    ErrorState(long datanodeRestartTimeout) {
      this.datanodeRestartTimeout = datanodeRestartTimeout;
    }

   ...
    synchronized boolean hasError() {
      return error;
    }

    ...

    synchronized void setError(boolean err) {
      this.error = err;
    }

    ...

    synchronized boolean isNodeMarked() {
      return badNodeIndex >= 0 || isRestartingNode();
    }

    ...
  }
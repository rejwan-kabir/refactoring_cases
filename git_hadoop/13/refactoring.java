 //org.apache.hadoop.hdfs.server.namenode.BackupImage
  synchronized void journal(long firstTxId, int numTxns, byte[] data) throws IOException {
    if (LOG.isTraceEnabled()) {
      LOG.trace("Got journal, " +
          "state = " + bnState +
          "; firstTxId = " + firstTxId +
          "; numTxns = " + numTxns);
    }
    
    switch(bnState) {
      case DROP_UNTIL_NEXT_ROLL:
        return;

      case IN_SYNC:
        // update NameSpace in memory
        applyEdits(firstTxId, numTxns, data);
        break;
      
      case JOURNAL_ONLY:
        break;
      
      default:
        throw new AssertionError("Unhandled state: " + bnState);
    }
    
    // write to BN's local edit log.
    logEditsLocally(firstTxId, numTxns, data);
  }

//org.apache.hadoop.hdfs.server.namenode.BackupImage
  private void logEditsLocally(long firstTxId, int numTxns, byte[] data) {
    long expectedTxId = editLog.getLastWrittenTxId() + 1;
    Preconditions.checkState(firstTxId == expectedTxId,
        "received txid batch starting at %s but expected txn %s",
        firstTxId, expectedTxId);
    editLog.setNextTxId(firstTxId + numTxns - 1);
    editLog.logEdit(data.length, data);
    editLog.logSync();
  }

-----------------------------------------------------------------
/**
* Move method 
* The logEditsLocally method in class BackupImage is moved into class FSEditLog and renamed 
* to journal().
*/
//org.apache.hadoop.hdfs.server.namenode.BackupImage
  synchronized void journal(long firstTxId, int numTxns, byte[] data) throws IOException {
    if (LOG.isTraceEnabled()) {
      LOG.trace("Got journal, " +
          "state = " + bnState +
          "; firstTxId = " + firstTxId +
          "; numTxns = " + numTxns);
    }
    
    switch(bnState) {
      case DROP_UNTIL_NEXT_ROLL:
        return;

      case IN_SYNC:
        // update NameSpace in memory
        applyEdits(firstTxId, numTxns, data);
        break;
      
      case JOURNAL_ONLY:
        break;
      
      default:
        throw new AssertionError("Unhandled state: " + bnState);
    }
    
    // write to BN's local edit log.
    editLog.journal(firstTxId, numTxns, data);
  }

//org.apache.hadoop.hdfs.server.namenode.FSEditLog
  public synchronized void journal(long firstTxId, int numTxns, byte[] data) {
    final long expectedTxId = getLastWrittenTxId() + 1;
    Preconditions.checkState(firstTxId == expectedTxId,
        "received txid batch starting at %s but expected txid %s",
        firstTxId, expectedTxId);
    setNextTxId(firstTxId + numTxns - 1);
    logEdit(data.length, data);
    logSync();
  }

**********************case 2**********************************
/**
  * The code fragment in BackupImage#namednodeStartedLogSegment for logging is
  * extracted as method startLogSegment() and moved into FSEditLog. 
  */
 //org.apache.hadoop.hdfs.server.namenode.BackupImage
  synchronized void namenodeStartedLogSegment(long txid)
      throws IOException {
    LOG.info("NameNode started a new log segment at txid " + txid);
    if (editLog.isSegmentOpen()) {
      if (editLog.getLastWrittenTxId() == txid - 1) {
        // We are in sync with the NN, so end and finalize the current segment
        editLog.endCurrentLogSegment(false);
      } else {
        // We appear to have missed some transactions -- the NN probably
        // lost contact with us temporarily. So, mark the current segment
        // as aborted.
        LOG.warn("NN started new log segment at txid " + txid +
            ", but BN had only written up to txid " +
            editLog.getLastWrittenTxId() +
            "in the log segment starting at " + 
            editLog.getCurSegmentTxId() + ". Aborting this " +
            "log segment.");
        editLog.abortCurrentLogSegment();
      }
    }
    editLog.setNextTxId(txid);
    editLog.startLogSegment(txid, false);
    if (bnState == BNState.DROP_UNTIL_NEXT_ROLL) {
      setState(BNState.JOURNAL_ONLY);
    }
    
    if (stopApplyingEditsOnNextRoll) {
      if (bnState == BNState.IN_SYNC) {
        LOG.info("Stopped applying edits to prepare for checkpoint.");
        setState(BNState.JOURNAL_ONLY);
      }
      stopApplyingEditsOnNextRoll = false;
      notifyAll();
    }
  }


  ------------------------------------------------------------------
  
  //org.apache.hadoop.hdfs.server.namenode.BackupImage
  synchronized void namenodeStartedLogSegment(long txid) throws IOException {
    editLog.startLogSegment(txid, true);

    if (bnState == BNState.DROP_UNTIL_NEXT_ROLL) {
      setState(BNState.JOURNAL_ONLY);
    }
    
    if (stopApplyingEditsOnNextRoll) {
      if (bnState == BNState.IN_SYNC) {
        LOG.info("Stopped applying edits to prepare for checkpoint.");
        setState(BNState.JOURNAL_ONLY);
      }
      stopApplyingEditsOnNextRoll = false;
      notifyAll();
    }
  }

  //org.apache.hadoop.hdfs.server.namenode.FSEditLog
  public synchronized void startLogSegment(long txid, 
      boolean abortCurrentLogSegment) throws IOException {
    LOG.info("Namenode started a new log segment at txid " + txid);
    if (isSegmentOpen()) {
      if (getLastWrittenTxId() == txid - 1) {
        //In sync with the NN, so end and finalize the current segment`
        endCurrentLogSegment(false);
      } else {
        //Missed some transactions: probably lost contact with NN temporarily.
        final String mess = "Cannot start a new log segment at txid " + txid
            + " since only up to txid " + getLastWrittenTxId()
            + " have been written in the log segment starting at "
            + getCurSegmentTxId() + ".";
        if (abortCurrentLogSegment) {
          //Mark the current segment as aborted.
          LOG.warn(mess);
          abortCurrentLogSegment();
        } else {
          throw new IOException(mess);
        }
      }
    }
    setNextTxId(txid);
    startLogSegment(txid);
  }


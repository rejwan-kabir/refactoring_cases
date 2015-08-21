private synchronized DatanodeInfo blockSeekTo(long target) throws IOException {
  ...
      } else if ((ex instanceof InvalidBlockTokenException || ex instanceof InvalidToken)
          && refetchToken > 0) {
        DFSClient.LOG.info("Will fetch a new access token and retry, " 
            + "access token was invalid when connecting to " + targetAddr
            + " : " + ex);
        /*
         * Get a new access token and retry. Retry is needed in 2 cases. 1)
         * When both NN and DN re-started while DFSClient holding a cached
         * access token. 2) In the case that NN fails to update its
         * access key at pre-set interval (by a wide margin) and
         * subsequently restarts. In this case, DN re-registers itself with
         * NN and receives a new access key, but DN will delete the old
         * access key from its memory since it's considered expired based on
         * the estimated expiration date.
         */
        refetchToken--;
        fetchBlockAt(target);
      } 
  ...
}
private void fetchBlockByteRange(LocatedBlock block, long start, long end,
    byte[] buf, int offset,
    Map<ExtendedBlock, Set<DatanodeInfo>> corruptedBlockMap)
    throws IOException {
  ...
      } else if ((e instanceof InvalidBlockTokenException || e instanceof InvalidToken)
          && refetchToken > 0) {
        DFSClient.LOG.info("Will get a new access token and retry, "
            + "access token was invalid when connecting to " + targetAddr
            + " : " + e);
        refetchToken--;
        fetchBlockAt(block.getStartOffset());
        continue;
      } ...
}

-------------------------------------------------------------------
/**
* The conditional (e instanceof InvalidBlockTokenException || e instanceof InvalidToken)
* and its related log is extracted into method tokenRefetchNeeded().
*/
private synchronized DatanodeInfo blockSeekTo(long target) throws IOException {
  ...
      } else if (refetchToken > 0 && tokenRefetchNeeded(ex, targetAddr)) {
        refetchToken--;
        fetchBlockAt(target);
      } ...
}

private void fetchBlockByteRange(LocatedBlock block, long start, long end,
    byte[] buf, int offset,
    Map<ExtendedBlock, Set<DatanodeInfo>> corruptedBlockMap)
    throws IOException {
...
      } else if (refetchToken > 0 && tokenRefetchNeeded(e, targetAddr)) {
        refetchToken--;
        fetchBlockAt(block.getStartOffset());
        continue;
      } ...
}

private static boolean tokenRefetchNeeded(IOException ex,
    InetSocketAddress targetAddr) {
  /*
   * Get a new access token and retry. Retry is needed in 2 cases. 1)
   * When both NN and DN re-started while DFSClient holding a cached
   * access token. 2) In the case that NN fails to update its
   * access key at pre-set interval (by a wide margin) and
   * subsequently restarts. In this case, DN re-registers itself with
   * NN and receives a new access key, but DN will delete the old
   * access key from its memory since it's considered expired based on
   * the estimated expiration date.
   */
  if (ex instanceof InvalidBlockTokenException || ex instanceof InvalidToken) {
    DFSClient.LOG.info("Access token was invalid when connecting to "
        + targetAddr + " : " + ex);
    return true;
  }
  return false;
}

private synchronized void fence() throws Exception {
	if (LOG.isTraceEnabled()) {
	  logRootNodeAcls("Before fencing\n");
	}

	new ZKAction<Void>() {
	  @Override
	  public Void run() throws KeeperException, InterruptedException {
	    zkClient.setACL(zkRootNodePath, zkRootNodeAcl, -1);
	    return null;
	  }
	}.runWithRetries();

	// delete fencingnodepath
	new ZKAction<Void>() {
	  @Override
	  public Void run() throws KeeperException, InterruptedException {
	    try {
	      zkClient.multi(Collections.singletonList(deleteFencingNodePathOp));
	    } catch (KeeperException.NoNodeException nne) {
	      LOG.info("Fencing node " + fencingNodePath + " doesn't exist to delete");
	    }
	    return null;
	  }
	}.runWithRetries();

	if (LOG.isTraceEnabled()) {
	  logRootNodeAcls("After fencing\n");
	}
}

-------------------------------------------------------------------------
// Refactor to use apache curator framework (a high-level API that greatly simplifies using ZooKeeper)

private synchronized void fence() throws Exception {
    if (LOG.isTraceEnabled()) {
      logRootNodeAcls("Before fencing\n");
    }

    curatorFramework.setACL().withACL(zkRootNodeAcl).forPath(zkRootNodePath);
    delete(fencingNodePath);

    if (LOG.isTraceEnabled()) {
      logRootNodeAcls("After fencing\n");
    }
  }
protected static void dumpTreeRecursively(PrintWriter out,
      StringBuilder prefix, Iterable<Pair<? extends INode, Snapshot>> subs) {
  if (subs != null) {
    for(final Iterator<Pair<? extends INode, Snapshot>> i = subs.iterator(); i.hasNext();) {
      final Pair<? extends INode, Snapshot> pair = i.next();
      prefix.append(i.hasNext()? DUMPTREE_EXCEPT_LAST_ITEM: DUMPTREE_LAST_ITEM);
      pair.left.dumpTreeRecursively(out, prefix, pair.right);
      prefix.setLength(prefix.length() - 2);
    }
  }
}

--------------------------------------------------------
/**
* replace the Pair < ? extends INode, Snapshot > with class SnapshotAndINode
*/
protected static void dumpTreeRecursively(PrintWriter out,
      StringBuilder prefix, Iterable<SnapshotAndINode> subs) {
  if (subs != null) {
    for(final Iterator<SnapshotAndINode> i = subs.iterator(); i.hasNext();) {
      final SnapshotAndINode pair = i.next();
      prefix.append(i.hasNext()? DUMPTREE_EXCEPT_LAST_ITEM: DUMPTREE_LAST_ITEM);
      pair.inode.dumpTreeRecursively(out, prefix, pair.snapshot);
      prefix.setLength(prefix.length() - 2);
    }
  }
}

/** A pair of Snapshot and INode objects. */
protected static class SnapshotAndINode {
  public final Snapshot snapshot;
  public final INode inode;

  public SnapshotAndINode(Snapshot snapshot, INode inode) {
    this.snapshot = snapshot;
    this.inode = inode;
  }

  public SnapshotAndINode(Snapshot snapshot) {
    this(snapshot, snapshot.getRoot());
  }
}
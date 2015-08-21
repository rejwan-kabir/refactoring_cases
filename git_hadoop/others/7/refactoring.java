  private static DirectoryListing getListing(FSDirectory fsd, INodesInPath iip,
      String src, byte[] startAfter, boolean needLocation, boolean isSuperUser)
      throws IOException {
    ...

      if (!targetNode.isDirectory()) {
        return new DirectoryListing(
            new HdfsFileStatus[]{createFileStatus(fsd, src,
                HdfsFileStatus.EMPTY_NAME, targetNode, needLocation,
                parentStoragePolicy, snapshot, isRawPath, iip)}, 0);
      }

      ...
    }
  }
  static HdfsFileStatus createFileStatus(
      FSDirectory fsd, String fullPath, byte[] path, INode node,
      boolean needLocation, byte storagePolicy, int snapshot, boolean isRawPath,
      INodesInPath iip)
      throws IOException {
    if (needLocation) {
      return createLocatedFileStatus(fsd, fullPath, path, node, storagePolicy,
          snapshot, isRawPath, iip);
    } else {
      return createFileStatus(fsd, fullPath, path, node, storagePolicy, snapshot,
          isRawPath, iip);
    }
  }
  static HdfsFileStatus createFileStatus(
      FSDirectory fsd, String fullPath, byte[] path, INode node,
      byte storagePolicy, int snapshot, boolean isRawPath,
      INodesInPath iip) throws IOException {
     ...

     INodeAttributes nodeAttrs =
         fsd.getAttributes(fullPath, path, node, snapshot);
     return new HdfsFileStatus(
        size,
        node.isDirectory(),
        replication,
        blocksize,
        node.getModificationTime(snapshot),
        node.getAccessTime(snapshot),
        getPermissionForFileStatus(nodeAttrs, isEncrypted),
        nodeAttrs.getUserName(),
        nodeAttrs.getGroupName(),
        node.isSymlink() ? node.asSymlink().getSymlink() : null,
        path,
        node.getId(),
        childrenNum,
        feInfo,
        storagePolicy);
  }
  ----------------------------------------------------
  /**
  * The signature of method createFileStatus is changed. Before refactoring,
  * the argument nodeAttrs is generated inside the method from the argument 
  * fullPath. After refactoring, the nodeAttrs is generated outside of the 
  * method and passed in as an argument.
  */
    private static DirectoryListing getListing(FSDirectory fsd, INodesInPath iip,
      String src, byte[] startAfter, boolean needLocation, boolean isSuperUser)
      throws IOException {
    ...

      if (!targetNode.isDirectory()) {
        INodeAttributes nodeAttrs = getINodeAttributes(
            fsd, src, HdfsFileStatus.EMPTY_NAME, targetNode,
            snapshot);
        return new DirectoryListing(
            new HdfsFileStatus[]{ createFileStatus(
                fsd, HdfsFileStatus.EMPTY_NAME, targetNode, nodeAttrs,
                needLocation, parentStoragePolicy, snapshot, isRawPath, iip)
            }, 0);
      }

      ...
  }

  private static INodeAttributes getINodeAttributes(
      FSDirectory fsd, String fullPath, byte[] path, INode node, int snapshot) {
    return fsd.getAttributes(fullPath, path, node, snapshot);
  }

  private static HdfsFileStatus createFileStatus(
      FSDirectory fsd, byte[] path, INode node, INodeAttributes nodeAttrs,
      boolean needLocation, byte storagePolicy, int snapshot, boolean isRawPath,
      INodesInPath iip)
      throws IOException {
    if (needLocation) {
      return createLocatedFileStatus(fsd, path, node, nodeAttrs, storagePolicy,
                                     snapshot, isRawPath, iip);
    } else {
      return createFileStatus(fsd, path, node, nodeAttrs, storagePolicy,
                              snapshot, isRawPath, iip);
    }
  }

  static HdfsFileStatus createFileStatus(
      FSDirectory fsd, byte[] path, INode node,
      INodeAttributes nodeAttrs, byte storagePolicy, int snapshot,
      boolean isRawPath, INodesInPath iip) throws IOException {
    ...

    return new HdfsFileStatus(
        size,
        node.isDirectory(),
        replication,
        blocksize,
        node.getModificationTime(snapshot),
        node.getAccessTime(snapshot),
        getPermissionForFileStatus(nodeAttrs, isEncrypted),
        nodeAttrs.getUserName(),
        nodeAttrs.getGroupName(),
        node.isSymlink() ? node.asSymlink().getSymlink() : null,
        path,
        node.getId(),
        childrenNum,
        feInfo,
        storagePolicy);
  }
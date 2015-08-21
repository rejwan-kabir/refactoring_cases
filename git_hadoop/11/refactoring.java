  /**
  *	Extract Class
  * The EncryptionZone Functionality is extracted into the new class EncryptionZoneManager
  */
  XAttr createEncryptionZone(String src, String keyId)
    throws IOException {
    writeLock();
    try {
      if (isNonEmptyDirectory(src)) {
        throw new IOException(
          "Attempt to create an encryption zone for a non-empty directory.");
      }

      final INodesInPath srcIIP = getINodesInPath4Write(src, false);
      final EncryptionZoneInt ezi = getEncryptionZoneForPath(srcIIP);
      if (ezi != null) {
        throw new IOException("Directory " + src +
          " is already in an encryption zone. (" + ezi.getFullPathName() + ")");
      }

      final XAttr keyIdXAttr =
        XAttrHelper.buildXAttr(CRYPTO_XATTR_ENCRYPTION_ZONE, keyId.getBytes());
      final List<XAttr> xattrs = Lists.newArrayListWithCapacity(1);
      xattrs.add(keyIdXAttr);
      final INode inode = unprotectedSetXAttrs(src, xattrs,
        EnumSet.of(XAttrSetFlag.CREATE));
      encryptionZones.put(inode.getId(),
          new EncryptionZoneInt(keyId, inode.getId()));
      return keyIdXAttr;
    } finally {
      writeUnlock();
    }
  }

------------------------------------------------------------------------

  XAttr createEncryptionZone(String src, String keyId)
    throws IOException {
    writeLock();
    try {
      return ezManager.createEncryptionZone(src, keyId);
    } finally {
      writeUnlock();
    }
  }

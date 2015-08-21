@Override
public boolean rename(Path src, Path dst) throws IOException {
  // Attempt rename using Java API.
  File srcFile = pathToFile(src);
  File dstFile = pathToFile(dst);
  if (srcFile.renameTo(dstFile)) {
    return true;
  }

  // Enforce POSIX rename behavior that a source directory replaces an existing
  // destination if the destination is an empty directory.  On most platforms,
  // this is already handled by the Java API call above.  Some platforms
  // (notably Windows) do not provide this behavior, so the Java API call above
  // fails.  Delete destination and attempt rename again.
  if (this.exists(dst)) {
    FileStatus sdst = this.getFileStatus(dst);
    if (sdst.isDirectory() && dstFile.list().length == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Deleting empty destination and renaming " + src + " to " +
          dst);
      }
      if (this.delete(dst, false) && srcFile.renameTo(dstFile)) {
        return true;
      }
    }
  }

  // The fallback behavior accomplishes the rename by a full copy.
  if (LOG.isDebugEnabled()) {
    LOG.debug("Falling through to a copy of " + src + " to " + dst);
  }
  return FileUtil.copy(this, src, this, dst, true, getConf());
}

--------------------------------------------------------------------
/**
* The code fragment for enforcing POSIX rename behavior is extracted as a method
* handleEmptyDstDirectoryOnWindows().
* Allows testing this behavior seperately in test case.
*/
@Override
public boolean rename(Path src, Path dst) throws IOException {
  // Attempt rename using Java API.
  File srcFile = pathToFile(src);
  File dstFile = pathToFile(dst);
  if (srcFile.renameTo(dstFile)) {
    return true;
  }

  // Else try POSIX style rename on Windows only
  if (Shell.WINDOWS &&
      handleEmptyDstDirectoryOnWindows(src, srcFile, dst, dstFile)) {
    return true;
  }

  // The fallback behavior accomplishes the rename by a full copy.
  if (LOG.isDebugEnabled()) {
    LOG.debug("Falling through to a copy of " + src + " to " + dst);
  }
  return FileUtil.copy(this, src, this, dst, true, getConf());
}

@VisibleForTesting
public final boolean handleEmptyDstDirectoryOnWindows(Path src, File srcFile,
    Path dst, File dstFile) throws IOException {

  // Enforce POSIX rename behavior that a source directory replaces an
  // existing destination if the destination is an empty directory. On most
  // platforms, this is already handled by the Java API call above. Some
  // platforms (notably Windows) do not provide this behavior, so the Java API
  // call renameTo(dstFile) fails. Delete destination and attempt rename
  // again.
  if (this.exists(dst)) {
    FileStatus sdst = this.getFileStatus(dst);
    if (sdst.isDirectory() && dstFile.list().length == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Deleting empty destination and renaming " + src + " to " +
          dst);
      }
      if (this.delete(dst, false) && srcFile.renameTo(dstFile)) {
        return true;
      }
    }
  }
  return false;
}

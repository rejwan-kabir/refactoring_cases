/**
*	A refactoring to avoid using lock
*/
  private void setACLs(Configuration conf) {
    lock.writeLock().lock();
    try {
      acls = new HashMap<Type, AccessControlList>();
      for (Type aclType : Type.values()) {
        String aclStr = conf.get(aclType.getConfigKey(), ACL_DEFAULT);
        acls.put(aclType, new AccessControlList(aclStr));
        LOG.info("'{}' ACL '{}'", aclType, aclStr);
      }
    } finally {
      lock.writeLock().unlock();
    }
  }

  public boolean hasAccess(Type type, String user) {
    UserGroupInformation ugi = UserGroupInformation.createRemoteUser(user);
    AccessControlList acl = null;
    lock.readLock().lock();
    try {
      acl = acls.get(type);
    } finally {
      lock.readLock().unlock();
    }
    return acl.isUserAllowed(ugi);
  }

--------------------------------------------------------------------------

/**
* Write to acls is on the tempAcls, read is on acls, avoid using lock.
*/
private void setACLs(Configuration conf) {
	Map<Type, AccessControlList> tempAcls = new HashMap<Type, AccessControlList>();
	for (Type aclType : Type.values()) {
	  String aclStr = conf.get(aclType.getConfigKey(), ACL_DEFAULT);
	  tempAcls.put(aclType, new AccessControlList(aclStr));
	  LOG.info("'{}' ACL '{}'", aclType, aclStr);
	}
	acls = tempAcls;
}

public boolean hasAccess(Type type, String user) {
	UserGroupInformation ugi = UserGroupInformation.createRemoteUser(user);
	return acls.get(type).isUserAllowed(ugi);
}
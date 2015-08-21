  private void buildACL(String aclString) {
    users = new TreeSet<String>();
    groups = new TreeSet<String>();
    if (isWildCardACLValue(aclString)) {
      allAllowed = true;
    } else {
      allAllowed = false;
      String[] userGroupStrings = aclString.split(" ", 2);

      if (userGroupStrings.length >= 1) {
        List<String> usersList = new LinkedList<String>(
          Arrays.asList(userGroupStrings[0].split(",")));
        cleanupList(usersList);
        addToSet(users, usersList);
      }
      
      if (userGroupStrings.length == 2) {
        List<String> groupsList = new LinkedList<String>(
          Arrays.asList(userGroupStrings[1].split(",")));
        cleanupList(groupsList);
        addToSet(groups, groupsList);
        groupsMapping.cacheGroupsAdd(groupsList);
      }
    }
  }

  private static final void cleanupList(List<String> list) {
    ListIterator<String> i = list.listIterator();
    while(i.hasNext()) {
      String s = i.next();
      if(s.length() == 0) {
        i.remove();
      } else {
        s = s.trim();
        i.set(s);
      }
    }
  }
  
  private static final void addToSet(Set<String> set, List<String> list) {
    for(String s : list) {
      set.add(s);
    }
  }


--------------------------------------------------------
/**
* Refactor to use utitlity functions
*/
  private void buildACL(String aclString) {
    users = new HashSet<String>();
    groups = new HashSet<String>();
    if (isWildCardACLValue(aclString)) {
      allAllowed = true;
    } else {
      allAllowed = false;
      String[] userGroupStrings = aclString.split(" ", 2);
      
      if (userGroupStrings.length >= 1) {
        users = StringUtils.getTrimmedStringCollection(userGroupStrings[0]);
      } 
      
      if (userGroupStrings.length == 2) {
        groups = StringUtils.getTrimmedStringCollection(userGroupStrings[1]);
        groupsMapping.cacheGroupsAdd(new LinkedList<String>(groups));
      }
    }
  }
  
  // org.apache.hadoop.util.StringUtils
  public static Collection<String> getTrimmedStringCollection(String str){
    Set<String> set = new LinkedHashSet<String>(
      Arrays.asList(getTrimmedStrings(str)));
    set.remove("");
    return set;
  }

  public static String[] getTrimmedStrings(String str){
    if (null == str || str.trim().isEmpty()) {
      return emptyStringArray;
    }

    return str.trim().split("\\s*,\\s*");
  }
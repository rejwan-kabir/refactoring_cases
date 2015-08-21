public final DirectoryWithQuotaFeature getDirectoryWithQuotaFeature() {
	for (Feature f : features) {
	  if (f instanceof DirectoryWithQuotaFeature) {
	    return (DirectoryWithQuotaFeature)f;
	  }
	}
	return null;
}

public final DirectoryWithSnapshotFeature getDirectoryWithSnapshotFeature() {
	for (Feature f : features) {
	  if (f instanceof DirectoryWithSnapshotFeature) {
	    return (DirectoryWithSnapshotFeature) f;
	  }
	}
	return null;
}


----------------------------------------------------------------------------
/**
*	Refactor to use helper method. 
*	Note the implementation of the helper method is not the same as the code
*	fragment before refactoring.
*/
public final DirectoryWithQuotaFeature getDirectoryWithQuotaFeature() {
	return getFeature(DirectoryWithQuotaFeature.class);
}

public final DirectoryWithSnapshotFeature getDirectoryWithSnapshotFeature() {
	return getFeature(DirectoryWithSnapshotFeature.class);
}

// org/apache/hadoop/hdfs/server/namenode/INodeWithAdditionalFields.java
protected <T extends Feature> T getFeature(Class<? extends Feature> clazz) {
	for (Feature f : features) {
	  if (f.getClass() == clazz) {
	    @SuppressWarnings("unchecked")
	    T ret = (T) f;
	    return ret;
	  }
	}
	return null;
}

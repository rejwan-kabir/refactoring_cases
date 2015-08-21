  
/**
 * Change StringMap to SaverContext 
 */

public static class StringMap {
    private final Map<String, Integer> stringMap;

    public StringMap() {
      stringMap = Maps.newHashMap();
    }

    int getStringId(String str) {
      if (str == null) {
        return 0;
      }
      Integer v = stringMap.get(str);
      if (v == null) {
        int nv = stringMap.size() + 1;
        stringMap.put(str, nv);
        return nv;
      }
      return v;
    }

    int size() {
      return stringMap.size();
    }

    Set<Entry<String, Integer>> entrySet() {
      return stringMap.entrySet();
    }
  }

  private void saveStringTableSection(FileSummary.Builder summary)
      throws IOException {
    OutputStream out = sectionOutputStream;
    StringTableSection.Builder b = StringTableSection.newBuilder()
        .setNumEntry(stringMap.size());
    b.build().writeDelimitedTo(out);
    for (Entry<String, Integer> e : stringMap.entrySet()) {
      StringTableSection.Entry.Builder eb = StringTableSection.Entry
          .newBuilder().setId(e.getValue()).setStr(e.getKey());
      eb.build().writeDelimitedTo(out);
    }
    commitSection(summary, SectionName.STRING_TABLE);
  }

 ---------------------------------------------------------- 
  public static final class SaverContext {
    public static class DeduplicationMap<E> {
      private final Map<E, Integer> map = Maps.newHashMap();
      private DeduplicationMap() {}

      static <T> DeduplicationMap<T> newMap() {
        return new DeduplicationMap<T>();
      }

      int getId(E value) {
        if (value == null) {
          return 0;
        }
        Integer v = map.get(value);
        if (v == null) {
          int nv = map.size() + 1;
          map.put(value, nv);
          return nv;
        }
        return v;
      }

      int size() {
        return map.size();
      }

      Set<Entry<E, Integer>> entrySet() {
        return map.entrySet();
      }
    }
    private final DeduplicationMap<String> stringMap = DeduplicationMap.newMap();

    public DeduplicationMap<String> getStringMap() {
      return stringMap;
    }
  }


  private void saveStringTableSection(FileSummary.Builder summary)
      throws IOException {
    OutputStream out = sectionOutputStream;
    StringTableSection.Builder b = StringTableSection.newBuilder()
        .setNumEntry(saverContext.stringMap.size());
    b.build().writeDelimitedTo(out);
    for (Entry<String, Integer> e : saverContext.stringMap.entrySet()) {
      StringTableSection.Entry.Builder eb = StringTableSection.Entry
          .newBuilder().setId(e.getValue()).setStr(e.getKey());
      eb.build().writeDelimitedTo(out);
    }
    commitSection(summary, SectionName.STRING_TABLE);
  }

************************case 2*************************
/**
* Repalce Data Value with Object
*/
private String[] stringTable;
 
-------------------------------------------------

  public static final class LoaderContext {
    private String[] stringTable;

    public String[] getStringTable() {
      return stringTable;
    }
  }



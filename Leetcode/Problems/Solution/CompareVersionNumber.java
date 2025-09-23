public class CompareVersionNumber {

  public int compareVersion(String version1, String version2) {
    int current1 = 0;
    int current2 = 0;
    int i = 0, j = 0;
    while (i < version1.length() && j < version2.length()) {
      char c1 = version1.charAt(i);
      char c2 = version2.charAt(j);
      if (c1 != '.' && c2 != '.') {
        current1 = current1 * 10 + (c1 - '0');
        current2 = current2 * 10 + (c2 - '0');
        i++;
        j++;
      }
      if (c1 == '.' && c2 != '.') {
        current2 = current2 * 10 + (c2 - '0');
        j++;
      }
      if (c1 != '.' && c2 == '.') {
        current1 = current1 * 10 + (c1 - '0');
        i++;
      }
      if (c1 == '.' && c2 == '.') {
        if (current1 != current2) {
          return Integer.compare(current1, current2);
        }
        current1 = 0;
        current2 = 0;
        i++;
        j++;
      }
    }
//    if(current1 != current2){
//      return Integer.compare(current1,current2);
//    }
    while (j < version2.length()) {
      char c2 = version2.charAt(j);
      if (c2 == '.') {
        if (current1 != current2) {
          return Integer.compare(current1, current2);
        }
        current1=0;
        current2 = 0;
        j++;
        continue;
      }
      current2 = current2 * 10 + (c2 - '0');
      j++;
    }
    while (i < version1.length()) {
      char c1 = version1.charAt(i);
      if (c1 == '.') {
        if (current1 != current2) {
          return Integer.compare(current1, current2);
        }
        current1 = 0;
        current2=0;
        i++;
        continue;
      }
      current1 = current1 * 10 + (c1 - '0');
      i++;
    }
    return Integer.compare(current1, current2);
  }

  public void main(String[] args) {
    System.out.println(compareVersion("1.0.1", "1.01"));
  }
}

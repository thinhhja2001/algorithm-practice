package Weekly527;

import java.util.ArrayList;
import java.util.List;

public class FindMismatchedSegments {

  public static List<List<String>> findMismatchedSegments(String s1, String s2) {

    List<List<String>> result = new ArrayList<>();
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        sb1.append(s1.charAt(i));
        sb2.append(s2.charAt(i));
      } else {
        if (!sb1.isEmpty()) {
          result.add(List.of(sb1.toString(), sb2.toString()));
          sb1 = new StringBuilder();
          sb2 = new StringBuilder();
        }
      }
    }
    if (!sb1.isEmpty()) {
      result.add(List.of(sb1.toString(), sb2.toString()));

    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(findMismatchedSegments("earth", "empty"));
  }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloseStrings {

  public static boolean closeStrings(String word1, String word2) {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    for (Character c : word1.toCharArray()) {
      if (!map1.containsKey(c)) {
        map1.put(c, 0);
      } else {
        map1.put(c, map1.get(c) + 1);

      }
    }

    for (Character c : word2.toCharArray()) {
      if (!map2.containsKey(c)) {
        map2.put(c, 0);
      } else {
        map2.put(c, map2.get(c) + 1);
      }
    }

    for (Character c : map1.keySet()) {
      if (!map2.containsKey(c)) {
        return false;
      }
    }

    for (Character c : map2.keySet()) {
      if (!map1.containsKey(c)) {
        return false;
      }
    }

    List<Integer> l1 = new ArrayList<>(map1.values().stream().toList());
    List<Integer> l2 = new ArrayList<>(map2.values().stream().toList());
    Collections.sort(l1);
    Collections.sort(l2);
    return l1.equals(l2);
  }

  public static void main(String[] args) {
    String word1 = "cabbba";
    String word2 = "abbccc";
    System.out.println(closeStrings(word1, word2));
  }
}

import java.util.HashMap;
import java.util.Map;

public class CheckIfStringsCanBeMadeEqualWithOperation2 {

  public static boolean checkStrings(String s1, String s2) {
    Map<Character, Integer> evenChar = new HashMap<>();
    Map<Character, Integer> oddChar = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      Character c = s1.charAt(i);
      if (i % 2 == 0) {
        evenChar.put(c, evenChar.getOrDefault(c, 0) + 1);
      } else {
        oddChar.put(c, oddChar.getOrDefault(c, 0) + 1);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      Character c = s2.charAt(i);
      if (i % 2 == 0) {
        evenChar.put(c, evenChar.getOrDefault(c, 0) - 1);
      } else {
        oddChar.put(c, oddChar.getOrDefault(c, 0) - 1);
      }
    }

    for (Character c : evenChar.keySet()) {
      if (evenChar.get(c) != 0) {
        return false;
      }
    }

    for (Character c : oddChar.keySet()) {
      if (oddChar.get(c) != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s1 = "abe";
    String s2 = "bea";
    System.out.println(checkStrings(s1,s2));
  }
}

import java.util.HashMap;
import java.util.Map;

public class CountCaesarCipherPair {

  public long countPairs(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String w : words) {
      int k = 26 - (w.charAt(0) - 'a');
      StringBuilder sb = new StringBuilder();
      for (Character c : w.toCharArray()) {
        Character newChar = (char) (((int) c + k - 97) % 26 + 97);
        sb.append(newChar);
      }
      String key = sb.toString();
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    long result = 0;
    for (int v : map.values()) {
      result += (long) v * (v - 1) / 2;
    }
    return result;
  }

  void main() {
    String[] words = {"a", "a", "a"};
    System.out.println(countPairs(words));
  }
}

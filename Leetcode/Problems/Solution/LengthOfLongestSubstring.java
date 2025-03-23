import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    int l = 0;
    int result = 0;
    Set<Character> check = new HashSet<>();
    for (int r = 0; r < s.length(); r++) {
      Character c = s.charAt(r);
      while (check.contains(c)) {
        check.remove(s.charAt(l));
        l++;
      }
      check.add(c);
      result = Math.max(result, r - l + 1);
    }
    return result;
  }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }
}

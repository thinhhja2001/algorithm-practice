import java.util.Set;

public class MaxVowels {

  public static int maxVowels(String s, int k) {
    Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    int max;
    int temp = 0;
    for (int i = 0; i < k; i++) {
      if (VOWELS.contains(s.charAt(i))) {
        temp++;
      }
    }
    max = temp;
    int n = s.length();
    for (int i = k; i < n; i++) {
      if (VOWELS.contains(s.charAt(i - k))) {
        temp--;
      }
      if (VOWELS.contains(s.charAt(i))) {
        temp++;
      }
      max = Math.max(max, temp);
    }
    return max;
  }

  public static void main(String[] args) {
    String s = "novowels";
    int k = 1;
    System.out.println(maxVowels(s, k));
  }
}
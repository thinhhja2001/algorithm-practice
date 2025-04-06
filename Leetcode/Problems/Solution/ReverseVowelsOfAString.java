import java.util.Set;
import java.util.Stack;

public class ReverseVowelsOfAString {

  public static boolean isVowel(Character character) {
    Set<Character> VOWEL_CHARACTER = Set.of('a', 'e', 'i', 'o', 'u');
    return VOWEL_CHARACTER.contains(Character.toLowerCase(character));
  }

  public static String reverseVowels(String s) {
    Stack<Character> chars = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (isVowel(c)) {
        chars.push(c);
      }
    }
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < sb.length(); i++) {
      if (isVowel(s.charAt(i))) {
        sb.setCharAt(i, chars.pop());
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String a = "IceCreAm";
    System.out.println(reverseVowels(a));
  }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DecodeString {

  public static boolean isNumber(Character c) {
    return c >= '0' && c <= '9';
  }

  public static boolean isCharacter(Character c) {
    return c >= 'a' && c <= 'z';
  }

  public static String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ']') {
        stack.push(s.charAt(i));
      } else {
        String subString = "";
        while (isCharacter(stack.peek())) {
          subString = stack.pop() + subString;
        }
        stack.pop();
        String k = "";
        while (!stack.isEmpty() && isNumber(stack.peek())) {
          k = stack.pop() + k;
        }
        Integer repetition = Integer.valueOf(k);
        while (repetition != 0) {
          repetition--;
          stack.addAll(toCharList(subString));
        }
      }
    }
    return stack.stream().map(Object::toString).collect(Collectors.joining());
  }

  private static List<Character> toCharList(String subString) {
    List<Character> characters = new ArrayList<>();
    for (char c : subString.toCharArray()) {
      characters.add(c);
    }
    return characters;
  }

  public static void main(String[] args) {
    String s1 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
    System.out.println(decodeString(s1));
    // 2 2 1 4 2 1 1
    // y pq jk e f
    // zzz
  }
}


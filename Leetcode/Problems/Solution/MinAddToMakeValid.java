import java.util.Stack;

public class MinAddToMakeValid {

  public static int minAddToMakeValid(String s) {
    Stack<Character> chars = new Stack();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if ('(' == s.charAt(i)) {
        chars.push(s.charAt(i));
      }
      if (')' == s.charAt(i)) {
        if (chars.isEmpty()) {
          count++;
          continue;
        }
        chars.pop();
      }
    }
    return count + chars.size();
  }

  public static void main(String[] args) {

  }
}

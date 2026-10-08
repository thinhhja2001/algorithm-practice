import java.util.Stack;

public class RemoveOutermostParentheses {

  public static String removeOuterParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
    for (Character ch : s.toCharArray()) {
      if (ch.equals('(')) {
        stack.push(ch);
        if (stack.size() == 1) {
          continue;
        }
        result.append(ch);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          continue;
        }
        result.append(ch);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String s = "()()";
    System.out.println(removeOuterParentheses(s));
  }
}

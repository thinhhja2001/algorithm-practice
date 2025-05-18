import java.util.Stack;

public class RemovingStarFromAString {

  public static String removeStars(String s) {
    Stack<Character> stack = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (!c.equals('*')) {
        stack.push(c);
      } else {
        stack.pop();
      }
    }
    StringBuilder res = new StringBuilder();
    stack.forEach(res::append);
    return res.toString();
  }

  public static void main(String[] args) {
    String s = "leet**cod*e";
    System.out.println(removeStars(s));
  }
}

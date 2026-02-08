package Weekly488;

import java.util.List;
import java.util.Stack;

public class MergeAdjacentEqualElements {

  public static List<Long> mergeAdjacent(int[] nums) {
    Stack<Long> stack = new Stack<>();
    for (int num : nums) {
      long x = num;
      while (!stack.isEmpty() && stack.peek() == x) {
        x += stack.pop();
      }
      stack.add(x);
    }
    return stack;
  }

  static void main() {
    int[] nums = {2, 1, 1, 2};
    System.out.println(mergeAdjacent(nums));
  }
}

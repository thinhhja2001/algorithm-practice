package Weekly519;

import java.util.List;
import java.util.Stack;

public class CountShadowPairs {


  public static int leftMostSearch(List<Integer> list, int number) {
    int left = 0;
    int right = list.size();
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (number > list.get(mid)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  public static long shadowPairs(int[] nums) {
    long count = 0;

    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {

      while (!stack.isEmpty() && num < stack.peek()) {
        stack.pop();
      }
      count += leftMostSearch(stack, num);
      stack.push(num);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {3, 1, 4, 1, 5};

    System.out.println(leftMostSearch(List.of(3, 3, 3, 5), 4));
//    System.out.println(shadowPairs(nums));
  }
}

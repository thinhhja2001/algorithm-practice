import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SeparateDigitsInAnArray {

  public static int[] separateDigits(int[] nums) {
    List<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      while (num != 0) {
        stack.add(num % 10);
        num = num / 10;
      }
      while (!stack.isEmpty()) {
        result.add(stack.pop());
      }
    }

    int[] primitive = new int[result.size()];
    int i = 0;
    for (int num : result) {
      primitive[i++] = num;
    }
    return primitive;
  }

  public static void main(String[] args) {
    int[] nums = {13, 25, 83, 77};
    System.out.println(Arrays.toString(separateDigits(nums)));
  }
}

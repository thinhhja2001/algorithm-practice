import java.util.Arrays;

public class LeftAndRightSumDistances {

  public static int[] leftRightDifference(int[] nums) {
    int rightSum = 0;
    for (int num : nums) {
      rightSum += num;
    }

    int leftSum = 0;

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      result[i] = Math.abs(rightSum - leftSum);
      leftSum += nums[i];
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1};
    System.out.println(Arrays.toString(leftRightDifference(nums)));
  }
}

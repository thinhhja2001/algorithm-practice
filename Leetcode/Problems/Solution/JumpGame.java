import java.util.Arrays;

public class JumpGame {

  public boolean canJump(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true;
    int previousIndex = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] + i >= previousIndex && dp[previousIndex] == true) {
        dp[i] = true;
        previousIndex = i;
      }
    }
    return dp[0];
  }

  void main() {
    int[] nums = {3, 2, 1, 0, 4};
    System.out.println(canJump(nums));
  }
}

public class GreatestSumDivisibleByThree {

  public int maxSumDivThree(int[] nums) {
    int length = nums.length + 1;
    int[][] dp = new int[length][3];
    dp[0][0] = 0;
    dp[0][1] = -10000;
    dp[0][2] = -10000;
    for (int i = 1; i < length; i++) {
      int x = nums[i - 1];
      for (int j = 0; j < 3; j++) {
        int previousRemainder = (j - x % 3 + 3) % 3;

        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][previousRemainder] + x);
      }
    }
    return dp[length - 1][0];
  }


  void main() {
    int[] nums = {3, 6, 5, 1, 8};
    System.out.println(maxSumDivThree(nums));
  }
}

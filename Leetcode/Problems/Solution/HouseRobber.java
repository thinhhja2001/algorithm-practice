public class HouseRobber {

  public static int rob(int[] nums) {
    int[] maxAmount = new int[nums.length];
    maxAmount[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (i == 1) {
        maxAmount[i] = Math.max(maxAmount[i - 1], nums[i]);
      } else {

        maxAmount[i] = Math.max(maxAmount[i - 1], maxAmount[i - 2] + nums[i]);
      }

    }
    return maxAmount[nums.length - 1];
  }

  public static void main(String[] args) {
    int[] nums = {0};
    System.out.println(rob(nums));
  }
}

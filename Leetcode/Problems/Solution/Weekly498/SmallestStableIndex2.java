package Weekly498;

public class SmallestStableIndex2 {

  public static int firstStableIndex(int[] nums, int k) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];

    int curMax = nums[0];
    int curMin = nums[nums.length - 1];
    for (int i = 0; i < nums.length; i++) {
      curMax = Math.max(curMax, nums[i]);
      max[i] = curMax;
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      curMin = Math.min(curMin, nums[i]);
      min[i] = curMin;
    }

    for (int i = 0; i < nums.length; i++) {
      if (max[i] - min[i] <= k) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {0};
    int k = 0;
    System.out.println(firstStableIndex(nums, k));
  }
}

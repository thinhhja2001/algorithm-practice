public class MaxConsecutiveOnes3 {

  public static int longestOnes(int[] nums, int k) {
    int max = 0;
    int count = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        count++;
      }
      while (count > k) {
        if (nums[left] == 0) {
          count--;
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    int k = 3;
    System.out.println(longestOnes(nums, k));
  }
}

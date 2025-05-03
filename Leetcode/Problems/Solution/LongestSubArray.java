public class LongestSubArray {

  public static int longestSubarray(int[] nums) {
    int left = 0;
    int max = 0;
    int count = 0;
    int k = 1;
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
    return max - 1;
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
    System.out.println(longestSubarray(nums));
  }

}

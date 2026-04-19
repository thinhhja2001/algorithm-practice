package Weekly498;

import java.util.Arrays;

public class FirstStableIndex {

  public static int firstStableIndex(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      int[] left = Arrays.copyOfRange(nums, 0, i + 1);
      int[] right = Arrays.copyOfRange(nums, i, nums.length);
      int max = 0;
      for (int li = 0; li < left.length; li++) {
        max = Math.max(left[li], max);
      }

      int min = Integer.MAX_VALUE;
      for (int ri = 0; ri < right.length; ri++) {
        min = Math.min(right[ri], min);
      }

      if (max - min <= k && min != Integer.MAX_VALUE) {
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

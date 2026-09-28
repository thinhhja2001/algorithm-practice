package Weekly521;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarray {

  public static int maxSubarray(int[] nums) {
    int left = 0;
    int right = 2;
    int max = 0;
    if (nums.length < 3) {
      return nums.length;
    }
    Map<Integer, Integer> map = new HashMap<>();

    map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
    map.put(nums[1], map.getOrDefault(nums[1], 0) + 1);

    while (right != nums.length) {
      boolean isValid = true;

      for (int i = left; i < right; i++) {
        int sum = nums[i] + nums[right];
        int minus = Math.abs(nums[i] - nums[right]);

        int exceptSelf = minus == nums[i] ? map.getOrDefault(minus, 0) - 1 : map.getOrDefault(minus, 0);

        if (map.getOrDefault(sum, 0) > 0 || exceptSelf > 0) {
          isValid = false;
          break;
        }
      }
      if (!isValid) {
        map.put(nums[left], map.get(nums[left]) - 1);
        left++;
      } else {
        max = Math.max(max, right - left + 1);
        map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        right++;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {19, 28, 30, 19, 12, 5, 11, 22, 17, 1, 21};
    System.out.println(maxSubarray(nums));
  }
}

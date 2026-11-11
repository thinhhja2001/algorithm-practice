package Weekly527;

import java.util.HashMap;
import java.util.Map;

public class CountValidSuffixSort {

  public static int countSuffix(int[] nums, int[] target) {
    int n = nums.length;

    int longestNonDecreasingOrder = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (target[i] >= target[i + 1]) {
        longestNonDecreasingOrder++;
      } else {
        break;
      }
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = n - 1; i >= n - longestNonDecreasingOrder; i--) {
      map.put(target[i], map.getOrDefault(target[i], 0) + 1);
      map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
    }
    for (int key : map.keySet()) {
      if (map.get(key) != 0) {
        return 0;
      }
    }
    for (int i = 0; i < n - longestNonDecreasingOrder - 1; i++) {
      if (nums[i] != target[i]) {
        return 0;
      }
    }

    int endIndex = n - longestNonDecreasingOrder;

    int cnt = 0;
    for (int i = endIndex; i < n; i++) {
      if (nums[i] == target[i]) {
        cnt++;
      } else {
        cnt++;
        break;
      }
    }

    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(countSuffix(new int[]{1}, new int[]{1}));
  }
}

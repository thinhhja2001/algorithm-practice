package Weekly521;

import java.util.HashMap;
import java.util.Map;

public class MaxEqualAdjacentPairs {

  public static int maxEqualAdjacentPairs(int[] nums) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    int adjacentCount = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        adjacentCount++;
      }
      int key = nums[i];
      Map<Integer, Integer> currentMap = map.getOrDefault(key, new HashMap<>());
      int target = nums[i + 1];
      if (key != target) {
        currentMap.put(target, currentMap.getOrDefault(target, 0) + 1);
      }
      map.put(key, currentMap);
    }
    int max = adjacentCount;
    for (int key : map.keySet()) {
      for (int value : map.get(key).keySet()) {
        int connected = map.getOrDefault(key, new HashMap<>()).get(value);
        int nextAdjacent = map.getOrDefault(value, new HashMap<>()).getOrDefault(key, 0);

        int cnt = adjacentCount + connected + nextAdjacent;
        max = Math.max(max, cnt);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1};
    System.out.println(maxEqualAdjacentPairs(nums));
  }
}

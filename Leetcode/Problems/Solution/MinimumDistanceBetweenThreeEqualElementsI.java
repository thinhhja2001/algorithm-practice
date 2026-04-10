import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {

  public static int minimumDistance(int[] nums) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) == null) {
        map.put(nums[i], new ArrayList<>());
      }
      map.get(nums[i]).add(i);
    }
    int minDistance = Integer.MAX_VALUE;
    for (int num : map.keySet()) {
      List<Integer> indices = map.get(num);
      for (int end = 2; end < indices.size(); end++) {
        int i = indices.get(end - 2);
        int j = indices.get(end - 1);
        int k = indices.get(end);
        int distance = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
        minDistance = Math.min(minDistance, distance);
      }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 1, 1, 3};
    System.out.println(minimumDistance(nums));
  }
}

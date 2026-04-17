import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestEqualElementQueries {

  public static List<Integer> solveQueries(int[] nums, int[] queries) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = nums[i];
      map.computeIfAbsent(key, k -> new ArrayList<>());
      map.get(key).add(i);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < queries.length; i++) {
      int index = queries[i];
      List<Integer> list = map.get(nums[index]);
      if (list.size() == 1) {
        result.add(-1);
        continue;
      }
      int numIndex = Collections.binarySearch(list, index);

      if (numIndex == 0) {
        result.add(Math.min(list.get(1) - list.get(0), list.get(0) + nums.length - list.getLast()));
      } else if (numIndex == list.size() - 1) {
        result.add(
            Math.min(list.get(numIndex) - list.get(numIndex - 1), list.get(0) + nums.length - list.get(numIndex)));
      } else {
        result.add(Math.min(list.get(numIndex) - list.get(numIndex - 1), list.get(numIndex + 1) - list.get(numIndex)));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int[] queries = {0, 1, 2, 3};
    System.out.println(solveQueries(nums, queries));
  }
}

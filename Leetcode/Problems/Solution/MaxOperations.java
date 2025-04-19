import java.util.HashMap;
import java.util.Map;

public class MaxOperations {

  public static int maxOperations(int[] nums, int k) {
    int count = 0;
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int num : nums) {
      if (!numMap.containsKey(num)) {
        numMap.put(num, 1);
      } else {
        numMap.put(num, numMap.get(num) + 1);
      }
    }
    for (Integer value : numMap.keySet()) {
      int left = numMap.getOrDefault(value, 0);
      int right = numMap.getOrDefault(k - value, 0);
      count += Math.min(left, right);
    }
    return count / 2;
  }

  public static void main(String[] args) {
    int[] nums = {3, 1, 3, 4, 3};
    int k = 6;
    System.out.println(maxOperations(nums, k));
  }
}

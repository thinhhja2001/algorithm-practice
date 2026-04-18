import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

  public static int findMaxLength(int[] nums) {
    int curSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    map.put(0, 0);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        curSum -= 1;
      } else {
        curSum += 1;
      }
      if (map.get(curSum) == null) {
        map.put(curSum, i + 1);
      } else {
        max = Math.max(max, i - map.get(curSum) + 1);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
    System.out.println(findMaxLength(nums));
  }
}

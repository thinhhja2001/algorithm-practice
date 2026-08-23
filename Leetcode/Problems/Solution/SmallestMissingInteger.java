import java.util.HashSet;
import java.util.Set;

public class SmallestMissingInteger {

  public static int missingInteger(int[] nums) {
    int curSum = nums[0];

    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - 1 == nums[i - 1]) {
        curSum += nums[i];
      } else {
        break;
      }
    }

    while (true) {
      if (!set.contains(curSum)) {
        return curSum;
      }
      curSum++;
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 4, 5, 1, 12, 14, 13};
    System.out.println(missingInteger(nums));
  }
}

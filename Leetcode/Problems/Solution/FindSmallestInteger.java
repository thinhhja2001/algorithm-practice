import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSmallestInteger {

  public int findSmallestInteger(int[] nums, int value) {
    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int mod = num % value;
      if (mod < 0) {
        mod += value;
      }
      int count = map.getOrDefault(mod, 0);
      int smallest = mod + value * count;
      map.put(mod, count + 1);
      set.add(smallest);
    }
    int i = 0;
    while (true) {
      if (!set.contains(i)) {
        return i;
      }
      i++;
    }
  }

  void main() {
    int[] nums = {0, -10};
    int value = 4;
    System.out.println(findSmallestInteger(nums, value));
  }
}

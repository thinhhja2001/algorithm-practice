
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistance {

  public static long[] distance(int[] nums) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.putIfAbsent(nums[i], new ArrayList<>());
      map.get(nums[i]).add(i);
    }
    long[] res = new long[nums.length];
    Map<Integer, Integer> prevIndexMapper = new HashMap<>();


    for (int i = 0; i < nums.length; i++) {
      long total = 0;
      int prevIndex = prevIndexMapper.getOrDefault(nums[i], -1);
      if (prevIndex==-1) {
        List<Integer> list = map.get(nums[i]);
        for (int index : list) {
          total += Math.abs(i - index);
        }
        res[i] = total;
      } else {
        int indexInRoot = map.get(nums[i]).get(prevIndex);
        int mapLength = map.get(nums[i]).size();

        res[i] = res[indexInRoot]
            + (long) (i - indexInRoot) * (prevIndex + 1)
            - (long) (i - indexInRoot) * (mapLength - prevIndex - 1);
      }
      prevIndexMapper.put(nums[i], prevIndex + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 1, 1, 2};
    // 1:
    // [0: (0,0) (0,2) (0,3)] , 5
    // [2: (2,0) (2,2) (2,3)] , 5 + (2-0)*1 - (2-0)*2
    // [3: (3,0) (3,2) (3,3)] , 3 + (3-2)*2 - (3-2)*1
    //
    // 2: 4
    // 3: 1
    System.out.println(Arrays.toString(distance(nums)));
  }
}
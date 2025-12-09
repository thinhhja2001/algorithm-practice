import java.util.HashMap;
import java.util.Map;

public class CountSpecialTriplet {

  public int specialTriplets(int[] nums) {
    int mod = 1000000007;
    Map<Integer, Integer> countMapper = new HashMap<>();

    for (int num : nums) {
      countMapper.put(num, countMapper.getOrDefault(num, 0) + 1);
    }

    Map<Integer, Integer> partialMapper = new HashMap<>();
    long count = 0;
    for (int num : nums) {
      int v = num * 2;
      int leftCnt = partialMapper.getOrDefault(v, 0);
      partialMapper.put(num, partialMapper.getOrDefault(num, 0) + 1);
      int rightCnt = countMapper.getOrDefault(v, 0) - partialMapper.getOrDefault(v, 0);

      count = (count + (long) leftCnt * rightCnt) % mod;
    }
    return (int) count;
  }

  void main() {
    int[] nums = {0, 1, 0, 0};
    System.out.println(specialTriplets(nums));
  }
}

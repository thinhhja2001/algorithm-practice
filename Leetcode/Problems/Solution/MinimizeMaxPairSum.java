import java.util.Arrays;
import java.util.Set;

public class MinimizeMaxPairSum {

  public int minPairSum(int[] nums) {
    nums = Arrays.stream(nums).sorted().toArray();
    int maxPairSum = 0;
    for (int i = 0; i < nums.length / 2; i++) {
      maxPairSum = Math.max(maxPairSum, nums[i] + nums[nums.length - 1 - i]);
    }
    return maxPairSum;
  }

  public int vowelConsonantScore(String s) {
    Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
    int vowelCount = 0;
    int consonantCount = 0;
    for (Character c : s.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        if (vowel.contains(c)) {
          vowelCount++;
          continue;
        }
        consonantCount++;
      }

    }
    if (consonantCount > 0) {
      return vowelCount / consonantCount;
    }
    return 0;
  }

  void main() {
    int[] nums = {3, 5, 4, 2, 4, 6};
    System.out.println(minPairSum(nums));
  }
}

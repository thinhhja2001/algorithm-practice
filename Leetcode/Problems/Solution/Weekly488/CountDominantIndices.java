package Weekly488;

public class CountDominantIndices {

  public int dominantIndices(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int sum = 0;
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
      }
      if (nums[i] > sum / (nums.length - i - 1)) {
        count++;
      }
    }
    return count;
  }

  void main() {
    int[] nums = {4, 1, 2};
    System.out.println(dominantIndices(nums));
  }
}

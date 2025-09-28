import java.util.Arrays;

public class LargestPerimeter {

  public int largestPerimeter(int[] nums) {
    nums = Arrays.stream(nums).sorted().toArray();
    Arrays.sort(nums);
    int sum = 0;
    for (int i = nums.length - 1; i >= 2; i--) {
      int c = nums[i];
      int a = nums[i - 1];
      int b = nums[i - 2];
      if (a + b > c) {
        return a + b + c;
      }
    }
    return sum;
  }

  void main() {
    int[] nums = new int[]{1, 2, 1, 10};
    System.out.println(largestPerimeter(nums));
  }
}

import java.util.Arrays;

public class MaxAlternatingSumOfSquare {

  public static long maxAlternatingSum(int[] nums) {

    int[] sorted = Arrays.stream(nums)
        .boxed()
        .sorted((a, b) -> (int) (Math.pow(a, 2) - Math.pow(b, 2)))
        .mapToInt(i -> i)
        .toArray();

    long result = 0;

    int right = nums.length - 1;
    int left = 0;
    while (left <= right) {
      result = (long) (result + Math.pow(sorted[right], 2));
      right--;
      if (right < left) {
        break;
      }
      result = (long) (result - Math.pow(sorted[left], 2));
      left++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, -1, 2, -2, 3, -3};
    System.out.println(maxAlternatingSum(nums));
  }
}

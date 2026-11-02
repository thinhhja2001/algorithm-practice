package Weekly526;

public class MinValueOfMergedIntegers {

  public static int mergedInteger(int a, int b) {
    int c = b;
    int cnt = 0;
    while (c != 0) {
      c /= 10;
      cnt++;
    }
    return (int) (a * Math.pow(10, cnt) + b);
  }

  public static int minMergedInteger(int[] nums) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i += 2) {
      int val = mergedInteger(nums[i], nums[i + 1]);
      min = Math.min(min, val);
    }
    return min;
  }

  public static void main(String[] args) {
    int[] nums = {23, 55, 11, 12};
    System.out.println(minMergedInteger(nums));
  }
}

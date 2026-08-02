package Weekly513;

public class MaxPairStrengthUsingGCD {

  public static long maxPairStrength(int[] nums) {
    long max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        long gcd = gcd(nums[i], nums[j]);
        max = Math.max(max, ((long) nums[i] * nums[j]) / ((long)Math.pow(gcd, 2)));
      }
    }
    return max;
  }

  public static long gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int[] nums = {3,3};
    System.out.println(maxPairStrength(nums));
  }
}

package Weekly513;

public class CountSubArraysWithEvenOddRatio {

  public static int countRatioSubarrays(int[] nums, int a, int b) {
    int valid = 0;
    for (int i = 0; i < nums.length; i++) {
      int x = 0;
      int y = 0;

      for (int j = i; j < nums.length; j++) {
        x = x + (nums[j] % 2 == 0 ? 1 : 0);
        y = y + (nums[j] % 2 != 0 ? 1 : 0);

        if (y != 0 && (double) x / y <= (double) a / b) {
          valid++;
        }
      }
    }
    return valid;
  }

  public static void main(String[] args) {
    int[] nums = {304, 979, 652, 115};
    System.out.println(countRatioSubarrays(nums, 3, 2));
  }
}

package Weekly518;

public class CountGoodRotations {

  public static int countGoodRotations(int[] nums) {
    long firstHalf = 0;
    long secondHalf = 0;
    for (int i = 0; i <= nums.length / 2 - 1; i++) {
      firstHalf += nums[i];
    }

    for (int i = nums.length / 2; i < nums.length; i++) {
      secondHalf += nums[i];
    }

    int count = firstHalf > secondHalf ? 1 : 0;

    int indexFirst = 0;
    int indexSecond = nums.length / 2;
    for (int i = 0; i < nums.length - 1; i++) {
      firstHalf = firstHalf - nums[indexFirst] + nums[indexSecond];
      secondHalf = secondHalf - nums[indexSecond] + nums[indexFirst];

      if (firstHalf > secondHalf) {
        count++;
      }

      indexFirst++;
      indexSecond++;
      if (indexSecond >= nums.length) {
        indexSecond -= nums.length;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6};
    System.out.println(countGoodRotations(nums));
  }
}

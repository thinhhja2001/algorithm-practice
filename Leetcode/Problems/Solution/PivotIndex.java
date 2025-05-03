public class PivotIndex {

  public static int pivotIndex(int[] nums) {
    int sum = 0;
    for (int element : nums) {
      sum += element;
    }
    int sumLeft = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sumLeft == sum - sumLeft - nums[i]) {
        return i;
      }
      sumLeft += nums[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(nums));
  }
}

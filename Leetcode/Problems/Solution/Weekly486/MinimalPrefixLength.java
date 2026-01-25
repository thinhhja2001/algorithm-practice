package Weekly486;

public class MinimalPrefixLength {

  public int minimumPrefixLength(int[] nums) {
    int increaseLength = 0;

    int curNumber = nums[nums.length - 1 - increaseLength];
    increaseLength++;

    while (increaseLength != nums.length && nums[nums.length - 1 - increaseLength] < curNumber) {
      curNumber = nums[nums.length - 1 - increaseLength];
      increaseLength++;
    }

    return nums.length - increaseLength;
  }

  void main() {
    int[] nums = {1, 2, 3, 4};
    System.out.println(minimumPrefixLength(nums));
  }
}

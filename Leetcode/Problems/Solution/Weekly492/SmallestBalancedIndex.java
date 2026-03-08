package Weekly492;

public class SmallestBalancedIndex {

  public int smallestBalancedIndex(int[] nums) {
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    long product = 1;
    long index = -1;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum -= nums[i];
      if (i + 1 < nums.length) {
        product *= nums[i + 1];
      }
      if (sum < product) {
        break;
      }
      if (sum == product) {
        if (index == -1) {
          index = i;
        } else {
          index = Math.min(index, i);

        }
      }
    }
    return (int) index;
  }

  void main() {
    int[] nums = {999, 818, 984, 995, 841, 822, 984, 978, 960, 997, 896, 926, 759, 961, 1000, 562, 1, 1, 1, 87, 4, 1,
        40};
    System.out.println(smallestBalancedIndex(nums));
  }
}

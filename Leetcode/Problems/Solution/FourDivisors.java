public class FourDivisors {

  public int findMax(int[] nums) {
    int max = nums[0];
    for (int n : nums) {
      max = Math.max(n, max);
    }
    return max;
  }

  public int sumFourDivisors(int[] nums) {
    int max = findMax(nums);
    int[] countDivisors = new int[max + 1];
    int[] sumDivisors = new int[max + 1];
    for (int i = 1; i <= max; i++) {
      for (int j = 1; i * j <= max; j++) {
        countDivisors[i * j]++;
        sumDivisors[i * j] += i;
      }
    }
    int total = 0;
    for (int num : nums) {
      if (countDivisors[num] == 4) {
        total += sumDivisors[num];
      }
    }
    return total;
  }

  void main() {
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(sumFourDivisors(nums));
  }
}

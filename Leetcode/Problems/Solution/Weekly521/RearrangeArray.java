package Weekly521;

import java.util.Arrays;

public class RearrangeArray {

  public static int[] rearrangeArray(int[] nums) {
    int[] result = new int[nums.length];

    int[] arr = new int[101];
    for (int num : nums) {
      arr[num]++;
    }

    int i = 0;
    while (i != nums.length) {
      for (int j = 1; j <= 100; j++) {
        if (arr[j] != 0) {
          result[i] = j;
          arr[j]--;
          i++;
          if (i == nums.length) {
            break;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[]nums={7,7,4,4,4};
    System.out.println(Arrays.toString(rearrangeArray(nums)));
  }
}

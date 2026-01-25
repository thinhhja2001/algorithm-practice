package Weekly486;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateNonNegativeElements {

  public int[] rotateElements(int[] nums, int k) {
    List<Integer> arr = new ArrayList<>();
    for (int num : nums) {
      if (num >= 0) {
        arr.add(num);
      }
    }

    int[] nonNegativeElements = new int[arr.size()];
    int size = arr.size();

    for (int i = 0; i < arr.size(); i++) {
      int index = ((i - k) % size + size) % size;

      nonNegativeElements[index] = arr.get(i);
    }

    int currentIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        nums[i] = nonNegativeElements[currentIndex++];
      }
    }
    return nums;
  }

  void main() {
    int[] nums = {3,17,3};
    int k = 89646;
    System.out.println(Arrays.toString(rotateElements(nums, k)));
  }
}

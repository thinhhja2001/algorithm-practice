package Weekly526;

public class MinOperationsToSortWithLockedIndices {

  public static int minOperations(int[] nums, int[] locked, int k) {
    int unlock = 0;
    int operation = 0;
    for (int curNum = 1; curNum < nums.length + 1; curNum++) {
      if (nums[curNum - 1] == curNum) {
        continue;
      }
      int startIndex = curNum - 1;
      while (nums[startIndex] != curNum) {
        startIndex++;
      }
      for (; startIndex > curNum - 1; startIndex--) {
        int temp = nums[startIndex];
        nums[startIndex] = nums[startIndex - 1];
        nums[startIndex - 1] = temp;

        operation++;
        if (locked[startIndex] == 1) {
          locked[startIndex] = 0;
          operation++;
          unlock++;
        }
        if (locked[startIndex - 1] == 1) {
          locked[startIndex - 1] = 0;
          operation++;
          unlock++;
        }
        if (unlock > k) {
          return -1;
        }
      }
    }
    return operation;
  }

  public static void main(String[] args) {
    int[] nums = {3,1,2};
    int[] locked = {1,0,1};
    int k = 2;
    System.out.println(minOperations(nums, locked, k));
  }
}

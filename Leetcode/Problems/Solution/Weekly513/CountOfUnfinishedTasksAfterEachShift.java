package Weekly513;

import java.util.Arrays;

public class CountOfUnfinishedTasksAfterEachShift {
  public static int[] countTasks(int[] tasks, int[] shifts) {

    int[] result = new int[shifts.length];

    long[] prefixSum = new long[tasks.length];

    prefixSum[0] = tasks[0];
    for (int i = 1; i < tasks.length; i++) {
      prefixSum[i] = tasks[i] + prefixSum[i - 1];
    }

    long remember = 0;

    int current = 0;
    for (int i = 0; i < shifts.length; i++) {
      current = lowerBound(prefixSum, shifts[i], remember, current);

      if (current >= prefixSum.length) {
        result[i] = 0;
        current = 0;
        remember = 0;
        continue;
      }

      result[i] = tasks.length - current;
      remember += shifts[i];

    }
    return result;
  }

  public static int lowerBound(long[] array, long shift, long remember, int current) {
    int low = current, high = array.length;
    int mid;
    while (low < high) {
      mid = low + (high - low) / 2;
      if (shift >= array[mid] - remember) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    if (low < array.length && shift > array[low] - remember) {
      low++;
    }
    return low;
  }

  public static void main(String[] args) {
    int[] tasks = {1, 1, 3, 3, 8};
    int[] shifts = {2, 9, 5, 3, 9};

    System.out.println(Arrays.toString(countTasks(tasks, shifts)));
  }
}


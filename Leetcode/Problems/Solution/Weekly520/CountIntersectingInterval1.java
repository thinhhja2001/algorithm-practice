package Weekly520;

import java.util.Arrays;

public class CountIntersectingInterval1 {

  public static int upperBoundSearch(int[][] intervals, int left) {
    int right = intervals.length;
    int[] element = intervals[left];
    while (left < right) {
      int mid = (left + right) / 2;
      if (isOverlapped(element, intervals[mid])) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static boolean isOverlapped(int[] a, int[] b) {
    return b[1] >= a[0];
  }

  public static long countIntersectingIntervals(int[][] intervals) {
    long count = 0;

    Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

    for (int i = 0; i < intervals.length; i++) {
      count += upperBoundSearch(intervals, i) - 1 - i;
    }

    return count;
  }

  public static void main(String[] args) {
    int[][] intervals = {{86, 97}, {75, 88}, {69, 71}};
    System.out.println(countIntersectingIntervals(intervals));
//    System.out.println(countIntersectingIntervals(intervals));
  }
}

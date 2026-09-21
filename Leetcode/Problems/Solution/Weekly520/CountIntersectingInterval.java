package Weekly520;

import java.util.Arrays;
import java.util.Comparator;

public class CountIntersectingInterval {

  public static int countIntersectingIntervals(int[][] intervals) {
    int count = 0;
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < intervals.length - 1; i++) {
      for (int j = i + 1; j < intervals.length; j++) {
        if (intervals[i][1] >= intervals[j][0]) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] intervals = {{18, 46}, {86, 97}, {86, 92}};
    System.out.println(countIntersectingIntervals(intervals));
  }
}

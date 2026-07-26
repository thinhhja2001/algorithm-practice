package Weekly512;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AggregateTwoTimeSeries {

  public static List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
    int last1Value = 0;
    int last2Value = 0;

    int l1 = series1.length - 1;
    int l2 = series2.length - 1;
    List<List<Integer>> result = new ArrayList<>();
    while (l1 >= 0 && l2 >= 0) {
      int[] s1 = series1[l1];
      int[] s2 = series2[l2];

      if (s1[0] == s2[0]) {
        result.add(List.of(s1[0], s1[1] + s2[1]));
        last1Value = s1[1];
        last2Value = s2[1];
        l1--;
        l2--;
      } else if (s2[0] > s1[0]) {
        result.add(List.of(s2[0], s2[1] + last1Value));
        last2Value = s2[1];
        l2--;
      } else if (s1[0] > s2[0]) {
        result.add(List.of(s1[0], s1[1] + last2Value));
        last1Value = s1[1];
        l1--;
      }
    }
    while (l1 >= 0) {
      int[] s1 = series1[l1];
      result.add(List.of(s1[0], s1[1] + last2Value));
      l1--;
    }
    while (l2 >= 0) {
      int[] s2 = series2[l2];
      result.add(List.of(s2[0], s2[1] + last1Value));
      l2--;
    }
    result.sort(Comparator.comparing(List::getFirst));
    return result;
  }

  public static void main(String[] args) {
    int[][] series1 = {{1, 3}, {4, 1}};
    int[][] series2 = {{2, 2}, {5, 2}};
    System.out.println(aggregateTimeSeries(series1, series2));
  }
}

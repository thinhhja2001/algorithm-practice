import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class MergeInterval {

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      int cmp = Integer.compare(a[0], b[0]);
      if (cmp == 0) {
        return Integer.compare(a[1], b[1]);
      }
      return cmp;
    });

    Queue<int[]> queue = new ArrayDeque<>(Arrays.asList(intervals));
    int[] current = queue.poll();

    List<int[]> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int[] value = queue.poll();
      //mergeable
      if (current[1] >= value[0]) {
        current[1] = Math.max(current[1], value[1]);
      } else {
        result.add(current);
        current = value;
      }
    }
    result.add(current);
    return result.toArray(new int[0][]);
  }

  public static void main(String[] args) {
    int[][] intervals = {{4, 7}};
    System.out.println(Arrays.deepToString(merge(intervals)));
  }
}

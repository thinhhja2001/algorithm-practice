import java.util.Arrays;

public class PathExistenceQueriesInGraph1 {

  public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    int[] precompute = new int[n];
    int id = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i] - nums[i - 1] > maxDiff) {
        id++;
      }
      precompute[i] = id;
    }

    boolean[] result = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int start = queries[i][0];
      int end = queries[i][1];
      result[i] = precompute[start] == precompute[end];
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 4;
    int[] nums = {2, 5, 6, 8};
    int maxDiff = 2;
    int[][] queries = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
    System.out.println(Arrays.toString(pathExistenceQueries(n, nums, maxDiff, queries)));
  }
}

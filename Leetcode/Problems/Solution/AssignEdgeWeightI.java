import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AssignEdgeWeightI {

  public static int assignEdgeWeights(int[][] edges) {
    for (int i = 0; i < edges.length; i++) {
      int root = edges[i][0];
      int child = edges[i][1];
      edges[i][0] = Math.min(root, child);
      edges[i][1] = Math.max(root, child);
    }
    Arrays.sort(edges, Comparator.comparingInt(a -> a[0]));
    Map<Integer, Integer> map = new HashMap<>();
    map.put(edges[0][0], 0);

    for (int i = 0; i < edges.length; i++) {
      int root = edges[i][0];
      int child = edges[i][1];
      map.put(child, map.get(root) + 1);
    }

    int max = 0;
    for (int key : map.keySet()) {
      max = Math.max(max, map.get(key));
    }
    long res = 1;
    for (int i = 1; i < max; i++) {
      res = res * 2;
      res = res % 1_000_000_007;
    }

    return (int) res;
  }

  public static void main(String[] args) {
    int[][] edges = {{3, 2}, {2, 1}};
    System.out.println(assignEdgeWeights(edges));
  }
}

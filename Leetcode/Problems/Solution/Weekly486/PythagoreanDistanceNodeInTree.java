package Weekly486;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PythagoreanDistanceNodeInTree {

  public int[] bfs(int start, int n, Map<Integer, List<Integer>> graph) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (Integer neighbor : graph.get(current)) {
        if (dist[neighbor] == Integer.MAX_VALUE) {
          dist[neighbor] = dist[current] + 1;
          queue.add(neighbor);
        }
      }
    }
    return dist;
  }

  public int specialNodes(int n, int[][] edges, int x, int y, int z) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] edge : edges) {
      int root = edge[0];
      int neighbor = edge[1];
      graph.get(root).add(neighbor);
      graph.get(neighbor).add(root);
    }

    int[] dx = bfs(x, n, graph);
    int[] dy = bfs(y, n, graph);
    int[] dz = bfs(z, n, graph);

    int countSpecial = 0;
    for (int i = 0; i < n; i++) {
      int a = dx[i];
      int b = dy[i];
      int c = dz[i];

      if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
        countSpecial++;
      }
    }
    return countSpecial;
  }


  void main() {
    int n = 4;
    int[][] edges = {{0, 1}, {0, 2}, {0, 3}};
    int x = 1;
    int y = 2;
    int z = 3;

    System.out.println(specialNodes(n, edges, x, y, z));
  }

}

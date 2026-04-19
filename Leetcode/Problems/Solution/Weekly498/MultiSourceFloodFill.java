package Weekly498;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MultiSourceFloodFill {

  public static int[][] colorGrid(int n, int m, int[][] sources) {
    int[][] grid = new int[n][m];
    Queue<int[]> queue = new LinkedList<>();

    for (int[] sc : sources) {
      grid[sc[0]][sc[1]] = sc[2];

      queue.offer(sc);
    }
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!queue.isEmpty()) {
      Map<String, Integer> nextColorMap = new HashMap<>();

      int level = queue.size();

      for (int i = 0; i < level; i++) {
        int[] current = queue.poll();
        int r = current[0];
        int c = current[1];
        int color = current[2];

        for (int[] dir : directions) {
          int nextRow = r + dir[0];
          int nextCol = c + dir[1];

          if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
            if (grid[nextRow][nextCol] == 0) {
              String key = nextRow + "," + nextCol;
              nextColorMap.put(key, Math.max(nextColorMap.getOrDefault(key, grid[nextRow][nextCol]), color));
            }
          }
        }
      }


      for (String key : nextColorMap.keySet()) {
        String[] index = key.split(",");
        int row = Integer.parseInt(index[0]);
        int col = Integer.parseInt(index[1]);

        if (grid[row][col] == 0) {
          grid[row][col] = nextColorMap.get(key);
          queue.offer(new int[]{row, col, grid[row][col]});
        }
      }
    }
    return grid;
  }

  public static void main(String[] args) {
    int[][] sources = new int[][]{{0, 1, 3}, {1, 1, 5}};
    System.out.println(Arrays.deepToString(colorGrid(3, 3, sources)));
  }
}

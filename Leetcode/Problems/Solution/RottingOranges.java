import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

  public static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static boolean isFreshOranges(int[][] grid, int[] pos) {
    int i = pos[0];
    int j = pos[1];
    return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
  }

  public static int orangesRotting(int[][] grid) {
    Queue<int[]> rottenQueue = new LinkedList<>();

    int freshCount = 0;
    int n = grid.length;
    int m = grid[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0) {
          continue;
        }
        if (grid[i][j] == 1) {
          freshCount++;
        }
        if (grid[i][j] == 2) {
          rottenQueue.add(new int[]{i, j});
        }
      }
    }
    int minutes = 0;
    while (!rottenQueue.isEmpty()) {
      if (freshCount == 0) {
        break;
      }
      minutes++;
      int size = rottenQueue.size();

      for (int i = 0; i < size; i++) {
        int[] rottenPos = rottenQueue.poll();
        if (rottenPos == null) {
          break;
        }

        for (int[] dir : directions) {
          int[] adjacentPos = new int[]{rottenPos[0] + dir[0], rottenPos[1] + dir[1]};
          if (isFreshOranges(grid, adjacentPos)) {
            freshCount--;
            rottenQueue.add(adjacentPos);
            grid[adjacentPos[0]][adjacentPos[1]] = 2;
          }
        }
      }
    }
    return freshCount == 0 ? minutes : -1;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {0,2}};
    System.out.println(orangesRotting(grid));
  }
}

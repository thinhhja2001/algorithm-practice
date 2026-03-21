import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {

  public static class Point {

    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] isVisited = new boolean[row][col];
    int countIsland = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1' && !isVisited[i][j]) {
          Queue<Point> queue = new LinkedList<>();
          isVisited[i][j] = true;
          queue.add(new Point(i, j));
          while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x - 1 >= 0 && grid[current.x - 1][current.y] == '1' && !isVisited[current.x - 1][current.y]) {
              queue.add(new Point(current.x - 1, current.y));
              isVisited[current.x - 1][current.y] = true;
            }
            if (current.y - 1 >= 0 && grid[current.x][current.y - 1] == '1' && !isVisited[current.x][current.y - 1]) {
              queue.add(new Point(current.x, current.y - 1));
              isVisited[current.x][current.y - 1] = true;
            }
            if (current.x + 1 < row && grid[current.x + 1][current.y] == '1' && !isVisited[current.x + 1][current.y]) {
              queue.add(new Point(current.x + 1, current.y));
              isVisited[current.x + 1][current.y] = true;
            }
            if (current.y + 1 < col && grid[current.x][current.y + 1] == '1' && !isVisited[current.x][current.y + 1]) {
              queue.add(new Point(current.x, current.y + 1));
              isVisited[current.x][current.y + 1] = true;
            }
          }
          countIsland++;
        }
      }
    }
    return countIsland;
  }

  public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '1'},
        {'0', '1', '0'},
        {'1', '1', '1'},
    };
    System.out.println(numIslands(grid));
  }
}

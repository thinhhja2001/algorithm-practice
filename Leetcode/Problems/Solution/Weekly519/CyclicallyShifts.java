package Weekly519;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CyclicallyShifts {

  public static int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        list.add(grid[i][j]);
      }
      int curIndex = 0;
      for (int j = 0; j < n; j++  ) {
        grid[i][(j - rowShift[i] + n) % n] = list.get(curIndex++);
      }
    }

    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        list.add(grid[j][i]);
      }
      int curIndex = 0;
      for (int j = 0; j < n; j++) {
        grid[(j - colShift[i] + n) % n][i] = list.get(curIndex++);
      }
    }

    return grid;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[] rowShift = {1, 2, 0};
    int[] colShift = {2, 2, 1};
    System.out.println(Arrays.deepToString(cyclicShift(n, grid, rowShift, colShift)));
  }
}

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWater {


  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int row = heights.length;
    int col = heights[0].length;

    boolean[][] isAtlantic = new boolean[row][col];
    boolean[][] isPacific = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0 || j == 0) {
          isPacific[i][j] = true;
        }
        if (i == row - 1 || j == col - 1) {
          isAtlantic[i][j] = true;
        }
      }
    }

    leftToRight(heights, row, col, isPacific, isAtlantic);
    topToBottom(heights, col, row, isPacific, isAtlantic);
    rightToLeft(heights, row, col, isPacific, isAtlantic);
    bottomToTop(heights, col, row, isPacific, isAtlantic);

    topToBottom(heights, col, row, isPacific, isAtlantic);
    leftToRight(heights, row, col, isPacific, isAtlantic);
    rightToLeft(heights, row, col, isPacific, isAtlantic);
    bottomToTop(heights, col, row, isPacific, isAtlantic);

    rightToLeft(heights, row, col, isPacific, isAtlantic);
    leftToRight(heights, row, col, isPacific, isAtlantic);
    topToBottom(heights, col, row, isPacific, isAtlantic);
    bottomToTop(heights, col, row, isPacific, isAtlantic);

    bottomToTop(heights, col, row, isPacific, isAtlantic);
    leftToRight(heights, row, col, isPacific, isAtlantic);
    topToBottom(heights, col, row, isPacific, isAtlantic);
    rightToLeft(heights, row, col, isPacific, isAtlantic);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (isAtlantic[i][j] && isPacific[i][j]) {
          result.add(List.of(i, j));
        }
      }
    }
    return result;
  }

  private static void bottomToTop(int[][] heights, int col, int row, boolean[][] isPacific, boolean[][] isAtlantic) {
    for (int j = col - 1; j >= 0; j--) {
      for (int i = row - 2; i >= 0; i--) {
        if (i == 1 && j == 4) {
          System.out.println("here");
        }
        if (heights[i][j] >= heights[i + 1][j]) {
          if (isPacific[i + 1][j]) {
            isPacific[i][j] = true;
          }
          if (isAtlantic[i + 1][j]) {
            isAtlantic[i][j] = true;
          }
        }
      }
    }
  }

  private static void rightToLeft(int[][] heights, int row, int col, boolean[][] isPacific, boolean[][] isAtlantic) {
    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 2; j >= 0; j--) {
        if (i == 1 && j == 4) {
          System.out.println("here");
        }
        if (heights[i][j] >= heights[i][j + 1]) {
          if (isPacific[i][j + 1]) {
            isPacific[i][j] = true;
          }
          if (isAtlantic[i][j + 1]) {
            isAtlantic[i][j] = true;
          }
        }
      }
    }
  }

  private static void topToBottom(int[][] heights, int col, int row, boolean[][] isPacific, boolean[][] isAtlantic) {
    for (int j = 0; j < col; j++) {
      for (int i = 1; i < row; i++) {
        if (i == 1 && j == 4) {
          System.out.println("here");
        }
        if (heights[i][j] >= heights[i - 1][j]) {
          if (isPacific[i - 1][j]) {
            isPacific[i][j] = true;
          }
          if (isAtlantic[i - 1][j]) {
            isAtlantic[i][j] = true;
          }
        }
      }
    }
  }

  private static void leftToRight(int[][] heights, int row, int col, boolean[][] isPacific, boolean[][] isAtlantic) {
    for (int i = 0; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (i == 1 && j == 4) {
          System.out.println("here");
        }
        if (heights[i][j] >= heights[i][j - 1]) {
          if (isPacific[i][j - 1]) {
            isPacific[i][j] = true;
          }
          if (isAtlantic[i][j - 1]) {
            isAtlantic[i][j] = true;
          }
        }
      }
    }
  }


  // Pacific
  // 1 2 3
  // 8 9 4 Atlantic
  // 7 6 5
  void main() {
    int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
    System.out.println(pacificAtlantic(heights));
  }
}

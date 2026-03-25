public class EqualSumGridPartitionI {

  public static boolean canPartitionGrid(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    long sum = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        sum += grid[i][j];
      }
    }
    if (sum % 2 != 0) {
      return false;
    }

    long rowSum = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        rowSum += grid[i][j];
      }
      if (rowSum == sum / 2) {
        return true;
      }
    }
    long colSum = 0;
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        colSum += grid[j][i];
      }
      if (colSum == sum / 2) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] grid = {{28443}, {33959}};
    System.out.println(canPartitionGrid(grid));
  }
}

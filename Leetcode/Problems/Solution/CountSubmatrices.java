public class CountSubmatrices {

  public int countSubmatrices(int[][] grid, int k) {

    int row = grid.length;
    int col = grid[0].length;

    int[][] sumRow = new int[row][col];

    for (int i = 0; i < row; i++) {
      int sum = 0;
      for (int j = 0; j < col; j++) {
        sum += grid[i][j];
        sumRow[i][j] = sum;
      }
    }

    int[][] mem = new int[row][col];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0) {
          mem[i][j] = j == 0 ? grid[i][j] : mem[i][j - 1] + grid[i][j];
        } else {
          mem[i][j] = mem[i - 1][j] + sumRow[i][j];
        }
        if (mem[i][j] <= k) {
          count++;
        }
      }
    }
    return count;
  }

  void main() {
    int[][] grid = {{7, 6, 3}, {6, 6, 1}};
    int k = 18;
    System.out.println(countSubmatrices(grid, k));
  }
}

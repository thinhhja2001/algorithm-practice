import java.util.Arrays;

public class MaximumAmountMoneyRobotCanEarn {

  public static int maximumAmount(int[][] coins) {
    int row = coins.length;
    int col = coins[0].length;

    int[][][] dp = new int[row][col][3];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        Arrays.fill(dp[i][j], Integer.MIN_VALUE);
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        for (int k = 2; k >= 0; k--) {
          int maxNeutralise = Integer.MIN_VALUE;
          if (k != 2) {
            int topNeutralise = i > 0 ? dp[i - 1][j][k + 1] : Integer.MIN_VALUE;
            int leftNeutralise = j > 0 ? dp[i][j - 1][k + 1] : Integer.MIN_VALUE;

            if (i == 0 && j == 0 && k == 1) { // Skipping the coins[0][0] cell
              topNeutralise = 0;
            }

            maxNeutralise = Math.max(topNeutralise, leftNeutralise);
          }
          int top = i > 0 ? dp[i - 1][j][k] : Integer.MIN_VALUE;
          int left = j > 0 ? dp[i][j - 1][k] : Integer.MIN_VALUE;

          if (i == 0 && j == 0) {
            top=0;
          }

          int max = Math.max(top, left) != Integer.MIN_VALUE ? Math.max(top, left) + coins[i][j] : top;

          dp[i][j][k] = Math.max(maxNeutralise, max);
        }
      }
    }

    return Math.max(Math.max(dp[row - 1][col - 1][0], dp[row - 1][col - 1][1]), dp[row - 1][col - 1][2]);
  }

  public static void main(String[] args) {
    int[][] coins = {{-7, 12, 12, 13}, {-6, 19, 19, -6}, {9, -2, -10, 16}, {-4, 14, -10, -9}};
    System.out.println(maximumAmount(coins));
  }
}

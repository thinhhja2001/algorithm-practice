public class OnesAndZeros {

  public int[] countZeroAndOne(String str) {
    int count0 = 0, count1 = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '0') {
        count0++;
      } else {
        count1++;
      }
    }
    return new int[]{count0, count1};
  }


  public int findMaxForm(String[] strs, int maxZero, int maxOne) {
    int[][][] dp = new int[strs.length + 1][maxZero + 1][maxOne + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        for (int k = 0; k < dp[0][0].length; k++) {
          if (i == 0) {
            continue;
          }
          int[] cnt = countZeroAndOne(strs[i - 1]);
          int count_0 = cnt[0];
          int count_1 = cnt[1];
          int pick = 0;
          if (j - count_0 >= 0 && k - count_1 >= 0) {
            pick = dp[i - 1][j - count_0][k - count_1] + 1;
          }
          int notPick = dp[i - 1][j][k];
          dp[i][j][k] = Math.max(pick, notPick);
        }
      }
    }
    int max = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        for (int k = 0; k < dp[0][0].length; k++) {
          max = Math.max(max, dp[i][j][k]);
        }
      }
    }
    return max;
  }

  void main() {
    String[] strs = new String[]{"10", "0", "1"};
    System.out.println(findMaxForm(strs, 1, 1));
  }
}

import java.util.Arrays;

public class CoinChange {

  public static int coinChange(int[] coins, int amount) {
    int MAX = 1000000;
    int[] dp = new int[amount + 1];
    // amount + 1 represents "infinity"
    Arrays.fill(dp, MAX);
    dp[0] = 0;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) {
        dp[coins[i]] = 1;

      }
    }
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        int currentAmount = i + coin;
        if (currentAmount < 0) {
          continue;
        }
        if (currentAmount <= amount) {
          dp[currentAmount] = Math.min(dp[currentAmount], dp[i] + 1);
        }
      }
    }
    return dp[amount] == MAX ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = {2147483647};
    int amount = 2;
    System.out.println(coinChange(coins, amount));
  }
}

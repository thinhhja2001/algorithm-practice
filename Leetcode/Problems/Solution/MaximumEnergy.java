import java.util.Arrays;

public class MaximumEnergy {

  public int maximumEnergy(int[] energy, int k) {
    int[] dp = new int[energy.length];
    for (int i = 0; i < energy.length; i++) {
      if (i - k < 0) {
        dp[i] = energy[i];
        continue;
      }
      dp[i] = Math.max(dp[i - k] + energy[i], energy[i]);
    }
    int max = dp[dp.length - k];
    for (int i = dp.length - k; i < dp.length; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  void main() {
    int[] energy = {-2,-3,-1};
    int k = 2;
    System.out.println(maximumEnergy(energy, k));
  }
}

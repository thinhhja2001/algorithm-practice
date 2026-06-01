import java.util.Arrays;

public class MinCostBuyingCandiesWithDiscount {

  public static int minimumCost(int[] cost) {
    Arrays.sort(cost);
    int count = 0;
    int sum = 0;
    for (int i = cost.length - 1; i >= 0; i--) {
      if (count >= 2) {
        count = 0;
        continue;
      }
      sum += cost[i];
      count++;
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] cost = {6, 5, 7, 9, 2, 2};
    System.out.println(minimumCost(cost));
  }
}

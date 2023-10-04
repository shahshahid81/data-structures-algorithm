import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {

  public static int maxProfit(
    ArrayList<Integer> values,
    ArrayList<Integer> weights,
    int n,
    int maxWeight
  ) {
    int dp[][] = new int[n][maxWeight + 1];

    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }

    return maxProfit(values, weights, n - 1, maxWeight, dp);
  }

  private static int maxProfit(
    ArrayList<Integer> values,
    ArrayList<Integer> weights,
    int index,
    int maxWeight,
    int[][] dp
  ) {
    if (index == 0) {
      return weights.get(0) <= maxWeight ? values.get(0) : 0;
    }

    if (dp[index][maxWeight] != -1) {
      return dp[index][maxWeight];
    }

    int notTaken = 0 + maxProfit(values, weights, index - 1, maxWeight, dp);

    int taken = Integer.MIN_VALUE;
    if (weights.get(index) <= maxWeight) {
      taken =
        values.get(index) +
        maxProfit(
          values,
          weights,
          index - 1,
          maxWeight - weights.get(index),
          dp
        );
    }

    dp[index][maxWeight] = Math.max(notTaken, taken);
    return dp[index][maxWeight];
  }
}

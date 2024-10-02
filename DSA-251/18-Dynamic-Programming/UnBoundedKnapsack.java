import java.util.Arrays;

public class UnBoundedKnapsack {

  public static int unboundedKnapsack(
    int n,
    int w,
    int[] profit,
    int[] weight
  ) {
    int[][] dp = new int[w + 1][n];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return unboundedKnapsack(weight, profit, w, 0, dp);
  }

  private static int unboundedKnapsack(
    int[] weights,
    int[] profits,
    int weight,
    int index,
    int[][] dp
  ) {
    if (index >= weights.length || weight <= 0) {
      return 0;
    }

    if (dp[weight][index] != -1) {
      return dp[weight][index];
    }

    return (
      dp[weight][index] =
        Math.max(
          weight >= weights[index]
            ? profits[index] +
            unboundedKnapsack(
              weights,
              profits,
              weight - weights[index],
              index,
              dp
            )
            : 0,
          unboundedKnapsack(weights, profits, weight, index + 1, dp)
        )
    );
  }
}

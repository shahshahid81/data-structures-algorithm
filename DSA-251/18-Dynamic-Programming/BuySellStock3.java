import java.util.Arrays;

public class BuySellStock3 {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][][] dp = new int[n][2][2];
    for (int[][] matrixRow : dp) {
      for (int[] row : matrixRow) {
        Arrays.fill(row, Integer.MAX_VALUE);
      }
    }
    return Math.max(0, maxProfit(prices, n, 0, 2, true, dp));
  }

  private int maxProfit(
    int[] prices,
    int n,
    int index,
    int k,
    boolean buy,
    int[][][] dp
  ) {
    if (k == 0 || index >= n) {
      return 0;
    }

    int buyingIndex = buy ? 0 : 1;
    if (dp[index][buyingIndex][2 - k] != Integer.MAX_VALUE) {
      return dp[index][buyingIndex][2 - k];
    }

    if (buy) {
      int take =
        -prices[index] +
        Math.max(maxProfit(prices, n, index + 1, k, false, dp), 0);
      int notTake = maxProfit(prices, n, index + 1, k, true, dp);
      return dp[index][buyingIndex][2 - k] = Math.max(take, notTake);
    }

    int take =
      prices[index] +
      Math.max(0, maxProfit(prices, n, index + 1, k - 1, true, dp));

    int notTake = maxProfit(prices, n, index + 1, k, false, dp);

    return dp[index][buyingIndex][2 - k] = Math.max(take, notTake);
  }
}

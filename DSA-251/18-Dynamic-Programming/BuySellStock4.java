public class BuySellStock4 {

  public int maxProfit(int k, int[] prices) {
    int[][][] dp = new int[k + 1][prices.length][2];
    for (int i = 0; i < k + 1; i++) {
      for (int j = 0; j < prices.length; j++) {
        dp[i][j][0] = -1;
        dp[i][j][1] = -1;
      }
    }
    return maxProfit(prices, k, 0, 1, dp);
  }

  private int maxProfit(int[] prices, int k, int index, int buy, int[][][] dp) {
    if (index >= prices.length || k == 0) {
      return 0;
    }
    
    if (dp[k][index][buy] != -1) {
      return dp[k][index][buy];
    }

    if (buy == 1) {
      return (
        dp[k][index][buy] =
          Math.max(
            maxProfit(prices, k, index + 1, 0, dp) - prices[index],
            maxProfit(prices, k, index + 1, 1, dp)
          )
      );
    }

    int take = maxProfit(prices, k - 1, index + 1, 1, dp) + prices[index];
    int notTake = maxProfit(prices, k, index + 1, 0, dp);
    return dp[k][index][buy] = Math.max(take, notTake);
  }
}

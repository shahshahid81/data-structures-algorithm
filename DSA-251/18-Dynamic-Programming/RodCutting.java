public class RodCutting {

  public static int cutRod(int prices[], int n) {
    int[][] dp = new int[n][prices.length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }

    return cutRod(prices, n, n, dp);
  }

  private static int cutRod(int prices[], int n, int rodLength, int[][] dp) {
    if (rodLength <= 0) {
      return 0;
    }

    int price = Integer.MIN_VALUE;
    for (int i = 0; i < rodLength; i++) {
      if (dp[rodLength - i - 1][i] == -1) {
        dp[rodLength - i - 1][i] =
          Math.max(price, prices[i] + cutRod(prices, n, rodLength - i - 1, dp));
      }
      price = dp[rodLength - i - 1][i];
    }

    return price;
  }
}

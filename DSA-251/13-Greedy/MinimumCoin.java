public class MinimumCoin {

  private static int[] coins = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

  public static int minimumCoins(int p) {
    if (p <= 0) {
      return 0;
    }

    int min = 0;

    for (int coin : coins) {
      if (p / coin > 0) {
        int n = (int) Math.floor(p / coin);
        min += n;
        p = p - (coin * n);
      }
    }

    return min;
  }
}

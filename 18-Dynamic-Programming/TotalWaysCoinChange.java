public class TotalWaysCoinChange {

  public int change(int amount, int[] coins) {
    int n = coins.length;
    int[] previous = new int[amount + 1];

    for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
      previous[currentAmount] = currentAmount % coins[0] == 0 ? 1 : 0;
    }

    for (int i = 1; i < n; i++) {
      int[] cur = new int[amount + 1];

      for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
        int notTake = previous[currentAmount];
        int take = 0;

        if (coins[i] <= currentAmount) {
          take = cur[currentAmount - coins[i]];
        }

        cur[currentAmount] = take + notTake;
      }
      previous = cur;
    }

    return previous[amount];
  }
}

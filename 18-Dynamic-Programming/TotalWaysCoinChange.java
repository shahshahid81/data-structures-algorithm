import java.util.Arrays;

class TotalWaysCoinChangeRecursionMemoization {

  public static long countWaysToMakeChange(int denominations[], int value) {
    long[][] dp = new long[value + 1][denominations.length];
    for (long[] row : dp) {
      Arrays.fill(row, -1);
    }
    return countWaysToMakeChange(denominations, value, 0, dp);
  }

  private static long countWaysToMakeChange(
    int[] denominations,
    int value,
    int index,
    long[][] dp
  ) {
    if (value < 0) {
      return 0;
    }

    if (dp[value][index] != -1) {
      return dp[value][index];
    }

    if (value == 0) {
      return dp[value][index] = 1;
    }

    long ways = 0;
    for (int i = index; i < denominations.length; i++) {
      long result = countWaysToMakeChange(
        denominations,
        value - denominations[i],
        i,
        dp
      );

      ways += result;
    }
    return dp[value][index] = ways;
  }
}

class TotalWaysCoinChangeTabulation {

  public static long countWaysToMakeChange(int denominations[], int value) {
    long[][] dp = new long[value + 1][denominations.length];
    for (long[] row : dp) {
      Arrays.fill(row, -1);
    }

    for (int i = 0; i < denominations.length; i++) {
      dp[0][i] = 1;
    }

    for (int currentValue = 1; currentValue <= value; currentValue++) {
      for (int j = 0; j < denominations.length; j++) {
        long result = 0;
        if (currentValue - denominations[j] == 0) {
          result += 1;
        } else if (currentValue - denominations[j] > 0) {
          result += dp[currentValue - denominations[j]][j];
        }

        if (j > 0) {
          result += dp[currentValue][j - 1];
        }
        dp[currentValue][j] = result;
      }
    }

    return dp[value][denominations.length - 1];
  }
}

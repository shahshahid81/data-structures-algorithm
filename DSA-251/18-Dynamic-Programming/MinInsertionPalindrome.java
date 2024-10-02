import java.util.Arrays;

public class MinInsertionPalindrome {

  public static int minInsertion(String str) {
    int n = str.length();
    int[][] dp = new int[n][n];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return minInsertion(str, dp, 0, n - 1);
  }

  private static int minInsertion(String str, int[][] dp, int low, int high) {
    if (low >= high) {
      return 0;
    }

    if (dp[low][high] != -1) {
      return dp[low][high];
    }

    if (str.charAt(low) == str.charAt(high)) {
      return dp[low][high] = minInsertion(str, dp, low + 1, high - 1);
    }

    return (
      dp[low][high] =
        (
          1 +
          Math.min(
            minInsertion(str, dp, low + 1, high),
            minInsertion(str, dp, low, high - 1)
          )
        )
    );
  }
}

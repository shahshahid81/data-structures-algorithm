import java.util.Arrays;

public class PalindromePartitionII {

  public static int palindromePartitioning(String str) {
    int n = str.length();
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return palindromePartitioning(str, n, 0, dp) - 1;
  }

  private static int palindromePartitioning(
    String str,
    int n,
    int i,
    int[] dp
  ) {
    if (i == n) {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }

    int mincost = Integer.MAX_VALUE;
    for (int j = i; j < n; j++) {
      if (isPalindrome(str, i, j)) {
        int cost = 1 + palindromePartitioning(str, n, j + 1, dp);
        mincost = Math.min(mincost, cost);
      }
    }
    return dp[i] = mincost;
  }

  private static boolean isPalindrome(String str, int start, int end) {
    while (start < end) {
      if (str.charAt(start) != str.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }
}

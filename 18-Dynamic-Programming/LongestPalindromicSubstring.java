import java.util.Arrays;

public class LongestPalindromicSubstring {

  public static String longestPalinSubstring(String str) {
    int n = str.length();
    String[][] dp = new String[n][n];
    for (String[] row : dp) {
      Arrays.fill(row, "");
    }
    return longestPalinSubstring(str, 0, n - 1, dp);
  }

  private static String longestPalinSubstring(
    String str,
    int start,
    int end,
    String[][] dp
  ) {
    if (start > end) {
      return "";
    }

    if (dp[start][end] != "") {
      return dp[start][end];
    }

    if (isPalindrome(str, start, end)) {
      return str.substring(start, end + 1);
    }

    String left = longestPalinSubstring(str, start, end - 1, dp);
    String right = longestPalinSubstring(str, start + 1, end, dp);

    return dp[start][end] = left.length() >= right.length() ? left : right;
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

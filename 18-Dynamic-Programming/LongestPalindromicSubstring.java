import java.util.Arrays;

public class LongestPalindromicSubstring {

  public String longestPalindrome(String str) {
    int n = str.length();
    String[][] dp = new String[n][n];
    for (String[] row : dp) {
      Arrays.fill(row, "");
    }
    return longestPalindrome(str, 0, n - 1, dp);
  }

  private String longestPalindrome(
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

    String left = longestPalindrome(str, start, end - 1, dp);
    String right = longestPalindrome(str, start + 1, end, dp);

    return dp[start][end] = left.length() >= right.length() ? left : right;
  }

  private boolean isPalindrome(String str, int start, int end) {
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

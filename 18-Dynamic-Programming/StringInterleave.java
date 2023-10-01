import java.util.Arrays;

public class StringInterleave {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i < s1.length() + 1; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    return isInterleave(s1, s2, s3, 0, 0, 0, dp);
  }

  private boolean isInterleave(
    String firstString,
    String secondString,
    String stringToMatch,
    int firstIndex,
    int secondIndex,
    int stringToMatchIndex,
    int[][] dp
  ) {
    if (
      firstIndex >= firstString.length() &&
      secondIndex >= secondString.length() &&
      stringToMatchIndex >= stringToMatch.length()
    ) {
      return true;
    }

    if (dp[firstIndex][secondIndex] != Integer.MAX_VALUE) {
      return dp[firstIndex][secondIndex] != -1;
    }

    boolean isFirstIndexMatching = false;

    if (
      firstIndex < firstString.length() &&
      stringToMatchIndex < stringToMatch.length() &&
      firstString.charAt(firstIndex) == stringToMatch.charAt(stringToMatchIndex)
    ) {
      isFirstIndexMatching =
        isInterleave(
          firstString,
          secondString,
          stringToMatch,
          firstIndex + 1,
          secondIndex,
          stringToMatchIndex + 1,
          dp
        );
    }
    boolean isSecondIndexMatching = false;

    if (
      secondIndex < secondString.length() &&
      stringToMatchIndex < stringToMatch.length() &&
      secondString.charAt(secondIndex) ==
      stringToMatch.charAt(stringToMatchIndex)
    ) {
      isSecondIndexMatching =
        isInterleave(
          firstString,
          secondString,
          stringToMatch,
          firstIndex,
          secondIndex + 1,
          stringToMatchIndex + 1,
          dp
        );
    }

    dp[firstIndex][secondIndex] =
      (isFirstIndexMatching || isSecondIndexMatching) ? stringToMatchIndex : -1;

    return dp[firstIndex][secondIndex] != -1;
  }
}

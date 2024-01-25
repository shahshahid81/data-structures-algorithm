import java.util.Arrays;
import java.util.Collections;

public class LCS3Strings {

  public static int LCS(String A, String B, String C, int n, int m, int k) {
    int[][][] dp = new int[A.length()][B.length()][C.length()];
    for (int[][] matrix : dp) {
      for (int[] row : matrix) {
        Arrays.fill(row, -1);
      }
    }
    return LCS(A, B, C, 0, 0, 0, dp);
  }

  private static int LCS(
    String A,
    String B,
    String C,
    int i,
    int j,
    int k,
    int[][][] dp
  ) {
    if (i >= A.length() || j >= B.length() || k >= C.length()) {
      return 0;
    }

    if (dp[i][j][k] != -1) {
      return dp[i][j][k];
    }

    if (A.charAt(i) == B.charAt(j) && A.charAt(i) == C.charAt(k)) {
      return dp[i][j][k] = 1 + LCS(A, B, C, i + 1, j + 1, k + 1, dp);
    }

    return (
      dp[i][j][k] =
        max(
          LCS(A, B, C, i, j, k + 1, dp),
          LCS(A, B, C, i, j + 1, k, dp),
          LCS(A, B, C, i + 1, j, k, dp)
        )
    );
  }

  private static int max(Integer... vals) {
    return Collections.max(Arrays.asList(vals));
  }
}

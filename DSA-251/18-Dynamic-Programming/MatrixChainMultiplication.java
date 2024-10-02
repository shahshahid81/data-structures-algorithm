import java.util.Arrays;

public class MatrixChainMultiplication {

  public static int matrixMultiplicationTabulation(int[] arr, int n) {
    int[][] dp = new int[n][n];
    for (int i = 1; i < n; i++) {
      dp[i][i] = 0;
    }

    for (int l = 2; l < n; l++) {
      for (int i = 1; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (j == n) {
          continue;
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
          int temp = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
          dp[i][j] = Math.min(dp[i][j], temp);
        }
      }
    }

    return dp[1][n - 1];
  }

  public static int matrixMultiplicationRecursion(int[] arr, int N) {
    int[][] dp = new int[N][N];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return matrixMultiplication(arr, 1, N - 1, dp);
  }

  public static int matrixMultiplication(int[] arr, int i, int j, int[][] dp) {
    if (i >= j) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    int min = Integer.MAX_VALUE;
    for (int start = i; start < j; start++) {
      int cost =
        matrixMultiplication(arr, i, start, dp) +
        matrixMultiplication(arr, start + 1, j, dp) +
        (arr[i - 1] * arr[start] * arr[j]);
      min = Math.min(min, cost);
    }
    return dp[i][j] = min;
  }
}

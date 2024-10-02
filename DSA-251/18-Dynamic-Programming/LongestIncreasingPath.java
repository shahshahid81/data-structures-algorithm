import java.util.ArrayList;

public class LongestIncreasingPath {

  public static int longestIncreasingPath(
    ArrayList<ArrayList<Integer>> mat,
    int n,
    int m
  ) {
    boolean[][] visited = new boolean[n][m];
    int[][] dp = new int[n][m];

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max = Math.max(max, longestIncreasingPath(mat, i, j, visited, dp));
      }
    }
    return max;
  }

  private static int longestIncreasingPath(
    ArrayList<ArrayList<Integer>> mat,
    int i,
    int j,
    boolean[][] visited,
    int[][] dp
  ) {
    if (!isValidIndex(mat, i)) {
      return 0;
    }

    if (!isValidIndex(mat.get(i), j)) {
      return 0;
    }

    if (dp[i][j] != 0) {
      return dp[i][j];
    }

    int longestPath = 1;
    visited[i][j] = true;

    if (
      isValidIndex(mat, i + 1) &&
      mat.get(i).get(j) < mat.get(i + 1).get(j) &&
      !visited[i + 1][j]
    ) {
      longestPath =
        Math.max(
          longestPath,
          1 + longestIncreasingPath(mat, i + 1, j, visited, dp)
        );
    }

    if (
      isValidIndex(mat, i - 1) &&
      mat.get(i).get(j) < mat.get(i - 1).get(j) &&
      !visited[i - 1][j]
    ) {
      longestPath =
        Math.max(
          longestPath,
          1 + longestIncreasingPath(mat, i - 1, j, visited, dp)
        );
    }

    if (
      isValidIndex(mat.get(i), j + 1) &&
      mat.get(i).get(j) < mat.get(i).get(j + 1) &&
      !visited[i][j + 1]
    ) {
      longestPath =
        Math.max(
          longestPath,
          1 + longestIncreasingPath(mat, i, j + 1, visited, dp)
        );
    }

    if (
      isValidIndex(mat.get(i), j - 1) &&
      mat.get(i).get(j) < mat.get(i).get(j - 1) &&
      !visited[i][j - 1]
    ) {
      longestPath =
        Math.max(
          longestPath,
          1 + longestIncreasingPath(mat, i, j - 1, visited, dp)
        );
    }

    visited[i][j] = false;

    return dp[i][j] = longestPath;
  }

  private static boolean isValidIndex(ArrayList<?> list, int i) {
    return i >= 0 && i < list.size();
  }
}

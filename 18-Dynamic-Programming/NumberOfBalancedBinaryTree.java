public class NumberOfBalancedBinaryTree {

  private static final int MOD = 1000000007;

  public static int countBalancedBinaryTree(int n) {
    int[] dp = new int[n + 1];
    return countTree(n, dp);
  }

  private static int countTree(int height, int[] dp) {
    if (height == 0 || height == 1) {
      return 1;
    }

    if (dp[height] != 0) {
      return dp[height];
    }

    int countOne = countTree(height - 1, dp);
    int countTwo = countTree(height - 2, dp);

    return (
      dp[height] =
        (int) (
          (2L * countOne * countTwo) % MOD + (1L * countOne * countOne) % MOD
        ) %
        MOD
    );
  }
}

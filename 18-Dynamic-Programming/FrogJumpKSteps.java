// https://takeuforward.org/dynamic-programming/striver-dp-series-dynamic-programming-problems/

import java.util.Arrays;

class FrogJumpKRecursion {

  public static int minimizeCost(int n, int k, int[] height) {
    return minimizeCost(n, k, height, 0);
  }

  private static int minimizeCost(int n, int k, int[] height, int index) {
    if (index >= n - 1) {
      return 0;
    }

    int minCost = Integer.MAX_VALUE;
    for (int i = index + 1; i <= index + k && i < n; i++) {
      int result =
        Math.abs(height[i] - height[index]) + minimizeCost(n, k, height, i);
      minCost = Math.min(minCost, result);
    }

    return minCost;
  }
}

class FrogJumpKRecursionMemoization {

  public static int minimizeCost(int n, int k, int[] height) {
    int[] dp = new int[n];
    Arrays.fill(dp, -1);

    return minimizeCost(n, k, height, dp, 0);
  }

  private static int minimizeCost(
    int n,
    int k,
    int[] height,
    int[] dp,
    int index
  ) {
    if (index >= n - 1) {
      return 0;
    }

    if (dp[index] != -1) {
      return dp[index];
    }

    int minCost = Integer.MAX_VALUE;
    for (int i = index + 1; i <= index + k && i < n; i++) {
      int result =
        Math.abs(height[i] - height[index]) + minimizeCost(n, k, height, dp, i);

      minCost = Math.min(minCost, result);
    }

    dp[index] = minCost;

    return dp[index];
  }
}

class FrogJumpKTabulation {

  public static int minimizeCost(int n, int k, int[] height) {
    int[] dp = new int[n];

    for (int i = 1; i < n; i++) {
      int minCost = Integer.MAX_VALUE;
      for (int j = 1; j <= k && i - j >= 0; j++) {
        int result = Math.abs(height[i] - height[i - j]) + dp[i - j];
        minCost = Math.min(minCost, result);
      }
      dp[i] = minCost;
    }

    return dp[n - 1];
  }
}

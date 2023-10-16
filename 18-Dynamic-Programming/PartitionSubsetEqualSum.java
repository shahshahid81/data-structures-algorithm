import java.util.Arrays;

public class PartitionSubsetEqualSum {

  public static boolean canPartition(int[] arr, int n) {
    int totalSum = 0;
    for (int el : arr) {
      totalSum += el;
    }

    int[][] dp = new int[n][totalSum];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return canPartition(arr, n, 0, totalSum, 0, dp);
  }

  private static boolean canPartition(
    int[] arr,
    int n,
    int currentSum,
    int totalSum,
    int index,
    int[][] dp
  ) {
    if (index >= n) {
      return currentSum * 2 == totalSum;
    }

    if (dp[index][currentSum] != -1) {
      return dp[index][currentSum] == 1;
    }

    boolean take = canPartition(
      arr,
      n,
      currentSum + arr[index],
      totalSum,
      index + 1,
      dp
    );

    boolean notTake = canPartition(arr, n, currentSum, totalSum, index + 1, dp);

    dp[index][currentSum] = (take || notTake) ? 1 : 0;
    return take || notTake;
  }
}

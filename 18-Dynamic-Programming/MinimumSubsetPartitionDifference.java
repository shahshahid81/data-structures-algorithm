import java.util.Arrays;

public class MinimumSubsetPartitionDifference {

  public static int minSubsetSumDifference(int[] arr, int n) {
    int sum = 0;
    for (int num : arr) {
      sum += num;
    }

    int[][] dp = new int[n][sum + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return minSubsetSumDifference(arr, 0, sum, 0, dp);
  }

  private static int minSubsetSumDifference(
    int[] arr,
    int leftSum,
    int sum,
    int index,
    int[][] dp
  ) {
    int rightSum = sum - leftSum;

    if (index >= arr.length) {
      return Math.abs(rightSum - leftSum);
    }

    if (dp[index][leftSum] != -1) {
      return dp[index][leftSum];
    }

    return (
      dp[index][leftSum] =
        Math.min(
          minSubsetSumDifference(arr, leftSum + arr[index], sum, index + 1, dp),
          minSubsetSumDifference(arr, leftSum, sum, index + 1, dp)
        )
    );
  }
}

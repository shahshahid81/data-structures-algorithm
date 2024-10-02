import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    int max = 1;
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; i++) {
      int longest = Integer.MIN_VALUE;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[j] < nums[i]) {
          longest = Math.max(longest, dp[j]);
        }
      }
      dp[i] = longest == Integer.MIN_VALUE ? 1 : ++longest;
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}

public class MaxSubArray {

  // Leetcode
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int currentIndex = 0;
    int sum = 0;
    while (currentIndex < nums.length) {
      sum += nums[currentIndex];
      max = Math.max(sum, max);
      if (sum <= 0) sum = 0;
      currentIndex++;
    }
    return max;
  }

  // Code Studio
  public long maxSubarraySum(int[] arr) {
    int leftSum = 0, maxSum = 0, n = arr.length;
    for (int i = 0; i < n; i++) {
      leftSum += arr[i];
      if (leftSum < 0) leftSum = 0;
      maxSum = Math.max(leftSum, maxSum);
    }
    return maxSum;
  }
}

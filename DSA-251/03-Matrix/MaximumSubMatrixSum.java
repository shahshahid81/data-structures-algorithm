public class MaximumSubMatrixSum {

  private int getMaxSum(int[] arr) {
    int maxSum = Integer.MIN_VALUE, currentSum = 0;
    for (int i = 0; i < arr.length; i++) {
      currentSum += arr[i];
      maxSum = Math.max(currentSum, maxSum);
      if (currentSum < 0) currentSum = 0;
    }
    return maxSum;
  }

  public int maxSumRectangle(int[][] arr, int rows, int columns) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < columns; i++) {
      int[] sumArray = new int[rows];
      for (int j = i; j < columns; j++) {
        for (int k = 0; k < rows; k++) {
          sumArray[k] += arr[k][j];
        }
        maxSum = Math.max(maxSum, getMaxSum(sumArray));
      }
    }

    return maxSum;
  }
}

public class TwoSum {

  public static int pairSum(int sortedArr[], int n, int target) {
    int i = 0, j = n - 1, pairSum = 0;
    while (i < j) {
      int sum = sortedArr[i] + sortedArr[j];
      if (sum == target) {
        pairSum++;
        i++;
        j--;
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return pairSum == 0 ? -1 : pairSum;
  }
}

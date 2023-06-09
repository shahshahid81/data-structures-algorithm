public class TwoSum {

  public int pairSum(int sortedArr[], int target) {
    int i = 0, j = sortedArr.length - 1, pairSum = 0;
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

import java.util.ArrayList;

public class MaxSubArrayKConcat {

  public long maxSubSumKConcat(ArrayList<Integer> arr, int k) {
    long sum = 0;
    int n = arr.size();
    for (int x : arr) {
      sum += x;
    }
    sum = (sum < 0) ? 0 : sum;
    long currSum = arr.get(0);
    long res = currSum;
    for (int i = 1; i < n * 2; i++) {
      if (currSum < 0) {
        currSum = arr.get(i % n);
      } else {
        currSum += arr.get(i % n);
      }
      res = Math.max(res, currSum);
    }
    res += (k - 2) * Math.max(sum, 0);
    return res;
  }
}

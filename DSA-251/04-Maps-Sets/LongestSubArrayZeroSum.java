import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubArrayZeroSum {

  public int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
    int sum = 0, maxSubset = 0, n = arr.size();
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      sum += arr.get(i);

      if (sum == 0) maxSubset = i + 1;

      Integer prev_i = hashMap.get(sum);

      if (prev_i != null) {
        maxSubset = Math.max(maxSubset, i - prev_i);
      } else {
        hashMap.put(sum, i);
      }
    }

    return maxSubset;
  }
}

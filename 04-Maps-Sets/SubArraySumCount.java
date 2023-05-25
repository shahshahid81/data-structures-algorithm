import java.util.HashMap;

public class SubArraySumCount {
  public int findAllSubarraysWithGivenSum(int arr[], int s) {
    if (arr == null || arr.length == 0) return 0;
    int[] prefixSum = new int[arr.length];
    int count = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      prefixSum[i] = arr[i] + (i > 0 ? prefixSum[i - 1] : 0);
      if (prefixSum[i] == s) count++;
      hashMap.put(prefixSum[i], hashMap.getOrDefault(prefixSum[i], 0) + 1);
    }

    for (int i = prefixSum.length - 1; i >= 0; i--) {
      int target = prefixSum[i] - s;
      if (hashMap.containsKey(target)) {
        count = count + hashMap.get(target);
      }
    }

    return count;
  }
}

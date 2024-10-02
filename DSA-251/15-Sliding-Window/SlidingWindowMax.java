import java.util.TreeMap;

public class SlidingWindowMax {

  public int[] maxSlidingWindow(int[] arr, int k) {
    int n = arr.length;
    int[] result = new int[n + 1 - k];

    if (k > n) {
      return result;
    }

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int idx = 0;
    for (int i = 0; i < k; i++) {
      treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
    }
    result[idx++] = treeMap.lastKey();

    for (int i = k; i < n; i++) {
      if (treeMap.get(arr[i - k]) == 1) {
        treeMap.remove(arr[i - k]);
      } else {
        treeMap.put(arr[i - k], treeMap.get(arr[i - k]) - 1);
      }

      treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
      result[idx++] = treeMap.lastKey();
    }

    return result;
  }
}

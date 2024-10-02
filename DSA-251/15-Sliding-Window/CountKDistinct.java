import java.util.ArrayList;
import java.util.HashMap;

public class CountKDistinct {

  public static ArrayList<Integer> countDistinctElements(
    ArrayList<Integer> arr,
    int k
  ) {
    ArrayList<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < k; i++) {
      hashMap.put(arr.get(i), hashMap.getOrDefault(arr.get(i), 0) + 1);
    }
    result.add(hashMap.size());

    int start = 0, end = k, n = arr.size();
    while (end < n) {
      if (hashMap.get(arr.get(start)) == 1) {
        hashMap.remove(arr.get(start));
      } else {
        hashMap.put(arr.get(start), hashMap.get(arr.get(start)) - 1);
      }

      hashMap.put(arr.get(end), hashMap.getOrDefault(arr.get(end), 0) + 1);

      start++;
      end++;
      result.add(hashMap.size());
    }

    return result;
  }
}

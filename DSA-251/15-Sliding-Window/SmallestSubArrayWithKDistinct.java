import java.util.ArrayList;
import java.util.HashMap;

public class SmallestSubArrayWithKDistinct {

  public static ArrayList<Integer> smallestSubarrayWithKDistinct(
    ArrayList<Integer> arr,
    int k
  ) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int start = 0, end = 0, n = arr.size();
    int min = Integer.MAX_VALUE, minStart = -1, minEnd = -1;

    while (end < n) {
      int endElement = arr.get(end);
      if (!hashMap.containsKey(endElement)) {
        hashMap.put(endElement, 1);
      } else {
        hashMap.put(endElement, hashMap.get(endElement) + 1);
      }

      while (hashMap.size() == k) {
        int subArraySize = end - start + 1;

        if (subArraySize < min) {
          min = subArraySize;
          minStart = start;
          minEnd = end;
        }

        int startElement = arr.get(start);
        if (hashMap.get(startElement) == 1) {
          hashMap.remove(startElement);
        } else {
          hashMap.put(startElement, hashMap.get(startElement) - 1);
        }
        start++;
      }

      end++;
    }

    ArrayList<Integer> result = new ArrayList<>();
    if (minStart == -1) {
      result.add(minStart);
    } else {
      result.add(minStart);
      result.add(minEnd);
    }
    return result;
  }
}

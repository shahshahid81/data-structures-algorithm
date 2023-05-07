import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MakeArrayUnique {

  // TC: O(log n) SC: O(1)
  public static int minElementsToRemoveUsingSort(ArrayList<Integer> arr) {
    Collections.sort(arr);
    int i = 0, count = 0, n = arr.size();
    while (i < n) {
      int j = i + 1;
      while (j < n && arr.get(i) == arr.get(j)) {
        j++;
        count++;
      }
      i = j;
    }

    return count;
  }

  // TC: O(n) SC: O(n)
  public static int minElementsToRemoveUsingSet(ArrayList<Integer> arr) {
    HashSet<Integer> hs = new HashSet<Integer>();
    for (Integer element : arr) {
      hs.add(element);
    }
    return arr.size() - hs.size();
  }
}

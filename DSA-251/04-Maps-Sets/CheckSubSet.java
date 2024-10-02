import java.util.HashMap;

public class CheckSubSet {

  public static boolean checkSubset(int[] arr1, int[] arr2, int n, int m) {
    if (m > n) return false;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int elem : arr1) hashMap.put(elem, hashMap.getOrDefault(elem, 0) + 1);
    for (int elem : arr2) {
      if (!hashMap.containsKey(elem) || hashMap.get(elem) == 0) return false;
      hashMap.put(elem, hashMap.get(elem) - 1);
    }
    return true;
  }
}

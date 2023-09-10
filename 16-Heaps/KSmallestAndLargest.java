import java.util.ArrayList;
import java.util.Collections;

public class KSmallestAndLargest {

  public static ArrayList<Integer> kthSmallLarge(
    ArrayList<Integer> arr,
    int n,
    int k
  ) {
    Collections.sort(arr);
    ArrayList<Integer> list = new ArrayList<>();
    list.add(arr.get(--k));
    list.add(arr.get(arr.size() - 1 - k));
    return list;
  }
}

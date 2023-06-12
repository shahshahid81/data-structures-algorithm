import java.util.ArrayList;

public class FindKthElement {

  public int findKthElement(
    ArrayList<Integer> arr1,
    ArrayList<Integer> arr2,
    int k
  ) {
    int i = 0, j = 0;

    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) <= arr2.get(j)) {
        if (k == 1) {
          return arr1.get(i);
        }
        i++;
      } else {
        if (k == 1) {
          return arr2.get(j);
        }
        j++;
      }
      k--;
    }

    while (i < arr1.size()) {
      if (k == 1) {
        return arr1.get(i);
      }
      i++;
      k--;
    }

    while (j < arr2.size()) {
      if (k == 1) {
        return arr2.get(j);
      }
      j++;
      k--;
    }

    return -1;
  }
}

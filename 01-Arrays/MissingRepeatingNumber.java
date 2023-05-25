import java.util.ArrayList;

public class MissingRepeatingNumber {

  public int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
    int repeatingElement = 0, missingElement = 0;
    for (int i = 0; i < n; i++) {
      int index = Math.abs(arr.get(i)) - 1;
      if (arr.get(index) > 0) {
        arr.set(index, -arr.get(index));
      } else {
        repeatingElement = index + 1;
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr.get(i) > 0) {
        missingElement = i + 1;
      }
    }

    return new int[] { missingElement, repeatingElement };
  }
}

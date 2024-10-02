import java.util.ArrayList;
import java.util.Arrays;

public class RowWiseSortedMatrixMedian {

  public int getMedian(ArrayList<ArrayList<Integer>> matrix) {
    int rows = matrix.size(), columns = matrix.get(0).size();

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < rows; i++) {
      if (matrix.get(i).get(0) < min) {
        min = matrix.get(i).get(0);
      }

      if (matrix.get(i).get(columns - 1) > max) {
        max = matrix.get(i).get(columns - 1);
      }
    }

    int desired = (rows * columns + 1) / 2;
    while (min < max) {
      int mid = min + (max - min) / 2;
      int place = 0;
      int get = 0;

      for (int i = 0; i < rows; ++i) {
        get =
          Arrays.binarySearch(
            matrix.get(i).stream().mapToInt(val -> val).toArray(),
            mid
          );

        if (get < 0) {
          get = Math.abs(get) - 1;
        } else {
          while (get < matrix.get(i).size() && matrix.get(i).get(get) == mid) {
            get += 1;
          }
        }

        place = place + get;
      }

      if (place < desired) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }
}

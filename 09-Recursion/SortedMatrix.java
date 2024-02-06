import java.util.ArrayList;
import java.util.List;

public class SortedMatrix {

  public static List<Integer> sortedMatrix(int[][] mat, int n) {
    return sortedMatrix(mat, 0, mat.length - 1);
  }

  private static List<Integer> sortedMatrix(int[][] mat, int low, int high) {
    if (low == high) {
      List<Integer> result = new ArrayList<>(mat.length);
      for (int i = 0; i < mat.length; i++) {
        result.add(mat[low][i]);
      }
      return result;
    }

    int mid = low + (high - low) / 2;
    List<Integer> left = sortedMatrix(mat, low, mid);
    List<Integer> right = sortedMatrix(mat, mid + 1, high);

    int n = left.size(), m = right.size();
    List<Integer> result = new ArrayList<>(n + m);
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (left.get(i) <= right.get(j)) {
        result.add(left.get(i++));
      } else {
        result.add(right.get(j++));
      }
    }

    while (i < n) {
      result.add(left.get(i++));
    }

    while (j < m) {
      result.add(right.get(j++));
    }

    return result;
  }
}

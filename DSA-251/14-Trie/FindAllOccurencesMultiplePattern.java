import java.util.*;

public class FindAllOccurencesMultiplePattern {
  public static int[][] findOccurrences(String S, String[] arr) {
    List<List<Integer>> list = new ArrayList<>(arr.length);

    for (int i = 0; i < arr.length; i++) {
      List<Integer> row = new ArrayList<>();
      findOccurrences(S, arr[i], row);
      list.add(row);
    }

    int[][] result = new int[arr.length][];
    for (int i = 0; i < arr.length; i++) {
      int n = list.get(i).size();
      result[i] = new int[n];
      for (int j = 0; j < n; j++) {
        result[i][j] = list.get(i).get(j);
      }
    }
    return result;
  }

  private static void findOccurrences(String string, String subString, List<Integer> row) {
    int n = string.length();
    for (int i = 0; i < n; i++) {
      boolean isMatch = isStringEqual(string, subString, i);
      if (isMatch) {
        row.add(i);
      }
    }
  }

  private static boolean isStringEqual(String string, String subString, int i) {
    int n = string.length(), m = subString.length(), j = 0;
    while (i < n && j < m) {
      if (string.charAt(i++) != subString.charAt(j++)) {
        return false;
      }
    }
    return j == m;
  }
}

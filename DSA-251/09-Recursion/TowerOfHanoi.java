import java.util.ArrayList;

public class TowerOfHanoi {

  public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (n > 0) {
      towerOfHanoi(n, 1, 2, 3, result);
    }
    return result;
  }

  private static void towerOfHanoi(
    int n,
    int s,
    int a,
    int d,
    ArrayList<ArrayList<Integer>> result
  ) {
    if (n == 1) {
      ArrayList<Integer> row = new ArrayList<>();
      row.add(s);
      row.add(d);
      result.add(row);
    } else {
      towerOfHanoi(n - 1, s, d, a, result);
      ArrayList<Integer> row = new ArrayList<>();
      row.add(s);
      row.add(d);
      result.add(row);
      towerOfHanoi(n - 1, a, s, d, result);
    }
  }
}

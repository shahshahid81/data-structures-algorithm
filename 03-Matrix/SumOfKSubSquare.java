import java.util.ArrayList;

public class SumOfKSubSquare {

  public static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(
    ArrayList<ArrayList<Integer>> arr,
    int k
  ) {
    if (k == 1) return arr;

    int n = arr.size(), rowSize = n - k + 1;
    int[][] columnSum = new int[rowSize][n];

    for (int j = 0; j < n; j++) {
      int sum = 0;
      for (int i = 0; i < k; i++) {
        sum += arr.get(i).get(j);
      }
      columnSum[0][j] = sum;

      for (int i = 1; i < rowSize; i++) {
        sum += (arr.get(i + k - 1).get(j) - arr.get(i - 1).get(j));
        columnSum[i][j] = sum;
      }
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = 0; i < rowSize; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      int sum = 0;

      for (int j = 0; j < k; j++) {
        sum += columnSum[i][j];
      }
      row.add(sum);

      for (int j = 1; j < rowSize; j++) {
        sum += (columnSum[i][j + k - 1] - columnSum[i][j - 1]);
        row.add(sum);
      }

      result.add(row);
    }

    return result;
  }
}

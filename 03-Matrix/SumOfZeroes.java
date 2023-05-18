import java.util.ArrayList;

public class SumOfZeroes {

  private boolean isIndexValid(int index, int length) {
    return index >= 0 && index < length;
  }

  public Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {
    int rows = mat.size();
    int columns = mat.get(0).size();

    int sum = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (mat.get(i).get(j) == 1) continue;
        if (isIndexValid(i - 1, rows)) {
          sum += mat.get(i - 1).get(j);
        }

        if (isIndexValid(i + 1, rows)) {
          sum += mat.get(i + 1).get(j);
        }

        if (isIndexValid(j - 1, columns)) {
          sum += mat.get(i).get(j - 1);
        }

        if (isIndexValid(j + 1, columns)) {
          sum += mat.get(i).get(j + 1);
        }
      }
    }

    return sum;
  }
}

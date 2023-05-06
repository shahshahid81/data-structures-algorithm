public class SetMatrixZero {

  public static void setZeros(int matrix[][]) {
    int rows = matrix.length;
    int columns = matrix[0].length;

    boolean isFirstRowZero = false;
    for (int i = 0; i < columns; i++) {
      if (matrix[0][i] == 0) {
        isFirstRowZero = true;
        break;
      }
    }

    boolean isFirstColumnZero = false;
    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) {
        isFirstColumnZero = true;
        break;
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (isFirstRowZero) {
      for (int i = 0; i < columns; i++) {
        matrix[0][i] = 0;
      }
    }

    if (isFirstColumnZero) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}

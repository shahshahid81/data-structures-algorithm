public class SymmetricMatrix {

  public boolean isMatrixSymmetric(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] != matrix[j][i]) return false;
      }
    }

    return true;
  }
}

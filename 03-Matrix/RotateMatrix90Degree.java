public class RotateMatrix90Degree {

  public void rotateClockwise(int[][] matrix) {
    transpose(matrix);
    rotateClockwiseFromDiagonal(matrix);
  }

  public void rotateAntiClockwise(int[][] matrix) {
    transpose(matrix);
    rotateAntiClockwiseFromDiagonal(matrix);
  }

  private void transpose(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }

  private void rotateClockwiseFromDiagonal(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }
  }

  private void rotateAntiClockwiseFromDiagonal(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - i][j];
        matrix[n - 1 - i][j] = temp;
      }
    }
  }
}

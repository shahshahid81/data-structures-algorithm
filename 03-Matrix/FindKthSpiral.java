public class FindKthSpiral {

  public static int findKthElement(int[][] matrix, int k) {
    int minRow = 0, maxRow = matrix.length - 1;
    int minCol = 0, maxCol = matrix[0].length - 1;

    while (minRow <= maxRow && minCol <= maxCol) {
      if (k > (maxCol - minCol + 1)) {
        k = k - (maxCol - minCol + 1);
        minRow++;
      } else {
        return matrix[minRow][minCol + (k - 1)];
      }

      if (k > (maxRow - minRow + 1)) {
        k = k - (maxRow - minRow + 1);
        maxCol--;
      } else {
        return matrix[minRow + (k - 1)][maxCol];
      }

      if (k > (maxCol - minCol + 1)) {
        k = k - (maxCol - minCol + 1);
        maxRow--;
      } else {
        return matrix[maxRow][maxCol - (k - 1)];
      }

      if (k > (maxRow - minRow + 1)) {
        k = k - (maxRow - minRow + 1);
        minCol++;
      } else {
        return matrix[maxRow - (k - 1)][minCol];
      }
    }

    return -1;
  }
}

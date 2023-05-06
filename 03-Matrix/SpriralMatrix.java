public class SpriralMatrix {

  public static void spiralPrint(int matrix[][]) {
    if (matrix.length == 0) return;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i].length == 0) return;
    }

    int minRow = 0, maxRow = matrix.length - 1;
    int minColumn = 0, maxColumn = matrix[0].length - 1;
    StringBuilder sb = new StringBuilder();

    while (maxColumn >= minColumn && maxRow >= minRow) {
      for (
        int i = minColumn;
        i <= maxColumn && maxColumn >= minColumn && maxRow >= minRow;
        i++
      ) {
        sb.append(matrix[minRow][i] + " ");
      }
      minRow++;

      for (
        int i = minRow;
        i <= maxRow && maxColumn >= minColumn && maxRow >= minRow;
        i++
      ) {
        sb.append(matrix[i][maxColumn] + " ");
      }
      maxColumn--;

      for (
        int i = maxColumn;
        i >= minColumn && maxColumn >= minColumn && maxRow >= minRow;
        i--
      ) {
        sb.append(matrix[maxRow][i] + " ");
      }
      maxRow--;

      for (
        int i = maxRow;
        i >= minRow && maxColumn >= minColumn && maxRow >= minRow;
        i--
      ) {
        sb.append(matrix[i][minColumn] + " ");
      }
      minColumn++;
    }
    System.out.println(sb.toString().trim());
  }
}

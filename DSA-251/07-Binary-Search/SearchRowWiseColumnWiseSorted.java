class Pair {

  int x;
  int y;

  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class SearchRowWiseColumnWiseSorted {

  public static Pair search(int[][] matrix, int x) {
    int n = matrix.length - 1;
    int row = 0, column = n;
    while (row >= 0 && row <= n && column >= 0 && column <= n) {
      if (matrix[row][column] == x) {
        return new Pair(row, column);
      } else if (matrix[row][column] > x) {
        column--;
      } else {
        row++;
      }
    }
    return new Pair(-1, -1);
  }
}

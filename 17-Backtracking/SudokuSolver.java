public class SudokuSolver {

  private final int n = 9;

  public void solveSudoku(char[][] board) {
    solveSudokuBoard(board);
  }

  public boolean solveSudokuBoard(char[][] board) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.') {
          for (char digit = '1'; digit <= '9'; digit++) {
            if (!isValid(board, i, j, digit)) {
              continue;
            }

            board[i][j] = digit;
            boolean isValid = solveSudokuBoard(board);
            if (!isValid) {
              board[i][j] = '.';
            } else {
              break;
            }
          }
        }

        if (board[i][j] == '.') {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isValid(char[][] board, int row, int column, int digit) {
    for (int i = 0; i < n; i++) {
      if (board[row][i] == digit || board[i][column] == digit) {
        return false;
      }
    }

    int rowStart = (row / 3) * 3;
    int columnStart = (column / 3) * 3;

    for (int i = rowStart; i < rowStart + 3; i++) {
      for (int j = columnStart; j < columnStart + 3; j++) {
        if (board[i][j] == digit) {
          return false;
        }
      }
    }

    return true;
  }
}

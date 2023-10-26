import java.util.LinkedList;
import java.util.Queue;

class Coordinates {

  int rowNumber;
  int columnNumber;

  public Coordinates(int cellNumber, int n) {
    this.rowNumber = (cellNumber - 1) / n;
    this.columnNumber = (cellNumber - 1) % n;

    if (this.rowNumber % 2 == 1) {
      this.columnNumber = (n - 1) - this.columnNumber;
    }

    this.rowNumber = (n - 1) - this.rowNumber;
  }
}

public class SnakeAndLadder {

  public static int minDiceThrowToLastCell(int[][] board) {
    int n = board.length, totalCells = n * n;

    int[] minDiceThrow = new int[totalCells + 1];
    int i;

    for (i = 1; i <= totalCells; i++) {
      minDiceThrow[i] = Integer.MAX_VALUE;
    }

    Queue<Integer> queue = new LinkedList<>();

    minDiceThrow[1] = 0;
    queue.add(1);

    while (!queue.isEmpty()) {
      int currentCellNumber = queue.poll();

      for (i = 1; i <= 6 && currentCellNumber + i <= totalCells; i++) {
        int nextCellNumber = currentCellNumber + i;
        Coordinates nextCell = new Coordinates(nextCellNumber, n);

        if (board[nextCell.rowNumber][nextCell.columnNumber] != -1) {
          nextCellNumber = board[nextCell.rowNumber][nextCell.columnNumber];
        }

        if (
          minDiceThrow[nextCellNumber] > minDiceThrow[currentCellNumber] + 1
        ) {
          minDiceThrow[nextCellNumber] = minDiceThrow[currentCellNumber] + 1;
          queue.add(nextCellNumber);
        }
      }
    }

    int finalMinDiceThrowToLastCell = minDiceThrow[totalCells];
    if (finalMinDiceThrowToLastCell == Integer.MAX_VALUE) {
      finalMinDiceThrowToLastCell = -1;
    }
    return finalMinDiceThrowToLastCell;
  }
}

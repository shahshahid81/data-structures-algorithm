import java.util.LinkedList;
import java.util.Queue;

class Entry {

  int row;
  int column;
  int distance;

  Entry(int row, int column, int distance) {
    this.row = row;
    this.column = column;
    this.distance = distance;
  }
}

public class ShortestPathBinaryMatrix {

  public static int findShortestPath(
    int[][] mat,
    int sourceX,
    int sourceY,
    int destX,
    int destY,
    int n,
    int m
  ) {
    int[] dX = { 0, -1, 0, 1 };
    int[] dY = { -1, 0, 1, 0 };
    boolean[][] visited = new boolean[n][m];
    Queue<Entry> queue = new LinkedList<>();
    queue.add(new Entry(sourceX, sourceY, 1));
    visited[sourceX][sourceY] = true;

    while (!queue.isEmpty()) {
      Entry entry = queue.poll();

      if (entry.row == destX && entry.column == destY) {
        return entry.distance;
      }

      for (int i = 0; i < dX.length; i++) {
        int row = entry.row + dX[i];
        int column = entry.column + dY[i];
        if (
          row >= 0 &&
          row < n &&
          column >= 0 &&
          column < m &&
          !visited[row][column]
        ) {
          visited[row][column] = true;
          if (mat[row][column] == 1) {
            queue.add(new Entry(row, column, 1 + entry.distance));
          }
        }
      }
    }

    return -1;
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int[] dX = { 0, -1, -1, -1, 0, 1, 1, 1 };
    int[] dY = { -1, -1, 0, 1, 1, 1, 0, -1 };

    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    Queue<Entry> queue = new LinkedList<>();
    if (grid[0][0] == 0) {
      queue.add(new Entry(0, 0, 1));
    }
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      Entry entry = queue.poll();

      if (entry.row == n - 1 && entry.column == n - 1) {
        return entry.distance;
      }

      for (int i = 0; i < dX.length; i++) {
        int row = entry.row + dX[i];
        int column = entry.column + dY[i];
        if (
          row >= 0 &&
          row < n &&
          column >= 0 &&
          column < n &&
          !visited[row][column]
        ) {
          visited[row][column] = true;
          if (grid[row][column] == 0) {
            queue.add(new Entry(row, column, 1 + entry.distance));
          }
        }
      }
    }

    return -1;
  }
}

import java.util.LinkedList;

class Pair {

  int first;
  int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}

class Data {

  Pair pair;
  int steps;

  public Data(Pair pair, int steps) {
    this.pair = pair;
    this.steps = steps;
  }
}

public class MinimumStepsToReachTargetKnight {

  public static int minSteps(
    Pair knightPosition,
    Pair targetPosition,
    int size
  ) {
    Pair knightPositionMatrix = getRowAndColumn(knightPosition, size);
    Pair targetPositionMatrix = getRowAndColumn(targetPosition, size);

    if (isEqual(knightPositionMatrix, targetPositionMatrix)) {
      return 0;
    }

    boolean[][] visited = new boolean[size][size];
    LinkedList<Data> queue = new LinkedList<>();

    queue.add(new Data(knightPositionMatrix, 0));
    visited[knightPositionMatrix.first][knightPositionMatrix.second] = true;

    while (!queue.isEmpty()) {
      Data knightPositionData = queue.poll();

      if (!isPairValid(knightPositionData.pair, size)) {
        continue;
      }

      if (isEqual(knightPositionData.pair, targetPositionMatrix)) {
        return knightPositionData.steps;
      }

      visited[knightPositionData.pair.first][knightPositionData.pair.second] =
        true;

      int[] rows = { 1, -1, -2, 2 };
      int[] oneColumns = { -1, 1 };
      int[] twoColumns = { -2, 2 };
      for (int row : rows) {
        int[] columns = row == 1 || row == -1 ? twoColumns : oneColumns;
        for (int column : columns) {
          Pair newPair = new Pair(
            knightPositionData.pair.first + row,
            knightPositionData.pair.second + column
          );
          queue.offer(new Data(newPair, knightPositionData.steps + 1));
        }
      }
    }

    return Integer.MAX_VALUE;
  }

  private static Pair getRowAndColumn(Pair pair, int size) {
    int row = size - pair.second;
    int column = pair.first - 1;
    return new Pair(row, column);
  }

  private static boolean isPairValid(Pair pair, int size) {
    return isIndexValid(pair.first, size) && isIndexValid(pair.second, size);
  }

  private static boolean isIndexValid(int index, int size) {
    return index >= 0 && index < size;
  }

  private static boolean isEqual(Pair pair, Pair otherPair) {
    return pair.first == otherPair.first && pair.second == otherPair.second;
  }
}

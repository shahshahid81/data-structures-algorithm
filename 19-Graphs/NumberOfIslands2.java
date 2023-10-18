import java.util.HashMap;

class Pair {

  int parent;
  int rank;

  public Pair(int parent, int rank) {
    this.parent = parent;
    this.rank = rank;
  }
}

class DisjointSet {

  HashMap<Integer, Pair> nodeMap;

  DisjointSet(int[] data) {
    nodeMap = new HashMap<>();
    for (int element : data) {
      Pair pair = new Pair(element, 0);
      nodeMap.put(element, pair);
    }
  }

  public void union(int first, int second) {
    int firstParent = this.find(first);
    if (firstParent == Integer.MAX_VALUE) {
      return;
    }

    int secondParent = this.find(second);
    if (secondParent == Integer.MAX_VALUE) {
      return;
    }

    if (firstParent == secondParent) {
      return;
    }

    Pair firstParentNode = nodeMap.get(firstParent);
    Pair secondParentNode = nodeMap.get(secondParent);

    if (firstParentNode.rank == secondParentNode.rank) {
      firstParentNode.parent = secondParentNode.parent;
      firstParentNode.rank += 1;
    } else if (firstParentNode.rank > secondParentNode.rank) {
      secondParentNode.parent = firstParentNode.parent;
    } else {
      firstParentNode.parent = secondParentNode.parent;
    }
  }

  public int find(int element) {
    if (!nodeMap.containsKey(element)) {
      return Integer.MAX_VALUE;
    }

    if (nodeMap.get(element).parent == element) {
      return element;
    }

    int foundParent = find(nodeMap.get(element).parent);
    nodeMap.get(element).parent = foundParent;

    return foundParent;
  }
}

public class NumberOfIslands2 {

  public static int[] numberOfIslandII(
    int rowSize,
    int columnSize,
    int[][] queries,
    int q
  ) {
    int[] result = new int[q];
    int[][] grid = new int[rowSize][columnSize];
    int count = 0, k = 0;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };

    int[] data = new int[rowSize * columnSize];
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        data[i * columnSize + j] = i * columnSize + j;
      }
    }
    DisjointSet ds = new DisjointSet(data);

    for (int[] query : queries) {
      int row = query[0], column = query[1];
      grid[row][column] = 1;
      count++;

      for (int i = 0; i < 4; i++) {
        int adjacentRow = row + dx[i];
        int adjacentColumn = column + dy[i];

        if (
          adjacentRow >= 0 &&
          adjacentRow < rowSize &&
          adjacentColumn >= 0 &&
          adjacentColumn < columnSize &&
          grid[adjacentRow][adjacentColumn] == 1
        ) {
          if (
            ds.find(row * columnSize + column) !=
            ds.find(adjacentRow * columnSize + adjacentColumn)
          ) {
            count--;
            ds.union(
              row * columnSize + column,
              adjacentRow * columnSize + adjacentColumn
            );
          }
        }
      }

      result[k++] = count;
    }

    return result;
  }
}

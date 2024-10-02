import java.util.ArrayList;

public class FloydWarshall {

  static final int MAX_VALUE = 1000000000;

  static int floydWarshall(
    int vertices,
    int edges,
    int source,
    int destination,
    ArrayList<ArrayList<Integer>> edgeList
  ) {
    int[][] adjacencyMatrix = new int[vertices][vertices];

    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        adjacencyMatrix[i][j] = i == j ? 0 : MAX_VALUE;
      }
    }

    for (ArrayList<Integer> edge : edgeList) {
      int u = edge.get(0) - 1;
      int v = edge.get(1) - 1;
      int w = edge.get(2);
      adjacencyMatrix[u][v] = w;
    }

    for (int k = 0; k < vertices; k++) {
      for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
          if (i == k || j == k) {
            continue;
          }

          int value = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
          if (
            adjacencyMatrix[i][k] == MAX_VALUE ||
            adjacencyMatrix[k][j] == MAX_VALUE
          ) {
            value = MAX_VALUE;
          }

          adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j], value);
        }
      }
    }

    return adjacencyMatrix[source - 1][destination - 1];
  }
}

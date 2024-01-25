import java.util.Arrays;

public class CityWithSmallestNumberOfNeighbours {

  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] matrix = new int[n][n];
    for (int[] row : matrix) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    for (int[] edge : edges) {
      int i = edge[0], j = edge[1], w = edge[2];
      matrix[i][j] = w;
      matrix[j][i] = w;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (
            j == k ||
            matrix[j][i] == Integer.MAX_VALUE ||
            matrix[i][k] == Integer.MAX_VALUE
          ) {
            continue;
          }
          int newDistance = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
          matrix[j][k] = newDistance;
          matrix[k][j] = newDistance;
        }
      }
    }

    int min = Integer.MAX_VALUE, city = 0;

    for (int i = 0; i < n; i++) {
      int currentMin = 0;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] <= distanceThreshold) {
          currentMin++;
        }
      }
      if (currentMin <= min) {
        min = currentMin;
        city = i;
      }
    }

    return city;
  }
}

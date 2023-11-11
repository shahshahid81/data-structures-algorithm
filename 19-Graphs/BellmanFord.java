import java.util.Arrays;
import java.util.List;

public class BellmanFord {

  public static int[] bellmonFord(
    int vertices,
    int edges,
    int source,
    List<List<Integer>> edgeList
  ) {
    int[] distance = new int[vertices + 1];
    Arrays.fill(distance, (int) 1e8);
    distance[source] = 0;

    for (int i = 0; i < vertices - 1; i++) {
      for (List<Integer> edgeRow : edgeList) {
        int u = edgeRow.get(0);
        int v = edgeRow.get(1);
        int w = edgeRow.get(2);
        distance[v] = Math.min(distance[u] + w, distance[v]);
      }
    }

    return distance;
  }
}

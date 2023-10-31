import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {

  int node;
  int distance;

  Pair(int node, int distance) {
    this.node = node;
    this.distance = distance;
  }
}

public class DjikstraShortestPath {

  public static ArrayList<Integer> dijkstra(
    ArrayList<ArrayList<Integer>> vec,
    int vertices,
    int edges,
    int source
  ) {
    boolean[] visited = new boolean[vertices];
    ArrayList<Integer> distance = new ArrayList<>();

    int[][] graph = new int[vertices][vertices];

    for (int i = 0; i < vec.size(); i++) {
      int u = vec.get(i).get(0);
      int v = vec.get(i).get(1);
      int w = vec.get(i).get(2);
      if (graph[u][v] != 0) {
        graph[u][v] = Math.min(graph[u][v], w);
        graph[v][u] = Math.min(graph[v][u], w);
      } else {
        graph[u][v] = w;
        graph[v][u] = w;
      }
    }

    distance.add(0);
    for (int i = 1; i < vertices; i++) {
      distance.add((int) 1e9);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->
      a.distance - b.distance
    );
    pq.add(new Pair(0, 0));

    while (!pq.isEmpty()) {
      Pair pair = pq.remove();

      int node = pair.node;
      if (visited[node]) {
        continue;
      }

      visited[node] = true;

      for (int i = 0; i < vertices; i++) {
        if (
          !visited[i] &&
          graph[node][i] != 0 &&
          distance.get(node) + graph[node][i] < distance.get(i)
        ) {
          distance.set(i, distance.get(node) + graph[node][i]);
          pq.add(new Pair(i, distance.get(i)));
        }
      }
    }

    for (int i = 0; i < vertices; i++) {
      if (distance.get(i) == (int) 1e9) distance.set(i, Integer.MAX_VALUE);
    }

    return distance;
  }
}

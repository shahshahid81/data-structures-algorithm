import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {

  int node, weight, parent;

  Pair(int node, int weight, int parent) {
    this.node = node;
    this.weight = weight;
    this.parent = parent;
  }
}

public class PrimMST {

  private static ArrayList<ArrayList<Integer>> primsMST(
    ArrayList<ArrayList<Integer>> adjacencyList,
    int n
  ) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) ->
      a.weight - b.weight
    );
    boolean[] visited = new boolean[n];
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    pq.add(new Pair(0, 0, -1));

    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      int node = pair.node;
      if (visited[node]) {
        continue;
      }

      visited[node] = true;
      for (int i = 0; i < n; i++) {
        int neighbour = adjacencyList.get(node).get(i);
        if (neighbour != 0 && !visited[i]) {
          pq.add(new Pair(i, neighbour, node));
        }
      }

      if (pair.parent != -1) {
        ArrayList<Integer> row = new ArrayList<>();
        row.add(node + 1);
        row.add(pair.parent + 1);
        row.add(adjacencyList.get(node).get(pair.parent));
        result.add(row);
      }
    }

    return result;
  }

  public static ArrayList<ArrayList<Integer>> calculatePrimsMST(
    int n,
    int m,
    ArrayList<ArrayList<Integer>> g
  ) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        row.add(0);
      }
      graph.add(row);
    }

    for (int i = 0; i < m; i++) {
      int source = g.get(i).get(0) - 1;
      int destination = g.get(i).get(1) - 1;
      int weight = g.get(i).get(2);

      graph.get(source).set(destination, weight);
      graph.get(destination).set(source, weight);
    }

    return primsMST(graph, n);
  }
}

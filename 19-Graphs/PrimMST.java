import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {

  int value;
  int weight;

  Node(int value, int weight) {
    this.value = value;
    this.weight = weight;
  }

  Node() {}

  public int compare(Node a, Node b) {
    if (a.weight < b.weight) {
      return -1;
    } else if (a.weight > b.weight) {
      return 1;
    }
    return 0;
  }
}

public class PrimMST {

  static ArrayList<ArrayList<Integer>> primMST(
    ArrayList<ArrayList<Node>> graph,
    int n
  ) {
    int[] path = new int[n];
    int[] weight = new int[n];
    boolean[] mst = new boolean[n];
    for (int i = 0; i < n; i++) {
      weight[i] = Integer.MAX_VALUE;
      mst[i] = false;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());
    pq.add(new Node(0, 0));
    weight[0] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      mst[node.value] = true;
      for (Node i : graph.get(node.value)) {
        if (!mst[i.value] && weight[i.value] > i.weight) {
          weight[i.value] = i.weight;
          pq.add(new Node(i.value, i.weight));
          path[i.value] = node.value;
        }
      }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      result.add(new ArrayList<>());

      result.get(i).add(i + 1);
      result.get(i).add(path[i] + 1);
      result.get(i).add(weight[i]);
    }
    result.remove(0);
    return result;
  }

  public static ArrayList<ArrayList<Integer>> calculatePrimsMST(
    int n,
    int m,
    ArrayList<ArrayList<Integer>> g
  ) {
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      graph
        .get(g.get(i).get(0) - 1)
        .add(new Node(g.get(i).get(1) - 1, g.get(i).get(2)));
      graph
        .get(g.get(i).get(1) - 1)
        .add(new Node(g.get(i).get(0) - 1, g.get(i).get(2)));
    }

    return primMST(graph, n);
  }
}

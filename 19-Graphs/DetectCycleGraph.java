import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleGraph {

  public static boolean detectCycleInDirectedGraph(
    int n,
    ArrayList<ArrayList<Integer>> edges
  ) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (ArrayList<Integer> edge : edges) {
      int u = edge.get(0) - 1;
      int v = edge.get(1) - 1;
      graph.get(u).add(v);
    }

    // boolean[] visited = new boolean[n];
    // boolean[] pathVisited = new boolean[n];
    // for (int i = 0; i < n; i++) {
    //   if (isCycleDfs(graph, i, visited, pathVisited)) {
    //     return true;
    //   }
    // }
    // return false;

    return isCycleBfs(graph);
  }

  public static boolean isCycleBfs(ArrayList<ArrayList<Integer>> graph) {
    int n = graph.size();
    int[] indegree = new int[n];
    for (ArrayList<Integer> node : graph) {
      for (int neighbor : node) {
        indegree[neighbor]++;
      }
    }

    int visitedCount = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int node = queue.poll();
      visitedCount++;
      for (int neighbor : graph.get(node)) {
        if (--indegree[neighbor] == 0) {
          queue.add(neighbor);
        }
      }
    }

    return visitedCount != n;
  }

  public static boolean isCycleDfs(
    ArrayList<ArrayList<Integer>> graph,
    int source,
    boolean[] visited,
    boolean[] pathVisited
  ) {
    if (visited[source] && pathVisited[source]) {
      return true;
    }

    visited[source] = true;
    pathVisited[source] = true;

    boolean result = false;
    for (int i = 0; i < graph.get(source).size(); i++) {
      result =
        isCycleDfs(graph, graph.get(source).get(i), visited, pathVisited);

      if (result) {
        break;
      }
    }

    pathVisited[source] = false;
    return result;
  }
}

import java.util.ArrayList;

public class IsGraphTree {

  public static boolean dfs(
    int curNode,
    int parent,
    ArrayList<ArrayList<Integer>> graph,
    boolean[] visited
  ) {
    visited[curNode] = true;

    for (int i = 0; i < graph.get(curNode).size(); i++) {
      int neighbour = graph.get(curNode).get(i);

      if (visited[neighbour] == false) {
        if (dfs(neighbour, curNode, graph, visited) == true) {
          return true;
        }
      } else {
        if (parent != neighbour) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isGraphTree(
    int n,
    ArrayList<ArrayList<Integer>> edgeList
  ) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(n);

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<Integer>());
    }

    boolean[] visited = new boolean[n];

    boolean answer = true;

    for (int i = 0; i < edgeList.size(); i++) {
      int u = edgeList.get(i).get(0), v = edgeList.get(i).get(1);
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    if (dfs(0, -1, graph, visited) == true) {
      answer = false;
    }

    for (int node = 0; node < n; node++) {
      if (visited[node] == false) {
        answer = false;
        break;
      }
    }

    return answer;
  }
}

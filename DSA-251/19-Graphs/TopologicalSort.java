import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

  public static ArrayList<Integer> topologicalSort(
    ArrayList<ArrayList<Integer>> edges,
    int v,
    int e
  ) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] inDegree = new int[v];

    for (int i = 0; i < v; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      int source = edges.get(i).get(0);
      int destination = edges.get(i).get(1);
      graph.get(source).add(destination);
      inDegree[destination]++;
    }

    ArrayList<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < v; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int value = queue.poll();

      result.add(value);
      for (int i = 0; i < graph.get(value).size(); i++) {
        int neighbour = graph.get(value).get(i);
        inDegree[neighbour]--;
        if (inDegree[neighbour] == 0) {
          queue.add(neighbour);
        }
      }
    }

    return result;
  }
}

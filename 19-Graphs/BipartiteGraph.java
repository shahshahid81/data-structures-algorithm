import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

  public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> graph) {
    int[] colors = new int[graph.size()];
    Arrays.fill(colors, -1);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    colors[0] = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      int color = colors[node] == 0 ? 1 : 0;

      for (int j = 0; j < graph.get(node).size(); j++) {
        if (graph.get(node).get(j) == 0) {
          continue;
        }
        queue.add(j);
        if (colors[node] == colors[j]) {
          return false;
        }
        colors[j] = color;
      }
    }

    return true;
  }
}

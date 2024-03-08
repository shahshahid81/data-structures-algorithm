import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {

  static class Graph {

    private List<List<Integer>> neighbors;
    private int numVertices;

    public Graph(int vertexCount) {
      numVertices = vertexCount;
      neighbors = new ArrayList<>(vertexCount);
      for (int i = 0; i < vertexCount; i++) {
        neighbors.add(new ArrayList<>());
      }
    }

    public void addEdge(int src, int dest) {
      neighbors.get(src).add(dest);
    }

    public String topologicalSort() {
      boolean[] visited = new boolean[numVertices];
      Stack<Integer> completedVertices = new Stack<>();

      for (int i = 0; i < numVertices; i++) {
        if (!visited[i]) {
          dfs(i, visited, completedVertices);
        }
      }

      StringBuilder arr = new StringBuilder();

      while (!completedVertices.isEmpty()) {
        arr.append((char) ('a' + completedVertices.pop()));
      }

      return arr.toString();
    }

    private void dfs(
      int curr,
      boolean[] visited,
      Stack<Integer> completedVertices
    ) {
      visited[curr] = true;

      for (int neighbor : neighbors.get(curr)) {
        if (!visited[neighbor]) {
          dfs(neighbor, visited, completedVertices);
        }
      }

      completedVertices.push(curr);
    }
  }

  public static String getAlienLanguage(String[] dictionary, int k) {
    int n = dictionary.length;
    Set<Character> uniqueChars = new HashSet<>();

    for (String word : dictionary) {
      for (char c : word.toCharArray()) {
        uniqueChars.add(c);
      }
    }

    Graph graph = new Graph(uniqueChars.size());

    for (int i = 0; i < n - 1; i++) {
      String currWord = dictionary[i];
      String nextWord = dictionary[i + 1];

      int compareTill = Math.min(currWord.length(), nextWord.length());

      for (int j = 0; j < compareTill; j++) {
        if (nextWord.charAt(j) != currWord.charAt(j)) {
          graph.addEdge(currWord.charAt(j) - 'a', nextWord.charAt(j) - 'a');
          break;
        }
      }
    }

    return graph.topologicalSort();
  }
}

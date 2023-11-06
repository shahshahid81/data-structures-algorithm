import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Pair {

  int parent;
  int rank;

  public Pair(int parent, int rank) {
    this.parent = parent;
    this.rank = rank;
  }
}

class DisjointSet {

  HashMap<Integer, Pair> nodeMap;

  DisjointSet(int[] data) {
    nodeMap = new HashMap<>();
    for (int element : data) {
      Pair pair = new Pair(element, 0);
      nodeMap.put(element, pair);
    }
  }

  public void union(int first, int second) {
    int firstParent = this.find(first);
    if (firstParent == Integer.MAX_VALUE) {
      return;
    }

    int secondParent = this.find(second);
    if (secondParent == Integer.MAX_VALUE) {
      return;
    }

    if (firstParent == secondParent) {
      return;
    }

    Pair firstParentNode = nodeMap.get(firstParent);
    Pair secondParentNode = nodeMap.get(secondParent);

    if (firstParentNode.rank == secondParentNode.rank) {
      firstParentNode.parent = secondParentNode.parent;
      firstParentNode.rank += 1;
    } else if (firstParentNode.rank > secondParentNode.rank) {
      secondParentNode.parent = firstParentNode.parent;
    } else {
      firstParentNode.parent = secondParentNode.parent;
    }
  }

  public int find(int element) {
    if (!nodeMap.containsKey(element)) {
      return Integer.MAX_VALUE;
    }

    if (nodeMap.get(element).parent == element) {
      return element;
    }

    int foundParent = find(nodeMap.get(element).parent);
    nodeMap.get(element).parent = foundParent;

    return foundParent;
  }
}

public class KruskalMST {

  public static int kruskalMST(int n, int[][] edges) {
    ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();

    for (int i = 0; i < edges.length; i++) {
      int source = edges[i][0];
      int destination = edges[i][1];
      int weight = edges[i][2];
      ArrayList<Integer> row = new ArrayList<>();
      row.add(weight);
      row.add(source);
      row.add(destination);
      edgeList.add(row);
    }

    Collections.sort(edgeList, (a, b) -> a.get(0) - b.get(0));

    int[] nodes = new int[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = i;
    }
    DisjointSet ds = new DisjointSet(nodes);
    int minimumSpanningTreeWeight = 0;

    for (int i = 0; i < edges.length; i++) {
      int weight = edgeList.get(i).get(0);
      int source = edgeList.get(i).get(1);
      int destination = edgeList.get(i).get(2);

      if (ds.find(source) != ds.find(destination)) {
        ds.union(source, destination);
        minimumSpanningTreeWeight += weight;
      }
    }

    return minimumSpanningTreeWeight;
  }
}

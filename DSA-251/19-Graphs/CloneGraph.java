public class CloneGraph {

  public Node cloneGraph(Node node) {
    HashMap<Node, Node> visited = new HashMap<>();
    return cloneGraph(node, null, visited);
  }

  private Node cloneGraph(Node node, Node parent, HashMap<Node, Node> visited) {
    if (node == null) {
      return node;
    }

    if (visited.containsKey(node)) {
      return visited.get(node);
    }

    Node newNode = new Node(node.val);
    visited.put(node, newNode);
    if (parent != null && newNode.neighbors.indexOf(parent) == -1) {
      newNode.neighbors.add(parent);
    }

    for (Node neighbor : node.neighbors) {
      Node newNeighbor = cloneGraph(neighbor, newNode, visited);
      if (newNeighbor != null && newNode.neighbors.indexOf(newNeighbor) == -1) {
        newNode.neighbors.add(newNeighbor);
      }
    }
    return newNode;
  }
}

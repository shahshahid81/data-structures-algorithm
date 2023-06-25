import java.util.*;

class BinaryTreeNode {

  int val;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class TopViewOfBinaryTree {

  public ArrayList<Integer> getTopView(BinaryTreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    Queue<Map.Entry<BinaryTreeNode, Integer>> queue = new LinkedList<>();
    queue.add(new AbstractMap.SimpleEntry<>(root, 0));

    while (!queue.isEmpty()) {
      Map.Entry<BinaryTreeNode, Integer> entry = queue.remove();
      BinaryTreeNode node = entry.getKey();
      int distance = entry.getValue();

      if (!treeMap.containsKey(distance)) {
        treeMap.put(distance, node.val);
      }

      if (node.left != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.left, distance - 1));
      }

      if (node.right != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.right, distance + 1));
      }
    }

    return new ArrayList<>(treeMap.values());
  }
}

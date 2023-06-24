import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class RightViewOfBinaryTree {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightView = new ArrayList<>();
    if (root == null) {
      return rightView;
    }

    LinkedList<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
    queue.add(new AbstractMap.SimpleEntry<>(root, 1));

    while (!queue.isEmpty()) {
      Map.Entry<TreeNode, Integer> entry = queue.remove();
      TreeNode node = entry.getKey();
      int currentLevel = entry.getValue();

      if (node.left != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.left, currentLevel + 1));
      }

      if (node.right != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.right, currentLevel + 1));
      }

      if (queue.isEmpty() || queue.peek().getValue() > currentLevel) {
        rightView.add(node.val);
      }
    }

    return rightView;
  }
}

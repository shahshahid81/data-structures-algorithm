import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

class TreeNode<T> {

  T data;
  TreeNode<T> left;
  TreeNode<T> right;

  TreeNode(T data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class LeftViewOfBinaryTree {

  public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
    ArrayList<Integer> leftView = new ArrayList<>();
    if (root == null) {
      return leftView;
    }

    LinkedList<Map.Entry<TreeNode<Integer>, Integer>> queue = new LinkedList<>();
    queue.add(new AbstractMap.SimpleEntry<>(root, 1));
    int previousLevel = 0;
    while (!queue.isEmpty()) {
      Map.Entry<TreeNode<Integer>, Integer> entry = queue.remove();
      TreeNode<Integer> node = entry.getKey();
      int currentLevel = entry.getValue();

      if (node.left != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.left, currentLevel + 1));
      }

      if (node.right != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.right, currentLevel + 1));
      }

      if (currentLevel > previousLevel) {
        leftView.add(node.data);
      }
      previousLevel = currentLevel;
    }
    return leftView;
  }
}

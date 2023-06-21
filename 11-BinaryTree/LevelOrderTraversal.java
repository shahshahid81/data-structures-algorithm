import java.util.ArrayList;
import java.util.LinkedList;

class BinaryTreeNode {

  int val;
  BinaryTreeNode left;
  BinaryTreeNode right;

  public BinaryTreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

public class LevelOrderTraversal {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) return result;
    LinkedList<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode node = queue.remove();
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
      result.add(node.val);
    }
    return result;
  }
}

import java.util.ArrayList;
import java.util.List;

class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.data = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.data = val;
    this.left = left;
    this.right = right;
  }
}

public class InOrderTraversal {

  public List<Integer> getInOrderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    getInOrderTraversal(root, result);
    return result;
  }

  private void getInOrderTraversal(TreeNode root, List<Integer> result) {
    if (root == null) return;
    if (root.left != null) getInOrderTraversal(root.left, result);
    result.add(root.data);
    if (root.right != null) getInOrderTraversal(root.right, result);
  }
}

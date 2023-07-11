import java.util.Stack;

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

public class BSTIterator {

  Stack<TreeNode> stack = new Stack<>();

  public BSTIterator(TreeNode root) {
    processLeft(root);
  }

  private void processLeft(TreeNode root) {
    while (root != null) {
      stack.add(root);
      root = root.left;
    }
  }

  public int next() {
    TreeNode node = stack.pop();
    processLeft(node.right);
    return node.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

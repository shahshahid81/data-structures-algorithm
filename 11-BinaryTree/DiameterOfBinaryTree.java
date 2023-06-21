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

public class DiameterOfBinaryTree {

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 0;
    int[] diameter = new int[1];
    height(root, diameter);
    return diameter[0];
  }

  private int height(TreeNode root, int[] diameter) {
    if (root == null) return 0;
    int leftHeight = height(root.left, diameter);
    int rightHeight = height(root.right, diameter);
    diameter[0] = Math.max(leftHeight + rightHeight, diameter[0]);
    return 1 + Math.max(leftHeight, rightHeight);
  }
}

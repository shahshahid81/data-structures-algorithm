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

public class KthSmallest {

  public int kthSmallest(TreeNode root, int k) {
    int[] result = { 0, 0 };
    inOrder(root, k, result);
    return result[1];
  }

  private void inOrder(TreeNode root, int k, int[] result) {
    if (root == null || result[0] > k) return;
    inOrder(root.left, k, result);
    if (++result[0] == k) {
      result[1] = root.val;
      return;
    }
    inOrder(root.right, k, result);
  }
}

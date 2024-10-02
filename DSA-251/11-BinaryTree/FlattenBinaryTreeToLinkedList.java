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

public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }

    if (root.left == null) {
      flatten(root.right);
    } else if (root.right == null) {
      root.right = root.left;
      root.left = null;
      flatten(root.right);
    } else {
      TreeNode predecessor = getPredecessor(root.left);
      predecessor.right = root.right;
      root.right = root.left;
      root.left = null;
      flatten(root.right);
    }
  }

  private TreeNode getPredecessor(TreeNode root) {
    while (root.left != null || root.right != null) {
      if (root.right != null) {
        root = root.right;
      } else if (root.left != null) {
        root = root.left;
      }
    }
    return root;
  }
}

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

public class DeleteNode {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return root;

    if (root.val != key) {
      if (root.left != null) {
        root.left = deleteNode(root.left, key);
      }

      if (root.right != null) {
        root.right = deleteNode(root.right, key);
      }
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left != null && root.right != null) {
        int smallest = smallest(root.right);
        root.val = smallest;
        root.right = deleteNode(root.right, smallest);
      } else if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
    }
    return root;
  }

  private static int smallest(TreeNode root) {
    while (root.left != null) root = root.left;

    return root.val;
  }
}

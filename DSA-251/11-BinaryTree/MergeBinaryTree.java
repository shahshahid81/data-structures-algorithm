class BinaryTreeNode {

  int data;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class MergeBinaryTree {

  public static BinaryTreeNode mergeTrees(
    BinaryTreeNode root1,
    BinaryTreeNode root2
  ) {
    BinaryTreeNode result = null;
    if (root1 != null || root2 != null) {
      int sum = 0;
      if (root1 != null) sum += root1.data;
      if (root2 != null) sum += root2.data;

      result = new BinaryTreeNode(sum);
      result.left =
        mergeTrees(
          root1 == null ? null : root1.left,
          root2 == null ? null : root2.left
        );
      result.right =
        mergeTrees(
          root1 == null ? null : root1.right,
          root2 == null ? null : root2.right
        );
    }
    return result;
  }
}

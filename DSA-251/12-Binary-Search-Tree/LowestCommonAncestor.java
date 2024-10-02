class TreeNode {

  Integer data;
  TreeNode left;
  TreeNode right;

  TreeNode(Integer data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class LowestCommonAncestor {

  public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p.data == root.data || q.data == root.data) {
      return root;
    }

    if (p.data < root.data && q.data < root.data) {
      return LCAinaBST(root.left, p, q);
    }

    if (p.data > root.data && q.data > root.data) {
      return LCAinaBST(root.right, p, q);
    }

    return root;
  }
}

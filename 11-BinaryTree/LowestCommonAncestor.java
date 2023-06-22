class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    boolean[] isMatching = { false, false };
    return lowestCommonAncestor(root, p, q, isMatching);
  }

  private TreeNode lowestCommonAncestor(
    TreeNode root,
    TreeNode p,
    TreeNode q,
    boolean[] isMatching
  ) {
    boolean[] isLeftMatching = { false, false };
    if (root.left != null) {
      TreeNode result = lowestCommonAncestor(root.left, p, q, isLeftMatching);
      if (isLeftMatching[0] && isLeftMatching[1]) {
        isMatching[0] = true;
        isMatching[1] = true;
        return result;
      }
    }

    boolean[] isRightMatching = { false, false };
    if (root.right != null) {
      TreeNode result = lowestCommonAncestor(root.right, p, q, isRightMatching);
      if (isRightMatching[0] && isRightMatching[1]) {
        isMatching[0] = true;
        isMatching[1] = true;
        return result;
      }
    }

    isMatching[0] = isLeftMatching[0] || isRightMatching[0] || root == p;
    isMatching[1] = isLeftMatching[1] || isRightMatching[1] || root == q;

    return isMatching[0] && isMatching[1] ? root : null;
  }
}

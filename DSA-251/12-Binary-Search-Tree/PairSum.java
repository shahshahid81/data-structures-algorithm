import java.util.HashSet;

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

public class PairSum {

  public boolean findTarget(TreeNode root, int k) {
    HashSet<Integer> hashSet = new HashSet<>();
    return findTarget(hashSet, root, k);
  }

  private static boolean findTarget(
    HashSet<Integer> hashSet,
    TreeNode root,
    int k
  ) {
    if (root == null) return false;
    if (hashSet.contains(k - root.val)) return true;
    hashSet.add(root.val);
    return (
      findTarget(hashSet, root.left, k) || findTarget(hashSet, root.right, k)
    );
  }
}

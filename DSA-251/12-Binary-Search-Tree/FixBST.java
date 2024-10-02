class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;
}

class Result {

  public TreeNode firstNode, secondNode, prev;
}

public class FixBST {

  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }

    Result result = new Result();
    recoverTreeHelper(root, result);
    int temp = result.firstNode.val;
    result.firstNode.val = result.secondNode.val;
    result.secondNode.val = temp;
  }

  private void recoverTreeHelper(TreeNode root, Result result) {
    if (root == null) {
      if (result.firstNode != null && result.secondNode == null) {
        result.secondNode = result.prev;
      }
      return;
    }

    recoverTreeHelper(root.left, result);

    if (result.prev != null && result.prev.val > root.val) {
      if (result.firstNode == null) {
        result.firstNode = result.prev;
      } else {
        result.secondNode = root;
      }
    }
    result.prev = root;
    recoverTreeHelper(root.right, result);
  }
}

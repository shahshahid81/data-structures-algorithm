import java.util.ArrayList;

public class ValidBST {

  public boolean isValidBST(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    inOrder(root, list);
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i + 1) <= list.get(i)) return false;
    }
    return true;
  }

  private void inOrder(TreeNode root, ArrayList<Integer> list) {
    if (root != null) {
      inOrder(root.left, list);
      list.add(root.val);
      inOrder(root.right, list);
    }
  }
}

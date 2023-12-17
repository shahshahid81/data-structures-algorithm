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

public class BstToMinHeap {

  public static BinaryTreeNode convertBST(BinaryTreeNode root) {
    List<Integer> list = new ArrayList<>();
    getInorderTraversal(root, list);
    generateMinHeap(root, list);
    index = 0;
    return root;
  }

  private static void getInorderTraversal(
    BinaryTreeNode root,
    List<Integer> list
  ) {
    if (root == null) {
      return;
    }

    getInorderTraversal(root.left, list);
    list.add(root.data);
    getInorderTraversal(root.right, list);
  }

  private static void generateMinHeap(BinaryTreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    root.data = list.get(index++);
    generateMinHeap(root.left, list);
    generateMinHeap(root.right, list);
  }
}

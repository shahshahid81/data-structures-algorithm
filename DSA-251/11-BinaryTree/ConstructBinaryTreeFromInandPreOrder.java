import java.util.HashMap;

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

public class ConstructBinaryTreeFromInandPreOrder {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int inorderSize = inorder.length;
    int preOrderSize = preorder.length;
    if (inorderSize == 0 || preOrderSize == 0 || inorderSize != preOrderSize) {
      return null;
    }

    HashMap<Integer, Integer> inOrderHashMap = new HashMap<>();
    for (int i = 0; i < inorderSize; i++) {
      inOrderHashMap.put(inorder[i], i);
    }

    return buildTree(
      inorder,
      preorder,
      inOrderHashMap,
      0,
      inorderSize - 1,
      0,
      preOrderSize - 1
    );
  }

  private TreeNode buildTree(
    int[] inorder,
    int[] preorder,
    HashMap<Integer, Integer> inOrderHashMap,
    int inorderStart,
    int inorderEnd,
    int preorderStart,
    int preorderEnd
  ) {
    if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
      return null;
    }

    int rootData = preorder[preorderStart++];
    TreeNode root = new TreeNode(rootData);
    int inOrderIndex = inOrderHashMap.get(rootData);
    int numsLeft = inOrderIndex - inorderStart;

    root.left =
      buildTree(
        inorder,
        preorder,
        inOrderHashMap,
        inorderStart,
        inOrderIndex - 1,
        preorderStart,
        preorderStart + numsLeft - 1
      );

    root.right =
      buildTree(
        inorder,
        preorder,
        inOrderHashMap,
        inOrderIndex + 1,
        inorderEnd,
        preorderStart + numsLeft,
        preorderEnd
      );

    return root;
  }
}

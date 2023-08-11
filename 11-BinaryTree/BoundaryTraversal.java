import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int data) {
    this.data = data;
  }

  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

public class BoundaryTraversal {

  public static List<Integer> traverseBoundary(TreeNode root) {
    ArrayList<Integer> leftBoundary = new ArrayList<>();

    if (root == null) {
      return leftBoundary;
    }

    HashSet<TreeNode> leftBoundaryNodes = new HashSet<>();
    leftBoundary.add(root.data);
    leftBoundaryNodes.add(root);
    traverseLeftBoundary(root.left, leftBoundary, leftBoundaryNodes);

    ArrayList<Integer> rightBoundary = new ArrayList<>();
    HashSet<TreeNode> rightBoundaryNodes = new HashSet<>();
    traverseRightBoundary(root.right, rightBoundary, rightBoundaryNodes);

    ArrayList<Integer> leaf = new ArrayList<>();
    traverseLeaf(root, leaf, leftBoundaryNodes, rightBoundaryNodes);

    leftBoundary.addAll(leaf);
    Collections.reverse(rightBoundary);
    leftBoundary.addAll(rightBoundary);
    return leftBoundary;
  }

  private static void traverseLeftBoundary(
    TreeNode root,
    ArrayList<Integer> leftBoundary,
    HashSet<TreeNode> leftBoundaryNodes
  ) {
    if (root == null) {
      return;
    }

    leftBoundaryNodes.add(root);
    leftBoundary.add(root.data);
    traverseLeftBoundary(
      root.left != null ? root.left : root.right,
      leftBoundary,
      leftBoundaryNodes
    );
  }

  private static void traverseRightBoundary(
    TreeNode root,
    ArrayList<Integer> rightBoundary,
    HashSet<TreeNode> rightBoundaryNodes
  ) {
    if (root == null) {
      return;
    }

    rightBoundaryNodes.add(root);
    rightBoundary.add(root.data);
    traverseRightBoundary(
      root.right != null ? root.right : root.left,
      rightBoundary,
      rightBoundaryNodes
    );
  }

  private static void traverseLeaf(
    TreeNode root,
    ArrayList<Integer> leaf,
    HashSet<TreeNode> leftBoundaryNodes,
    HashSet<TreeNode> rightBoundaryNodes
  ) {
    if (root == null) {
      return;
    }

    if (
      root.left == null &&
      root.right == null &&
      !leftBoundaryNodes.contains(root) &&
      !rightBoundaryNodes.contains(root)
    ) {
      leaf.add(root.data);
    } else {
      traverseLeaf(root.left, leaf, leftBoundaryNodes, rightBoundaryNodes);
      traverseLeaf(root.right, leaf, leftBoundaryNodes, rightBoundaryNodes);
    }
  }
}

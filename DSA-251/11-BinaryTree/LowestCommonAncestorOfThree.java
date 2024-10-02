class BinaryTreeNode<T> {

  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}

public class LowestCommonAncestorOfThree {

  public static BinaryTreeNode<Integer> lcaOfThreeNodes(
    BinaryTreeNode<Integer> root,
    int node1,
    int node2,
    int node3
  ) {
    BinaryTreeNode<Integer> firstTwoLca = lowestCommonAncestor(
      root,
      node1,
      node2
    );
    BinaryTreeNode<Integer> lastTwoLca = lowestCommonAncestor(
      root,
      node2,
      node3
    );
    if (firstTwoLca == lastTwoLca) {
      return firstTwoLca;
    }
    return lowestCommonAncestor(root, firstTwoLca.data, lastTwoLca.data);
  }

  private static BinaryTreeNode<Integer> lowestCommonAncestor(
    BinaryTreeNode<Integer> root,
    int node1,
    int node2
  ) {
    if (root == null || root.data == node1 || root.data == node2) {
      return root;
    }

    BinaryTreeNode<Integer> leftChild = lowestCommonAncestor(
      root.left,
      node1,
      node2
    );
    BinaryTreeNode<Integer> rightChild = lowestCommonAncestor(
      root.right,
      node1,
      node2
    );

    if (leftChild == null && rightChild == null) {
      return null;
    } else if (leftChild != null && rightChild != null) {
      return root;
    } else if (leftChild != null) {
      return leftChild;
    } else {
      return rightChild;
    }
  }
}

import java.util.*;

class BinaryTreeNode<T> {

  public T data;
  public BinaryTreeNode<T> left;
  public BinaryTreeNode<T> right;

  BinaryTreeNode(T data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class PredecessorSuccessor {

  public static ArrayList<Integer> predecessorSuccessor(
    BinaryTreeNode<Integer> root,
    int key
  ) {
    ArrayList<Integer> result = new ArrayList<>();
    result.add(-1);
    result.add(-1);
    predecessorSuccessor(root, key, result);
    return result;
  }

  private static void predecessorSuccessor(
    BinaryTreeNode<Integer> root,
    int key,
    ArrayList<Integer> result
  ) {
    if (root == null) return;
    if (root.data == key) {
      BinaryTreeNode<Integer> predecessor = largest(root.left);
      if (predecessor != null) {
        result.set(0, predecessor.data);
      } else if (root.data < result.get(0)) {
        result.set(0, -1);
      }

      BinaryTreeNode<Integer> successor = smallest(root.right);
      if (successor != null) {
        result.set(1, successor.data);
      } else if (root.data > result.get(1)) {
        result.set(1, -1);
      }
    } else if (root.data > key) {
      result.set(1, root.data);
      predecessorSuccessor(root.left, key, result);
    } else {
      result.set(0, root.data);
      predecessorSuccessor(root.right, key, result);
    }
  }

  private static BinaryTreeNode<Integer> smallest(
    BinaryTreeNode<Integer> root
  ) {
    while (root != null && root.left != null) root = root.left;
    return root;
  }

  private static BinaryTreeNode<Integer> largest(BinaryTreeNode<Integer> root) {
    while (root != null && root.right != null) root = root.right;
    return root;
  }
}

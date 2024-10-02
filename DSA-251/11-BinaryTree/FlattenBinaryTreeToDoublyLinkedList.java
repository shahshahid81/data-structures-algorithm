class BinaryTreeNode<T> {

  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}

public class FlattenBinaryTreeToDoublyLinkedList {

  public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
    BinaryTreeNode<Integer> current = root;
    BinaryTreeNode<Integer> prev = null;
    BinaryTreeNode<Integer> head = null;
    while (current != null) {
      if (current.left == null) {
        if (head == null) {
          head = current;
        }

        current.left = prev;
        if (prev != null) {
          prev.right = current;
        }

        prev = current;
        current = current.right;
      } else {
        BinaryTreeNode<Integer> next = current.left;

        while (next.right != null && next.right != current) {
          next = next.right;
        }

        if (next.right == null) {
          next.right = current;
          current = current.left;
        } else if (next.right == current) {
          current.left = next;
          prev = current;
          current = current.right;
        }
      }
    }
    return head;
  }
}

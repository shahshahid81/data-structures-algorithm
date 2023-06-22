import java.util.*;

class BinaryTreeNode<T> {

  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
    this.data = data;
  }
}

public class ZigZagTraversal {

  public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<Integer> stack = new Stack<>();
    LinkedList<Map.Entry<BinaryTreeNode<Integer>, Integer>> queue = new LinkedList<>();
    queue.add(
      new AbstractMap.SimpleEntry<BinaryTreeNode<Integer>, Integer>(root, 1)
    );

    while (!queue.isEmpty()) {
      Map.Entry<BinaryTreeNode<Integer>, Integer> pair = queue.remove();
      BinaryTreeNode<Integer> node = pair.getKey();
      int level = pair.getValue();

      if (node.left != null) queue.add(
        new AbstractMap.SimpleEntry<BinaryTreeNode<Integer>, Integer>(
          node.left,
          level + 1
        )
      );
      if (node.right != null) queue.add(
        new AbstractMap.SimpleEntry<BinaryTreeNode<Integer>, Integer>(
          node.right,
          level + 1
        )
      );

      if (level % 2 != 0) {
        while (!stack.isEmpty()) {
          result.add(stack.pop());
        }
        result.add(node.data);
      } else {
        stack.push(node.data);
      }
    }

    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }
}

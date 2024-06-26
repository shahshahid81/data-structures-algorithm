class TreeNode<T> {

  T data;
  TreeNode<T> left;
  TreeNode<T> right;

  TreeNode(T data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class LargestBST {

  static class NodeValue {

    public int size;
    public int minValue;
    public int maxValue;

    public NodeValue(int size, int minValue, int maxValue) {
      this.size = size;
      this.minValue = minValue;
      this.maxValue = maxValue;
    }
  }

  public static int largestBST(TreeNode<Integer> root) {
    return compute(root).size;
  }

  public static NodeValue compute(TreeNode<Integer> node) {
    if (node == null) {
      return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    NodeValue left = compute(node.left);
    NodeValue right = compute(node.right);

    if (node.data >= left.maxValue && node.data <= right.minValue) {
      return new NodeValue(
        left.size + right.size + 1,
        Math.min(left.minValue, node.data),
        Math.max(node.data, right.maxValue)
      );
    }

    return new NodeValue(
      Math.max(left.size, right.size),
      Integer.MIN_VALUE,
      Integer.MAX_VALUE
    );
  }
}

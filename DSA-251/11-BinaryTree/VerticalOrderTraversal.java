import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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

public class VerticalOrderTraversal {

  public static ArrayList<Integer> verticalOrderTraversal(
    TreeNode<Integer> root
  ) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) return result;
    TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

    Queue<Map.Entry<TreeNode<Integer>, Integer>> queue = new LinkedList<>();
    queue.add(new AbstractMap.SimpleEntry<>(root, 0));

    while (!queue.isEmpty()) {
      Map.Entry<TreeNode<Integer>, Integer> entry = queue.remove();
      TreeNode<Integer> node = entry.getKey();
      int level = entry.getValue();

      if (!treeMap.containsKey(level)) {
        treeMap.put(level, new ArrayList<>());
      }
      treeMap.get(level).add(node.data);

      if (node.left != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.left, level - 1));
      }

      if (node.right != null) {
        queue.add(new AbstractMap.SimpleEntry<>(node.right, level + 1));
      }
    }

    for (ArrayList<Integer> list : treeMap.values()) {
      result.addAll(list);
    }
    return result;
  }
}

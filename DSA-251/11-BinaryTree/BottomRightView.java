import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BottomRightView {

  public static ArrayList<Integer> bottomRightView(
    BinaryTreeNode<Integer> root
  ) {
    ArrayList<Integer> arr = new ArrayList<>();
    if (root == null) {
      return arr;
    }

    Map<Integer, Integer> map = new HashMap<>();
    solve(root, map, 0);

    for (Integer key : map.keySet()) {
      arr.add(map.get(key));
    }
    Collections.sort(arr);
    return arr;
  }

  static void solve(
    BinaryTreeNode<Integer> root,
    Map<Integer, Integer> map,
    int level
  ) {
    if (root == null) {
      return;
    }

    map.put(level, root.data);

    solve(root.left, map, level + 1);

    solve(root.right, map, level);
  }
}

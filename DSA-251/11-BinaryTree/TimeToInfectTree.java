import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

public class TimeToInfectTree {

  public int amountOfTime(TreeNode root, int start) {
    HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
    storeParent(root, null, hashMap);

    HashSet<TreeNode> hashSet = new HashSet<>();
    TreeNode node = searchNode(root, start);

    int time = -1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- != 0) {
        node = queue.poll();
        hashSet.add(node);

        TreeNode parent = hashMap.get(node);
        if (parent != null && !hashSet.contains(parent)) {
          queue.offer(parent);
        }

        if (node.left != null && !hashSet.contains(node.left)) {
          queue.offer(node.left);
        }

        if (node.right != null && !hashSet.contains(node.right)) {
          queue.offer(node.right);
        }
      }

      time++;
    }
    return time;
  }

  private TreeNode searchNode(TreeNode root, int data) {
    if (root == null || root.val == data) {
      return root;
    }

    TreeNode left = searchNode(root.left, data);
    if (left != null) {
      return left;
    }

    return searchNode(root.right, data);
  }

  private void storeParent(
    TreeNode root,
    TreeNode parent,
    HashMap<TreeNode, TreeNode> hashMap
  ) {
    if (root == null) {
      return;
    }

    hashMap.put(root, parent);
    storeParent(root.left, root, hashMap);
    storeParent(root.right, root, hashMap);
  }
}

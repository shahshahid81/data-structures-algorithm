class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

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

public class SortedListToBalancedBST {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head, fast = head, prev = null;

    while (fast.next != null && fast.next.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    TreeNode bstHead = new TreeNode(slow.val);
    if (prev != null) {
      prev.next = null;
      bstHead.left = sortedListToBST(head);
    }

    bstHead.right = sortedListToBST(slow.next);

    return bstHead;
  }
}

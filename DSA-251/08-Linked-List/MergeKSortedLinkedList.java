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

public class MergeKSortedLinkedList {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    return mergeKLists(lists, 0, lists.length - 1);
  }

  private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }

    int mid = start + (end - start) / 2;
    ListNode left = mergeKLists(lists, start, mid);
    ListNode right = mergeKLists(lists, mid + 1, end);
    return mergeList(left, right);
  }

  private static ListNode mergeList(ListNode left, ListNode right) {
    ListNode newHead = new ListNode(0);
    ListNode current = newHead;

    while (left != null && right != null) {
      if (left.val <= right.val) {
        current.next = left;
        left = left.next;
      } else {
        current.next = right;
        right = right.next;
      }

      if (newHead.next == null) {
        newHead.next = current;
      }

      current = current.next;
    }

    while (left != null) {
      current.next = left;
      left = left.next;
      if (newHead.next == null) {
        newHead.next = current;
      }

      current = current.next;
    }

    while (right != null) {
      current.next = right;
      right = right.next;
      if (newHead.next == null) {
        newHead.next = current;
      }

      current = current.next;
    }

    return newHead.next;
  }
}

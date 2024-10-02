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

public class ReorderList {

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }

    ListNode slow = head, fast = head, prev = null;
    while (fast.next != null && fast.next.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (slow == fast) {
      return;
    }

    if (fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next;
    }

    reverseLinkedList(slow);
    if (prev != null) {
      prev.next = null;
    }

    ListNode current = head, temp = null;
    while (current != null) {
      temp = fast;
      fast = fast.next;
      temp.next = current.next;
      current.next = temp;
      current = temp.next;
    }

    if (fast != null) {
      temp.next = fast;
    }
  }

  private static void reverseLinkedList(ListNode head) {
    ListNode current = head, prev = null;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
  }
}

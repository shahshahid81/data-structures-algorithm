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

public class SwapNodePair {

  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy, current = head;
    while (current != null && current.next != null) {
      ListNode next = current.next;
      ListNode temp = next.next;
      next.next = current;
      current.next = temp;
      prev.next = next;
      prev = current;
      current = temp;
    }
    return dummy.next;
  }
}

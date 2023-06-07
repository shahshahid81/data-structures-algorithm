public class InsertionSortLinkedList {

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

  private void compareNode(ListNode head, ListNode nodeToCompare) {
    if (head.next != nodeToCompare) {
      compareNode(head.next, nodeToCompare);
    }
    if (head.next != null && head.val > head.next.val) {
      int temp = head.val;
      head.val = head.next.val;
      head.next.val = temp;
    }
  }

  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode current = head.next;
    while (current != null) {
      compareNode(head, current);
      current = current.next;
    }

    return head;
  }
}

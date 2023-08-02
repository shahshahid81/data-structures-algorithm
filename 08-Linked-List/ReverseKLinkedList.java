public class ReverseKLinkedList {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    return reverseLinkedList(head, k);
  }

  private ListNode reverseLinkedList(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    ListNode current = head, prev = null, next = null;
    int block = k;

    while (current != null && block != 0) {
      current = current.next;
      block--;
    }

    if (block != 0) {
      return head;
    }

    current = head;
    block = k;
    while (current != null && block-- != 0) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head.next = reverseLinkedList(next, k);

    return prev;
  }
}

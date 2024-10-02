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

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || (l1.val == 0 && l1.next == null)) return l2;
    if (l2 == null || (l2.val == 0 && l2.next == null)) return l1;

    ListNode head = null, current = null;
    int carry = 0;

    while (l1 != null || l2 != null) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      carry = sum / 10;
      sum = sum % 10;

      ListNode result = new ListNode(sum);
      if (head == null) {
        head = result;
        current = result;
      } else {
        current.next = result;
        current = current.next;
      }
    }

    if (carry != 0) {
      ListNode result = new ListNode(carry);
      current.next = result;
    }

    return head;
  }
}

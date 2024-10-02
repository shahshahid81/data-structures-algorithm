import java.util.Stack;

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

public class LinkedListPalindrome {

  public boolean isPalindrome(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode current = head;
    while (current != null) {
      stack.add(current.val);
      current = current.next;
    }

    current = head;
    while (current != null) {
      if (stack.pop() != current.val) return false;
      current = current.next;
    }

    return true;
  }
}

class Node {

  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class DeleteLoop {

  public Node removeLoop(Node head) {
    Node slow = head, fast = head;
    Node temp = null, prev = null;

    while (slow != null && fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        temp = slow;
        break;
      }
    }

    if (temp != null) {
      if (temp == head) {
        prev.next = null;
      } else {
        Node current = head;
        while (current != temp) {
          prev = temp;
          current = current.next;
          temp = temp.next;
        }
        prev.next = null;
      }
    }

    return head;
  }
}

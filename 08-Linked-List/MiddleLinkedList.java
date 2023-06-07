class Node {

  public int data;
  public Node next;

  Node() {
    this.data = 0;
    this.next = null;
  }

  Node(int data) {
    this.data = data;
    this.next = null;
  }

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }
}

public class MiddleLinkedList {

  public Node findMiddle(Node head) {
    Node slow = head, fast = head;

    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast.next != null) {
      slow = slow.next;
    }

    return slow;
  }
}

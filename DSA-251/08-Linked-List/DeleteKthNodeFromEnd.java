class Node {

  public int data;
  public Node next;
  public Node prev;

  Node() {
    this.data = 0;
    this.next = null;
    this.prev = null;
  }

  Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
    this.prev = next;
  }
}

public class DeleteKthNodeFromEnd {

  public Node removeKthNode(Node head, int K) {
    if (head == null) {
      return head;
    }

    Node current = head, kthNode = head;

    while (current.next != null) {
      current = current.next;
      if (K == 0) {
        kthNode = kthNode.next;
      } else {
        K--;
      }
    }

    if (K != 0) {
      return head.next;
    } else {
      kthNode.next = kthNode.next.next;
    }

    return head;
  }
}

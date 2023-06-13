class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class AppendNodes {

  public static Node addNodes(Node head, int n, int m) {
    Node current = head;
    while (current != null) {
      for (int i = 0; i < m - 1 && current != null; i++) {
        current = current.next;
      }

      if (current == null || current.next == null) {
        break;
      }

      int sum = 0;
      for (int i = 0; i < n && current.next != null; i++) {
        current = current.next;
        sum += current.data;
      }

      Node sumNode = new Node(sum);
      sumNode.next = current.next;
      current.next = sumNode;
      current = sumNode.next;
    }
    return head;
  }
}

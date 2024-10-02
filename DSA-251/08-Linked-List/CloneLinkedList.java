import java.util.HashMap;

class Node {

  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class CloneLinkedList {

  public Node copyRandomList(Node head) {
    if (head == null) {
      return head;
    }

    HashMap<Node, Integer> originalHashMap = new HashMap<>();
    Node current = head, prev = null, newHead = null;
    int index = 0;

    while (current != null) {
      originalHashMap.put(current, index);
      index++;

      Node node = new Node(current.val);
      if (prev != null) {
        prev.next = node;
      }

      if (newHead == null) {
        newHead = node;
      }

      prev = node;
      current = current.next;
    }

    HashMap<Integer, Node> cloneHashMap = new HashMap<>();
    current = newHead;
    index = 0;

    while (current != null) {
      cloneHashMap.put(index, current);
      index++;
      current = current.next;
    }

    current = newHead;
    while (current != null) {
      current.random = cloneHashMap.get(originalHashMap.get(head.random));
      current = current.next;
      head = head.next;
    }

    return newHead;
  }
}

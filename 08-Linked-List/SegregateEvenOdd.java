class Node {

  public int data;
  public Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class SegregateEvenOdd {

  public static Node segregateOddEven(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node dummy = new Node(-1);
    dummy.next = head;

    Node firstEvenPrev = dummy, firstEven = head;

    while (firstEven != null) {
      while (firstEven.next != null && firstEven.data % 2 != 0) {
        firstEvenPrev = firstEven;
        firstEven = firstEven.next;
      }

      if (firstEven.next == null) {
        break;
      }

      Node firstOddPrev = firstEven, lastOdd = firstEven.next;
      while (lastOdd != null && lastOdd.data % 2 == 0) {
        firstOddPrev = lastOdd;
        lastOdd = lastOdd.next;
      }

      if (lastOdd == null) {
        break;
      }

      while (lastOdd.next != null && lastOdd.next.data % 2 != 0) {
        lastOdd = lastOdd.next;
      }

      Node temp = firstOddPrev.next;
      firstOddPrev.next = lastOdd.next;
      lastOdd.next = firstEven;
      firstEvenPrev.next = temp;
      firstEvenPrev = lastOdd;
      firstEven = lastOdd.next;
    }

    return dummy.next;
  }
}

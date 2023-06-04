class LinkedListNode<T> {

  T data;
  LinkedListNode<T> next;

  public LinkedListNode(T data) {
    this.data = data;
  }
}

public class ReverseLinkedList {

  public static LinkedListNode<Integer> reverseLinkedList(
    LinkedListNode<Integer> head
  ) {
    if (head == null || head.next == null) {
      return head;
    }

    LinkedListNode<Integer> prev = head, current = head.next;
    while (current != null) {
      LinkedListNode<Integer> next = current.next;
      current.next = prev;
      if (prev == head) {
        prev.next = null;
      }

      prev = current;
      current = next;
    }

    head.next = current;
    head = prev;

    return head;
  }
}

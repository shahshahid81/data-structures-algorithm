class LinkedListNode {

  Integer data;
  LinkedListNode next;

  public LinkedListNode(Integer data) {
    this.data = data;
  }
}

class pivotNewHeadTail {

  LinkedListNode newHead;
  LinkedListNode newTail;
  LinkedListNode pivot;

  public pivotNewHeadTail(
    LinkedListNode newHead,
    LinkedListNode newTail,
    LinkedListNode pivot
  ) {
    this.newHead = newHead;
    this.newTail = newTail;
    this.pivot = pivot;
  }
}

public class QuickSortLinkedList {

  public static LinkedListNode getTail(LinkedListNode current) {
    while (current != null && current.next != null) {
      current = current.next;
    }
    return current;
  }

  public static pivotNewHeadTail partition(
    LinkedListNode head,
    LinkedListNode tail,
    LinkedListNode newHead,
    LinkedListNode newTail
  ) {
    LinkedListNode pivot = tail;
    LinkedListNode prev = null, current = head;

    while (current != pivot) {
      if (current.data < pivot.data) {
        if (newHead == null) {
          newHead = current;
        }

        prev = current;
        current = current.next;
      } else {
        if (prev != null) {
          prev.next = current.next;
        }
        LinkedListNode temp = current.next;
        current.next = null;
        tail.next = current;
        tail = current;
        current = temp;
      }
    }

    if (newHead == null) {
      newHead = pivot;
    }

    newTail = tail;
    pivotNewHeadTail pivotHeadTail = new pivotNewHeadTail(
      newHead,
      newTail,
      pivot
    );
    return pivotHeadTail;
  }

  public static LinkedListNode quickSortHelper(
    LinkedListNode head,
    LinkedListNode tail
  ) {
    if (head == null || head == tail) {
      return head;
    }

    LinkedListNode newHead = null, newTail = null;

    pivotNewHeadTail pivotHeadTail = partition(head, tail, newHead, newTail);
    LinkedListNode pivot = pivotHeadTail.pivot;
    newHead = pivotHeadTail.newHead;
    newTail = pivotHeadTail.newTail;

    if (newHead != pivot) {
      LinkedListNode temp = newHead;
      while (temp.next != pivot) {
        temp = temp.next;
      }
      temp.next = null;

      newHead = quickSortHelper(newHead, temp);

      temp = getTail(newHead);
      temp.next = pivot;
    }

    pivot.next = quickSortHelper(pivot.next, newTail);

    return newHead;
  }

  public static LinkedListNode quickSortLL(LinkedListNode head) {
    LinkedListNode tail = getTail(head);
    head = quickSortHelper(head, tail);
    return head;
  }
}

import java.util.HashMap;

class DoublyLinkedListNode {

  Integer key, value;
  DoublyLinkedListNode prev, next;

  DoublyLinkedListNode(Integer key, Integer value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

public class LRUCache {

  HashMap<Integer, DoublyLinkedListNode> hashMap;
  DoublyLinkedListNode head, tail;
  int capacity;

  LRUCache(int capacity) {
    this.capacity = capacity;
    hashMap = new HashMap<>(capacity);
  }

  public int get(int key) {
    DoublyLinkedListNode element = hashMap.get(key);
    if (element == null) {
      return -1;
    }
    this.remove(element);
    this.addLast(element);
    return element.value;
  }

  public void put(int key, int value) {
    DoublyLinkedListNode existingNode = hashMap.get(key);
    if (existingNode != null) {
      existingNode.value = value;
      this.remove(existingNode);
      this.addLast(existingNode);
    } else {
      DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
      hashMap.put(key, node);

      if (hashMap.size() > capacity) {
        hashMap.remove(head.key);
        this.remove(head);
      }
      this.addLast(node);
    }
  }

  private void remove(DoublyLinkedListNode node) {
    if (node == null) {
      return;
    }

    if (node.prev != null) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }

    if (node.next != null) {
      node.next.prev = node.prev;
    } else {
      tail = node.prev;
    }

    node.next = null;
    node.prev = null;
  }

  private void addLast(DoublyLinkedListNode node) {
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
  }
}

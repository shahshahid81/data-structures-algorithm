class Entry {

  String key;
  int value;
  Entry next;

  Entry(String key, int value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

public class MyHashMap {

  private Entry[] buckets;
  private int size;

  public MyHashMap() {
    buckets = new Entry[3];
    size = 0;
  }

  public void insert(String key, int value) {
    double loadFactor = (size * 1.0) / buckets.length;

    if (loadFactor >= 0.75) {
      this.rehash();
    }

    int bucketIndex = getBucketIndex(key);
    Entry entry = new Entry(key, value);

    if (this.buckets[bucketIndex] == null) {
      this.buckets[bucketIndex] = entry;
      this.size++;
      return;
    }

    Entry prev = null;
    Entry head = this.buckets[bucketIndex];
    while (head != null) {
      if (head.key.equals(key)) {
        head.value = value;
        return;
      }
      prev = head;
      head = head.next;
    }

    prev.next = entry;
    this.size++;
  }

  public int get(String key) {
    Entry entry = this.getEntry(key);
    return entry == null ? -1 : entry.value;
  }

  public void remove(String key) {
    int bucketIndex = getBucketIndex(key);
    Entry head = this.buckets[bucketIndex];

    if (head == null) {
      return;
    }

    Entry prev = null;
    Entry current = head;
    while (current != null) {
      if (current.key.equals(key)) {
        if (prev == null) {
          this.buckets[bucketIndex] = head.next;
        } else {
          prev.next = current.next;
        }
        this.size--;
        return;
      }

      prev = current;
      current = current.next;
    }
  }

  public boolean search(String key) {
    return this.get(key) != -1;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private int getBucketIndex(String key) {
    int hashcode = key.hashCode();
    return (
      ((hashcode % this.buckets.length) + this.buckets.length) %
      this.buckets.length
    );
  }

  private Entry getEntry(String key) {
    int bucketIndex = getBucketIndex(key);

    if (this.buckets[bucketIndex] != null) {
      Entry head = this.buckets[bucketIndex];
      while (head != null) {
        if (head.key.equals(key)) {
          return head;
        }
        head = head.next;
      }
    }

    return null;
  }

  private void rehash() {
    Entry[] oldData = this.buckets;
    this.buckets = new Entry[oldData.length * 2];
    this.size = 0;
    for (Entry entry : oldData) {
      while (entry != null) {
        this.insert(entry.key, entry.value);
        entry = entry.next;
      }
    }
  }
}

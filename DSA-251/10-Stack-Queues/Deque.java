public class Deque {

  int[] queue;
  int capacity;
  int size;
  int front;
  int rear;

  public Deque(int n) {
    queue = new int[n];
    capacity = n;
    size = 0;
    front = -1;
    rear = -1;
  }

  public boolean pushFront(int x) {
    if (this.isFull()) {
      return false;
    }

    if (isEmpty()) {
      front = rear = 1;
    } else {
      front = front == 0 ? capacity - 1 : front - 1;
    }

    queue[front] = x;
    size++;
    return true;
  }

  public boolean pushRear(int x) {
    if (this.isFull()) {
      return false;
    }

    if (isEmpty()) {
      front = rear = 1;
    } else {
      rear = rear == capacity - 1 ? 0 : rear + 1;
    }

    queue[rear] = x;
    size++;
    return true;
  }

  public int popFront() {
    if (isEmpty()) {
      return -1;
    }

    int elem = queue[front];
    if (size == 1) {
      front = rear = -1;
    } else {
      front = front == capacity - 1 ? 0 : front + 1;
    }

    size--;
    return elem;
  }

  public int popRear() {
    if (isEmpty()) {
      return -1;
    }

    int elem = queue[rear];
    if (size == 1) {
      front = rear = -1;
    } else {
      rear = rear == 0 ? capacity - 1 : rear - 1;
    }

    size--;
    return elem;
  }

  public int getFront() {
    return isEmpty() ? -1 : queue[front];
  }

  public int getRear() {
    return isEmpty() ? -1 : queue[rear];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }
}

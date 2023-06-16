import java.util.ArrayDeque;

public class StackUsingQueue {

  ArrayDeque<Integer> queue1, queue2;

  public StackUsingQueue() {
    queue1 = new ArrayDeque<>();
    queue2 = new ArrayDeque<>();
  }

  public int getSize() {
    return queue1.size() + queue2.size();
  }

  public boolean isEmpty() {
    return queue1.isEmpty() && queue2.isEmpty();
  }

  public void push(int element) {
    queue1.add(element);
  }

  public int pop() {
    if (isEmpty()) {
      return -1;
    }
    while (queue1.size() != 1) {
      queue2.add(queue1.remove());
    }
    int value = queue1.remove();
    while (!queue2.isEmpty()) {
      queue1.add(queue2.remove());
    }
    return value;
  }

  public int top() {
    if (isEmpty()) {
      return -1;
    }
    while (queue1.size() != 1) {
      queue2.add(queue1.remove());
    }
    int value = queue1.peek();
    queue2.add(queue1.remove());
    while (!queue2.isEmpty()) {
      queue1.add(queue2.remove());
    }
    return value;
  }
}

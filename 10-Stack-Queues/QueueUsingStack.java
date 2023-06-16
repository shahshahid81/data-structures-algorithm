import java.util.Stack;

public class QueueUsingStack {

  Stack<Integer> stack1, stack2;

  public QueueUsingStack() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void push(int x) {
    stack1.push(x);
  }

  public int pop() {
    if (empty()) {
      return -1;
    }
    this.rebalance();
    return stack2.pop();
  }

  public int peek() {
    if (empty()) {
      return -1;
    }
    this.rebalance();
    return stack2.peek();
  }

  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  private void rebalance() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
  }
}

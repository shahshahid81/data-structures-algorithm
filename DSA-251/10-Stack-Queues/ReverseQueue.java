import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

  public Queue<Integer> reverseQueue(Queue<Integer> q) {
    Stack<Integer> stack = new Stack<>();
    while (!q.isEmpty()) {
      stack.push(q.remove());
    }
    while (!stack.isEmpty()) {
      q.add(stack.pop());
    }
    return q;
  }
}

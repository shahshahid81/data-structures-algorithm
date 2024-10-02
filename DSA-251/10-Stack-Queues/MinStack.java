import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

  private Stack<ArrayList<Integer>> stack;

  public MinStack() {
    stack = new Stack<ArrayList<Integer>>();
  }

  public void push(int num) {
    ArrayList<Integer> element = new ArrayList<>();
    element.add(num);
    element.add(stack.isEmpty() ? num : Math.min(num, stack.peek().get(1)));
    stack.push(element);
  }

  public void pop() {
    if (!stack.isEmpty()) {
      stack.pop();
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek().get(0);
  }

  public int getMin() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek().get(1);
  }
}

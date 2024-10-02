import java.util.Stack;

public class SortStack {

  public static void sortStack(Stack<Integer> stack) {
    if (stack.isEmpty()) return;
    Stack<Integer> result = new Stack<>();
    sortStack(stack, result);
    copyStack(stack, result);
  }

  private static void sortStack(Stack<Integer> stack, Stack<Integer> result) {
    if (stack.isEmpty()) return;
    largestAtTop(stack);
    result.push(stack.pop());
    sortStack(stack, result);
  }

  private static void largestAtTop(Stack<Integer> stack) {
    if (stack.isEmpty() || stack.size() == 1) return;
    Integer element = stack.pop();
    largestAtTop(stack);
    if (element < stack.peek()) {
      Integer temp = stack.pop();
      stack.push(element);
      stack.push(temp);
    } else {
      stack.push(element);
    }
  }

  private static void copyStack(Stack<Integer> stack, Stack<Integer> result) {
    if (result.isEmpty()) return;
    stack.push(result.pop());
    copyStack(stack, result);
  }
}

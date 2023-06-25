import java.util.Stack;

public class NextGreaterElement {

  public int[] nextGreater(int[] arr, int n) {
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty()) {
        if (stack.peek() > arr[i]) {
          result[i] = stack.peek();
          stack.push(arr[i]);
          break;
        } else {
          stack.pop();
        }
      }

      if (stack.isEmpty()) {
        result[i] = -1;
        stack.push(arr[i]);
      }
    }

    return result;
  }
}

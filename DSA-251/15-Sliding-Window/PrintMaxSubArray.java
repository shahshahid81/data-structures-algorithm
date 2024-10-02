import java.util.Deque;
import java.util.LinkedList;

public class PrintMaxSubArray {

  public static void printSubarrayMax(int[] arr, int n, int k) {
    if (k <= 0 || n <= 0) {
      return;
    }

    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      if (!deque.isEmpty() && deque.peekFirst() == i - k) {
        deque.removeFirst();
      }

      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
        deque.removeLast();
      }

      deque.addLast(i);
      if (i >= k - 1) {
        sb.append(arr[deque.peekFirst()]);
        sb.append(" ");
      }
    }
    sb.setLength(sb.length() - 1);

    System.out.println(sb.toString());
  }
}

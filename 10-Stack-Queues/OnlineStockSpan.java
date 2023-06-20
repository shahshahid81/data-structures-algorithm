import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {

  public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
    Stack<int[]> stack = new Stack<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int currentPrice : price) {
      int currentSpan = 1;
      while (!stack.isEmpty() && stack.peek()[0] <= currentPrice) {
        currentSpan += stack.pop()[1];
      }
      stack.push(new int[] { currentPrice, currentSpan });
      result.add(currentSpan);
    }
    return result;
  }
}

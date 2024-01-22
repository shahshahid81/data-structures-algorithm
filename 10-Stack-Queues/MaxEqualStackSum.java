import java.util.Stack;

public class MaxEqualStackSum {

  public static int maxSum(
    Stack<Integer> stk1,
    Stack<Integer> stk2,
    Stack<Integer> stk3
  ) {
    int sum1 = sum(stk1), sum2 = sum(stk2), sum3 = sum(stk3);

    while (!(sum1 == sum2 && sum1 == sum3 && sum2 == sum3)) {
      if (sum1 >= sum2 && sum1 >= sum3) {
        sum1 -= stk1.peek();
        stk1.pop();
      } else if (sum2 >= sum1 && sum2 >= sum3) {
        sum2 -= stk2.peek();
        stk2.pop();
      } else {
        sum3 -= stk3.peek();
        stk3.pop();
      }
    }
    return sum1;
  }

  private static int sum(Stack<Integer> stk) {
    Stack<Integer> temp = new Stack<>();
    int sum = 0;
    while (!stk.isEmpty()) {
      sum += stk.peek();
      temp.push(stk.pop());
    }

    while (!temp.isEmpty()) {
      stk.push(temp.pop());
    }
    return sum;
  }
}

import java.util.Stack;

public class ValidParantheses {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (ch == '[' || ch == '(' || ch == '{') {
        stack.add(ch);
      } else {
        if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) {
          return false;
        } else if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) {
          return false;
        } else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

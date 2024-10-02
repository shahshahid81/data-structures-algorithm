public class MinimumParantheses {

  public int minimumParentheses(String pattern) {
    int closingParantheses = 0, matchingParantheses = 0, n = pattern.length();
    for (int i = 0; i < n; i++) {
      char ch = pattern.charAt(i);
      if (ch == '(') {
        matchingParantheses++;
      } else if (ch == ')') {
        if (matchingParantheses != 0) {
          matchingParantheses--;
        } else {
          closingParantheses++;
        }
      }
    }
    return closingParantheses + matchingParantheses;
  }
}

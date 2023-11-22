public class AsciitoInteger {

  public int myAtoi(String s) {
    final String MIN = "2147483648";
    final String MAX = "2147483647";

    int i = 0, n = s.length();
    StringBuilder result = new StringBuilder();
    char sign = '\u0000';

    while (i < n && s.charAt(i) == ' ') {
      i++;
    }

    while (i < n) {
      char ch = s.charAt(i++);
      if (!Character.isDigit(ch)) {
        if (sign == '\u0000' && (ch == '+' || ch == '-')) {
          sign = ch;
          continue;
        }
        break;
      } else {
        if (sign == '\u0000') {
          sign = '+';
        }

        if (ch == '0' && result.length() == 0) {
          continue;
        }

        result.append(ch);
      }
    }

    n = result.length();

    if (n > 10) {
      return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    if (n == 10) {
      for (int j = 0; j < n; j++) {
        if (sign == '+') {
          if (result.charAt(j) > MAX.charAt(j)) {
            return Integer.MAX_VALUE;
          } else if (result.charAt(j) < MAX.charAt(j)) {
            break;
          }
        }

        if (sign == '-') {
          if (result.charAt(j) > MIN.charAt(j)) {
            return Integer.MIN_VALUE;
          } else if (result.charAt(j) < MIN.charAt(j)) {
            break;
          }
        }
      }
    }

    int value = 0;
    for (int j = 0; j < n; j++) {
      int digit = result.charAt(j) - '0';
      int power = (int) Math.pow(10, n - j - 1);
      value += (digit * power);
    }
    return sign == '-' ? value * -1 : value;
  }
}

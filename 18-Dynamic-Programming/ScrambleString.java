import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

  public boolean isScramble(String s1, String s2) {
    Map<String, Boolean> memo = new HashMap<>();
    return isScrambleHelper(memo, s1, s2);
  }

  private boolean isScrambleHelper(
    Map<String, Boolean> memo,
    String s1,
    String s2
  ) {
    int n = s1.length();
    boolean result = false;

    if (n == 0) {
      return true;
    }

    if (n == 1) {
      return s1.equals(s2);
    }

    if (memo.containsKey(s1 + s2)) {
      return memo.get(s1 + s2);
    }

    if (s1.equals(s2)) {
      result = true;
    } else {
      for (int i = 1; i < n && !result; i++) {
        result =
          (
            isScrambleHelper(memo, s1.substring(0, i), s2.substring(0, i)) &&
            isScrambleHelper(memo, s1.substring(i), s2.substring(i))
          ) ||
          (
            isScrambleHelper(memo, s1.substring(0, i), s2.substring(n - i)) &&
            isScrambleHelper(memo, s1.substring(i), s2.substring(0, n - i))
          );
      }
    }

    memo.put(s1 + s2, result);
    return result;
  }
}

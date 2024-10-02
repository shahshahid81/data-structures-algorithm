import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhone {

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    int n = digits.length();
    if (n == 0) {
      return result;
    }

    char[][] letters = {
      { 'a', 'b', 'c' },
      { 'd', 'e', 'f' },
      { 'g', 'h', 'i' },
      { 'j', 'k', 'l' },
      { 'm', 'n', 'o' },
      { 'p', 'q', 'r', 's' },
      { 't', 'u', 'v' },
      { 'w', 'x', 'y', 'z' },
    };

    StringBuilder sb = new StringBuilder();
    letterCombinations(digits, letters, sb, n, result, 0);
    return result;
  }

  private void letterCombinations(
    String s,
    char[][] letters,
    StringBuilder sb,
    int n,
    List<String> result,
    int index
  ) {
    int letterRangeIndex = Character.digit(s.charAt(index), 10) - 2;
    for (char ch : letters[letterRangeIndex]) {
      sb.append(ch);
      if (index < s.length() - 1) {
        letterCombinations(s, letters, sb, n, result, index + 1);
      } else {
        result.add(sb.toString());
      }
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}

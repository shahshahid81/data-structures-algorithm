import java.util.ArrayList;
import java.util.List;

public class GenerateAllParenthesis {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    char[] str = new char[2 * n];
    generateParenthesis(result, str, 0, 0, 0);
    return result;
  }

  private void generateParenthesis(
    List<String> result,
    char[] str,
    int opening,
    int closing,
    int index
  ) {
    if (closing > opening) {
      return;
    }

    if (index >= str.length) {
      if (opening == closing) {
        result.add(new String(str));
      }
      return;
    }

    str[index] = '(';
    generateParenthesis(result, str, opening + 1, closing, index + 1);

    str[index] = ')';
    generateParenthesis(result, str, opening, closing + 1, index + 1);
  }
}

import java.util.ArrayList;

public class BinaryStringNoConsecutiveOne {

  private static void generateBinaryString(
    int k,
    ArrayList<String> result,
    StringBuilder sb,
    char ch
  ) {
    int n = sb.length();
    if (ch == '1' && n != 0 && sb.charAt(n - 1) == '1') {
      return;
    }

    sb.append(ch);
    if (k == 0) {
      result.add(sb.toString());
    } else {
      k--;
      generateBinaryString(k, result, sb, '0');
      generateBinaryString(k, result, sb, '1');
    }
    sb.deleteCharAt(sb.length() - 1);
  }

  public static ArrayList<String> generateString(int k) {
    ArrayList<String> result = new ArrayList<>();
    if (k == 0) return result;
    k--;
    StringBuilder sb = new StringBuilder();
    generateBinaryString(k, result, sb, '0');
    generateBinaryString(k, result, sb, '1');
    return result;
  }
}

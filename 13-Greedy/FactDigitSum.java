public class  FactDigitSum {

  public static String factDigitSum(int n) {
    int[] factorial = new int[9];
    factorial[0] = 1;
    for (int i = 1; i < 9; i++) {
      factorial[i] = (i + 1) * factorial[i - 1];
    }

    StringBuilder sb = new StringBuilder();

    factDigitSum(n, factorial, sb);
    return sb.reverse().toString();
  }

  private static void factDigitSum(int n, int[] factorial, StringBuilder sb) {
    for (int i = 8; i >= 0; i--) {
      if (n - factorial[i] >= 0) {
        sb.append(i + 1);
        factDigitSum(n - factorial[i], factorial, sb);
        return;
      }
    }
  }
}

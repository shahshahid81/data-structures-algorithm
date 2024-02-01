public class LongestChunkedPalindromeDecomposition {
  public int longestDecomposition(String text) {
    int n = text.length();
    for (int i = 0; i < n / 2; i++) {
      String left = text.substring(0, i + 1);
      String right = text.substring(n - 1 - i, n);
      if (left.equals(right)) {
        return 2 + longestDecomposition(text.substring(i + 1, n - 1 - i));
      }
    }

    return (n == 0) ? 0 : 1;
  }
}

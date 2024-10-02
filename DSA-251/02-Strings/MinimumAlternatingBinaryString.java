public class MinimumAlternatingBinaryString {

  public int makeBeautiful(String str) {
    int startsWithZero = 0, startsWithOne = 0, n = str.length();

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        if (str.charAt(i) == '0') {
          startsWithOne++;
        } else {
          startsWithZero++;
        }
      } else {
        if (str.charAt(i) == '0') {
          startsWithZero++;
        } else {
          startsWithOne++;
        }
      }
    }

    return Math.min(startsWithZero, startsWithOne);
  }
}

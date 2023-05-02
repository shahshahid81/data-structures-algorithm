public class BeautifulString {

  public int makeBeautiful(String str) {
    int zeroToOneConversion = 0, oneToZeroConversion = 0, n = str.length();
    for (int i = 0; i < n; i += 2) {
      if (str.charAt(i) == '0') {
        oneToZeroConversion++;
      } else {
        zeroToOneConversion++;
      }

      if (i + 1 < n) {
        if (str.charAt(i + 1) == '1') {
          oneToZeroConversion++;
        } else {
          zeroToOneConversion++;
        }
      }
    }

    return Math.min(zeroToOneConversion, oneToZeroConversion);
  }
}

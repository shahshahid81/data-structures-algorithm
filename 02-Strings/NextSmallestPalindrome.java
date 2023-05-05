public class NextSmallestPalindrome {

  private static boolean allNine(String str) {
    int n = str.length();
    for (int i = 0; i < n; i++) {
      if (str.charAt(i) != '9') {
        return false;
      }
    }
    return true;
  }

  public static String nextLargestPalindrome(String str, int length) {
    if (allNine(str)) {
      StringBuilder sb = new StringBuilder();
      sb.append('1');
      for (int i = 0; i < length - 1; i++) {
        sb.append('0');
      }
      sb.append('1');
      return sb.toString();
    }

    char[] strArray = str.toCharArray();
    boolean isEven = length % 2 == 0;
    int mid = length / 2;
    int left = mid - 1, right = isEven ? mid : mid + 1;

    while (left >= 0 && strArray[left] == strArray[right]) {
      left--;
      right++;
    }

    boolean leftSmaller = left < 0 || strArray[left] < strArray[right];

    while (left >= 0) {
      strArray[right++] = strArray[left--];
    }

    if (leftSmaller) {
      int carry = 1;

      if (!isEven) {
        int value = Character.getNumericValue(strArray[mid]) + 1;
        carry = value / 10;
        strArray[mid] = Character.forDigit(value % 10, 10);
      }

      left = mid - 1;
      right = isEven ? mid : mid + 1;

      while (left >= 0 && carry > 0) {
        int value = Character.getNumericValue(strArray[left]) + carry;
        carry = value / 10;
        strArray[left] = Character.forDigit(value % 10, 10);
        strArray[right] = strArray[left];
        left--;
        right++;
      }
    }

    return new String(strArray);
  }
}

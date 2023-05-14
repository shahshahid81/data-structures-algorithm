public class KthCharacterDecryptedString {

  public static char kThCharaterOfDecryptedString(String s, Long k) {
    int currentCount = 0, n = s.length(), i = 0;
    while (i < n) {
      StringBuilder subStr = new StringBuilder();
      StringBuilder count = new StringBuilder();
      while (i < n && !Character.isDigit(s.charAt(i))) {
        subStr.append(s.charAt(i++));
      }

      while (i < n && Character.isDigit(s.charAt(i))) {
        count.append(s.charAt(i++));
      }

      int frequency = Integer.parseInt(count.toString()) * subStr.length();

      if (currentCount + frequency < k) {
        currentCount += frequency;
        continue;
      }

      if (subStr.length() == 1) return subStr.charAt(0);

      int index = (int) ((k - currentCount - 1) % (subStr.length()));
      return subStr.charAt(index);
    }

    return '0';
  }
}

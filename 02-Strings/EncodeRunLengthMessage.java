import java.util.Arrays;

public class EncodeRunLengthMessage {

  public static String encode(String message) {
    int messageLength = message.length();
    if (messageLength == 0) return "";

    char[] charCount = new char[messageLength * 2];
    int i = 0, charCountIndex = 0;
    while (i < messageLength) {
      char currentCharacter = message.charAt(i);
      int count = 1, j = i + 1;
      while (j < messageLength && currentCharacter == message.charAt(j)) {
        j++;
        count++;
      }
      charCount[charCountIndex++] = currentCharacter;
      for (char ch : String.valueOf(count).toCharArray()) {
        charCount[charCountIndex++] = ch;
      }
      i = j;
    }

    return new String(Arrays.copyOfRange(charCount, 0, charCountIndex));
  }
}

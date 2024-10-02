public class EncodeRunLengthMessage {

  public String encode(String message) {
    int messageLength = message.length();
    if (messageLength == 0) return "";

    StringBuilder encodedMessage = new StringBuilder();
    for (int i = 0; i < messageLength; i++) {
      char currentCharacter = message.charAt(i);
      int count = 1;
      while (
        i + 1 < messageLength && currentCharacter == message.charAt(i + 1)
      ) {
        i++;
        count++;
      }
      encodedMessage.append(currentCharacter);
      encodedMessage.append(String.valueOf(count));
    }

    return encodedMessage.toString();
  }
}

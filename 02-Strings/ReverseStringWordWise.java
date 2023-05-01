import java.util.Arrays;
import java.util.Scanner;

public class ReverseStringWordWise {

  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private void reverse(char[] array, int i, int j) {
    while (i < j) {
      swap(array, i++, j--);
    }
  }

  private char[] removeExtraSpaceFromBetween(char[] inputArray) {
    char[] processedCharacters = new char[inputArray.length];
    int processIndex = 0;
    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] == ' ' && i > 0 && inputArray[i - 1] == ' ') {
        continue;
      }
      processedCharacters[processIndex++] = inputArray[i];
    }
    return Arrays.copyOfRange(processedCharacters, 0, processIndex);
  }

  public String reverseWords(String input) {
    char[] inputArray = input.trim().toCharArray();
    inputArray = removeExtraSpaceFromBetween(inputArray);

    reverse(inputArray, 0, inputArray.length - 1);

    int currentIndex = 0, start = 0;
    while (currentIndex < inputArray.length) {
      if (
        inputArray[currentIndex] != ' ' && currentIndex != inputArray.length - 1
      ) {
        currentIndex++;
      } else {
        reverse(
          inputArray,
          start,
          currentIndex == inputArray.length - 1
            ? currentIndex
            : currentIndex - 1
        );
        start = ++currentIndex;
      }
    }

    return new String(inputArray);
  }

  public static void main(String args[]) {
    ReverseStringWordWise rs = new ReverseStringWordWise();
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String ans = rs.reverseWords(input);
    System.out.println(ans);
    sc.close();
  }
}

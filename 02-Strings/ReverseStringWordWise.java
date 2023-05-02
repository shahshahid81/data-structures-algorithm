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

  private char[] removeExtraSpace(String input) {
    int n = input.length();
    StringBuilder processedString = new StringBuilder();
    processedString.trimToSize();
    for (int i = 0; i < n; i++) {
      if (input.charAt(i) == ' ' && i > 0 && input.charAt(i - 1) == ' ') {
        continue;
      }
      processedString.append(input.charAt(i));
    }
    return processedString.toString().trim().toCharArray();
  }

  public String reverseWords(String input) {
    char[] inputArray = removeExtraSpace(input);

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

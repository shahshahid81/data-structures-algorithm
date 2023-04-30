import java.util.*;

public class RotateArray {

  private static void reverse(int[] array, int start, int end) {
    while (start < end) {
      int temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
  }

  public static void rotate(int[] array, int steps) {
    reverse(array, 0, (steps % array.length) - 1);
    reverse(array, (steps % array.length), array.length - 1);
	reverse(array, 0, array.length - 1);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = scanner.nextInt();
    }
    int steps = scanner.nextInt();
    rotate(array, steps);
    for (int element : array) {
      System.out.print(element + " ");
    }
    scanner.close();
  }
}

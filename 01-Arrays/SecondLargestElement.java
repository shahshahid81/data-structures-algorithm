public class SecondLargestElement {

  public static int findSecondLargest(int n, int[] arr) {
    if (n <= 1) {
      return -1;
    }

    int largest = arr[0];
    for (int i = 1; i < n; i++) {
      largest = Math.max(arr[i], largest);
    }

    int secondLargest = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] < largest) {
        secondLargest = Math.max(arr[i], secondLargest);
      }
    }

    return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
  }
}

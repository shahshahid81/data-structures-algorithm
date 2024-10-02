public class CountingSort {

  public int[] sort(int arr[]) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }

    int range = max - min + 1;

    int[] count = new int[range];
    int[] result = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      count[arr[i] - min]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      int index = --count[arr[i] - min];
      result[index] = arr[i];
    }

    return result;
  }
}

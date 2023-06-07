import java.util.List;

public class QuickSort {

  private static void swap(List<Integer> arr, int i, int j) {
    Integer temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }

  private static int partition(List<Integer> arr, int low, int high) {
    int pivotIndex = high--;
    while (low <= high) {
      while (low <= high && arr.get(low) < arr.get(pivotIndex)) {
        low++;
      }
      while (low <= high && arr.get(high) > arr.get(pivotIndex)) {
        high--;
      }

      if (low <= high) {
        swap(arr, low++, high--);
      }
    }

    if (arr.get(low) > arr.get(pivotIndex)) {
      swap(arr, low, pivotIndex);
      pivotIndex = low;
    }

    return pivotIndex;
  }

  private static void quickSort(List<Integer> arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }

  public static List<Integer> quickSort(List<Integer> arr) {
    quickSort(arr, 0, arr.size() - 1);
    return arr;
  }
}

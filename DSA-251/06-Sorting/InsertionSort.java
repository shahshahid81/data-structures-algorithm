public class InsertionSort {

  private void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      while (j - 1 >= 0 && arr[j] < arr[j - 1]) swap(arr, j, --j);
    }
  }
}

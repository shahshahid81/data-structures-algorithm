public class SelectionSort {

  private void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void selectionSort(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[min] > arr[j]) min = j;
      }
      swap(arr, i, min);
    }
  }
}

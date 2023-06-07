public class MergeSort {

  private int[] merge(int[] arr1, int[] arr2) {
    int i = 0, j = 0, k = 0;
    int[] result = new int[arr1.length + arr2.length];

    while (i < arr1.length && j < arr2.length) {
      result[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
    }

    while (i < arr1.length) {
      result[k++] = arr1[i++];
    }

    while (j < arr2.length) {
      result[k++] = arr2[j++];
    }

    return result;
  }

  private int[] mergeSort(int[] arr, int low, int high) {
    if (low == high) {
      return new int[] { arr[low] };
    }

    int mid = low + (high - low) / 2;
    return merge(mergeSort(arr, low, mid), mergeSort(arr, mid + 1, high));
  }

  public void mergeSort(int[] arr, int n) {
    int low = 0, high = arr.length - 1;
    int[] result = mergeSort(arr, low, high);
    for (int i = 0; i < n; i++) {
      arr[i] = result[i];
    }
  }
}

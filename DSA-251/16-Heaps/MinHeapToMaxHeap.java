public class MinHeapToMaxHeap {

  public static void minHeapToMaxHeap(long[] arr) {
    for (int i = arr.length / 2; i >= 0; i--) {
      maxHeapify(arr, i);
    }
  }

  private static void maxHeapify(long[] arr, int pos) {
    while (pos < arr.length) {
      int left = pos * 2 + 1;
      if (left >= arr.length) {
        break;
      }
      long leftChild = arr[left];

      int right = pos * 2 + 2;
      long rightChild = right >= arr.length ? Long.MIN_VALUE : arr[right];

      if (arr[pos] < Math.max(leftChild, rightChild)) {
        if (leftChild > rightChild) {
          swap(arr, pos, left);
          pos = left;
        } else {
          swap(arr, pos, right);
          pos = right;
        }
      } else {
        break;
      }
    }
  }

  private static void swap(long[] array, int i, int j) {
    long temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

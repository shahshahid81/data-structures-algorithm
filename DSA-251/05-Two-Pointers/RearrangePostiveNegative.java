public class RearrangePostiveNegative {

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public int[] separateNegativeAndPositive(int arr[]) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      if (arr[left] < 0 && arr[right] < 0) {
        left++;
      } else if (arr[left] >= 0 && arr[right] >= 0) {
        right--;
      } else if (arr[left] < 0 && arr[right] >= 0) {
        left++;
        right--;
      } else {
        swap(arr, left++, right--);
      }
    }
    return arr;
  }
}

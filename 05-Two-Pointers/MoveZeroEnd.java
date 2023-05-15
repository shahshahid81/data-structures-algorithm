public class MoveZeroEnd {

  public void moveZeroes(int[] arr) {
    int count = 0, n = arr.length;

    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        arr[count++] = arr[i];
      }
    }

    for (int i = count; i < n; i++) {
      arr[i] = 0;
    }
  }
}

public class RotateMatrixRight {

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void reverse(int[] arr, int i, int j) {
    while (i < j) swap(arr, i++, j--);
  }

  public int[][] rotateMatRight(int[][] mat, int k) {
    for (int i = 0; i < mat.length; i++) {
      int step = k % mat[i].length;
      reverse(mat[i], 0, mat[i].length - 1);
      reverse(mat[i], 0, step - 1);
      reverse(mat[i], step, mat[i].length - 1);
    }
    return mat;
  }
}

public class Sort012 {

  public void sort012(int[] arr) {
    int numberOfZeroes = 0, numberOfOnes = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) numberOfZeroes++; else if (arr[i] == 1) numberOfOnes++;
    }

    for (int i = 0; i < arr.length; i++) {
      if (numberOfZeroes != 0) {
        arr[i] = 0;
        numberOfZeroes--;
      } else if (numberOfOnes != 0) {
        arr[i] = 1;
        numberOfOnes--;
      } else {
        arr[i] = 2;
      }
    }
  }
}

public class Equilibirium {

  public int arrayEquilibriumIndex(int[] arr) {
    if (arr.length == 0) {
      return -1;
    }

    int total = 0;
    for (int element : arr) {
      total += element;
    }

    int leftSum = 0;

    for (int i = 0; i < arr.length; i++) {
      if (total - leftSum - arr[i] == leftSum) {
        return i;
      }
      leftSum += arr[i];
    }

    return -1;
  }
}

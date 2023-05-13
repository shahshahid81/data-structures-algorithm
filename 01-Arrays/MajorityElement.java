public class MajorityElement {

  public int findMajority(int[] arr) {
    int count = 0, majorityElement = 0, n = arr.length;
    for (int i = 0; i < n; i++) {
      if (count == 0) {
        majorityElement = arr[i];
        count = 1;
      } else if (majorityElement == arr[i]) {
        count++;
      } else {
        count--;
      }
    }

    count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == majorityElement) count++;
      if (count > Math.floor(arr.length / 2)) return majorityElement;
    }
    return -1;
  }
}

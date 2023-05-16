import java.util.ArrayList;
import java.util.Arrays;

public class SumOfTwoElement {

  private static ArrayList<Integer> twoSum(int[] arr, int k) {
    int low = 0, high = arr.length - 1;
    ArrayList<Integer> result = new ArrayList<>();

    while (low < high) {
      if (low == k) {
        low++;
      } else if (high == k) {
        high--;
      } else {
        int sum = arr[low] + arr[high];
        if (sum == arr[k]) {
          result.add(arr[low]);
          result.add(arr[high]);
          result.add(arr[k]);
          return result;
        } else if (sum > arr[k]) {
          high--;
        } else {
          low++;
        }
      }
    }

    return result;
  }

  public static ArrayList<Integer> findTriplets(int[] arr, int n) {
    ArrayList<Integer> result = new ArrayList<>();

    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      while (i + 1 < n && arr[i] == arr[i + 1]) i++;
      result = twoSum(arr, i);
      if (result.size() != 0) break;
    }

    return result;
  }
}

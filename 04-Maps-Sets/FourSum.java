import java.util.HashMap;

public class FourSum {

  public String fourSum(int[] arr, int target, int n) {
    if (n < 4) return "No";

    HashMap<Integer, Integer[]> hashMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int sum = arr[i] + arr[j];

        if (hashMap.containsKey(target - sum)) {
          Integer[] indexToCompare = hashMap.get(target - sum);
          if (
            i != indexToCompare[0] &&
            j != indexToCompare[0] &&
            i != indexToCompare[1] &&
            j != indexToCompare[1]
          ) {
            return "Yes";
          }
        }

        hashMap.put(sum, new Integer[] { i, j });
      }
    }

    return "No";
  }
}

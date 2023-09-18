import java.util.ArrayList;

public class CombinationSum {

  private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
  private static ArrayList<Integer> list = new ArrayList<>();

  public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(
    ArrayList<Integer> arr,
    int n,
    int k
  ) {
    findSubsetsThatSumToK(arr, n, k, 0, 0);

    return result;
  }

  private static void findSubsetsThatSumToK(
    ArrayList<Integer> arr,
    int n,
    int k,
    int sum,
    int index
  ) {
    if (index >= n) {
      return;
    }

    for (int i = index; i < n; i++) {
      list.add(arr.get(index));
      sum += arr.get(index);
      if (sum == k) {
        result.add(new ArrayList<>(list));
      }
      findSubsetsThatSumToK(arr, n, k, sum, ++index);
      list.remove(list.size() - 1);
      sum -= arr.get(index - 1);
    }
  }
}

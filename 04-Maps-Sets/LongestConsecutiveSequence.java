import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] arr) {
    if (arr.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
      set.add(num);
      max = Math.max(max, num);
    }

    int maxConsecutive = 1;
    for (int i = 0; i < arr.length; i++) {
      int currentConsecutive = 1;
      if (set.contains(arr[i] - 1)) continue;
      for (int j = arr[i] + 1; j <= max; j++) {
        if (set.contains(j)) {
          maxConsecutive = Math.max(++currentConsecutive, maxConsecutive);
        } else {
          break;
        }
      }
    }

    return maxConsecutive;
  }
}

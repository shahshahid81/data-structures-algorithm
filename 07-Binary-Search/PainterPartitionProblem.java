import java.util.ArrayList;

public class PainterPartitionProblem {

  private static int findMax(ArrayList<Integer> boards, int n) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if (boards.get(i) > max) {
        max = boards.get(i);
      }
    }

    return max;
  }

  private static int findSum(ArrayList<Integer> boards, int n) {
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += boards.get(i);
    }
    return total;
  }

  private static int countPainters(ArrayList<Integer> boards, int maxLen) {
    int n = boards.size(), totalSum = 0, painters = 1;

    for (int i = 0; i < n; i++) {
      totalSum += boards.get(i);

      if (totalSum > maxLen) {
        totalSum = boards.get(i);
        painters++;
      }
    }

    return painters;
  }

  public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
    int n = boards.size();

    int low = findMax(boards, n);
    int high = findSum(boards, n);

    while (low < high) {
      int mid = low + (high - low) / 2;
      int reqPainters = countPainters(boards, mid);

      if (reqPainters <= k) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
}

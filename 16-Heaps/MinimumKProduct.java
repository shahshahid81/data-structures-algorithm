import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumKProduct {

  private static final int MOD = 1000000007;

  public static int minProduct(int[] arr, int n, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
      Collections.reverseOrder()
    );
    for (int i = 0; i < k; i++) {
      priorityQueue.add(arr[i]);
    }

    for (int i = k; i < n; i++) {
      if (arr[i] > priorityQueue.peek()) {
        continue;
      }

      priorityQueue.poll();
      priorityQueue.add(arr[i]);
    }

    long result = 1;
    while (!priorityQueue.isEmpty()) {
      result = ((result % MOD) * (priorityQueue.poll() % MOD)) % MOD;
    }
    return (int) result;
  }
}

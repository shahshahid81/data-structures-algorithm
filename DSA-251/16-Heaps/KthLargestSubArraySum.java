import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestSubArraySum {

  public static int getKthLargest(ArrayList<Integer> arr, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int n = arr.size();
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += arr.get(j);
        if (priorityQueue.size() < k) {
          priorityQueue.add(sum);
        } else if (priorityQueue.peek() < sum) {
          priorityQueue.poll();
          priorityQueue.add(sum);
        }
      }
    }

    return priorityQueue.peek();
  }
}

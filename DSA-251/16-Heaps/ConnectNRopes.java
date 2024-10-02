import java.util.PriorityQueue;

public class ConnectNRopes {

  public static long connectRopes(int[] arr) {
    long sum = 0;
    if (arr.length <= 1) {
      return sum;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
      pq.add(arr[i]);
    }

    while (!pq.isEmpty()) {
      int current = pq.poll();
      current += pq.poll();
      if (!pq.isEmpty()) {
        pq.add(current);
      }
      sum += current;
    }
    return sum;
  }
}

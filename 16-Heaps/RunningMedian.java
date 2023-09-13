import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

  public static void findMedian(int arr[]) {
    PriorityQueue<Integer> lowerPq = new PriorityQueue<>(
      Collections.reverseOrder()
    );
    PriorityQueue<Integer> upperPq = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      if (lowerPq.size() == 0 && upperPq.size() == 0) {
        lowerPq.add(arr[i]);
      } else if (lowerPq.size() != 0 && arr[i] <= lowerPq.peek()) {
        lowerPq.add(arr[i]);
      } else {
        upperPq.add(arr[i]);
      }

      while (Math.abs(lowerPq.size() - upperPq.size()) > 1) {
        PriorityQueue<Integer> larger = lowerPq.size() > upperPq.size()
          ? lowerPq
          : upperPq;
        PriorityQueue<Integer> smaller = lowerPq.size() < upperPq.size()
          ? lowerPq
          : upperPq;
        smaller.add(larger.poll());
      }

      int median = 0;

      if (lowerPq.size() == upperPq.size()) {
        median = (lowerPq.peek() + upperPq.peek()) / 2;
      } else {
        median =
          lowerPq.size() > upperPq.size() ? lowerPq.peek() : upperPq.peek();
      }
      System.out.print(median + " ");
    }
  }
}

class MedianFinder {

  PriorityQueue<Integer> lowerPq;
  PriorityQueue<Integer> upperPq;

  public MedianFinder() {
    lowerPq = new PriorityQueue<>(Collections.reverseOrder());
    upperPq = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if (lowerPq.size() == 0 && upperPq.size() == 0) {
      lowerPq.add(num);
    } else if (lowerPq.size() != 0 && num <= lowerPq.peek()) {
      lowerPq.add(num);
    } else {
      upperPq.add(num);
    }

    while (Math.abs(lowerPq.size() - upperPq.size()) > 1) {
      PriorityQueue<Integer> larger = lowerPq.size() > upperPq.size()
        ? lowerPq
        : upperPq;
      PriorityQueue<Integer> smaller = lowerPq.size() < upperPq.size()
        ? lowerPq
        : upperPq;
      smaller.add(larger.poll());
    }
  }

  public double findMedian() {
    if (lowerPq.size() == upperPq.size()) {
      return (lowerPq.peek() * 1.0 + upperPq.peek()) / 2;
    } else {
      return (
        (lowerPq.size() > upperPq.size() ? lowerPq.peek() : upperPq.peek()) *
        1.0
      );
    }
  }
}

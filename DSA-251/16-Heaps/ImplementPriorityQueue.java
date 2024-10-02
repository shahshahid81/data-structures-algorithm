import java.util.List;

public class ImplementPriorityQueue {

  public static int pop(List<Integer> heap) {
    if (heap.isEmpty()) {
      return -1;
    }

    int elementToRemove = heap.get(0);
    if (heap.size() == 1) {
      heap.remove(0);
    } else {
      heap.set(0, heap.get(heap.size() - 1));
      heap.remove(heap.size() - 1);

      int pos = 0;
      while (pos < heap.size()) {
        int left = pos * 2 + 1;
        int right = pos * 2 + 2;
        if (left >= heap.size()) {
          break;
        }
        int leftChild = heap.get(left);
        int rightChild = right >= heap.size()
          ? Integer.MIN_VALUE
          : heap.get(right);

        if (heap.get(pos) < Math.max(leftChild, rightChild)) {
          if (leftChild > rightChild) {
            int temp = heap.get(pos);
            heap.set(pos, heap.get(left));
            heap.set(left, temp);
            pos = left;
          } else {
            int temp = heap.get(pos);
            heap.set(pos, heap.get(right));
            heap.set(right, temp);
            pos = right;
          }
        } else {
          break;
        }
      }
    }

    return elementToRemove;
  }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MergeKSortedArray {

  public static ArrayList<Integer> mergeKSortedArrays(
    ArrayList<ArrayList<Integer>> kArrays,
    int k
  ) {
    int n = kArrays.size(), total = 0;
    for (int i = 0; i < n; i++) {
      total += kArrays.get(i).size();
    }

    ArrayList<Integer> result = new ArrayList<>();
    if (n == 0) {
      return result;
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    HashMap<Integer, ArrayList<ArrayList<Integer>>> hashMap = new HashMap<>();

    for (int i = 0; i < k; i++) {
      Integer element = kArrays.get(i).get(0);
      priorityQueue.add(element);
      addToMap(hashMap, element, i, 0);
    }

    while (result.size() != total) {
      int resultSize = result.size();

      if (resultSize != 0) {
        Integer element = result.get(resultSize - 1);
        ArrayList<ArrayList<Integer>> indexList = hashMap.get(element);
        if (indexList.size() != 0) {
          ArrayList<Integer> indexes = indexList.remove(0);
          int i = indexes.get(0);
          int j = indexes.get(1);
          if (i < n && ++j < kArrays.get(i).size()) {
            int newElement = kArrays.get(i).get(j);
            priorityQueue.add(newElement);
            addToMap(hashMap, newElement, i, j);
          }
        }
      }

      result.add(priorityQueue.poll());
    }

    return result;
  }

  private static void addToMap(
    HashMap<Integer, ArrayList<ArrayList<Integer>>> hashMap,
    Integer element,
    int i,
    int j
  ) {
    if (!hashMap.containsKey(element)) {
      hashMap.put(element, new ArrayList<>());
    }
    ArrayList<Integer> indexes = new ArrayList<>();
    indexes.add(i);
    indexes.add(j);
    hashMap.get(element).add(indexes);
  }
}

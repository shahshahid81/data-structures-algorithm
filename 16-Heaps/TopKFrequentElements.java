class Pair {

  int first, second;

  Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}

public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int num : nums) {
      hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.second - a.second);
    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      pq.add(new Pair(entry.getKey(), entry.getValue()));
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll().first;
    }

    return result;
  }
}

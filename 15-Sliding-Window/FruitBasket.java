import java.util.HashMap;

public class FruitBasket {

  public int totalFruit(int[] fruits) {
    int result = 0, left = 0, right = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    while (right < fruits.length) {
      hashMap.put(fruits[right], hashMap.getOrDefault(fruits[right], 0) + 1);

      while (hashMap.size() > 2) {
        int val = hashMap.get(fruits[left]);
        if (val == 1) {
          hashMap.remove(fruits[left]);
        } else {
          hashMap.put(fruits[left], val - 1);
        }
        left++;
      }

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}

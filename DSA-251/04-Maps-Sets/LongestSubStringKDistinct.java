import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKDistinct {

  public static int getLengthofLongestSubstring(String s, int k) {
    int n = s.length();
    if (n <= k) {
      return n;
    }

    Map<Character, Integer> hashMap = new HashMap<>();
    int currentLength = 0, maxLength = 0, startIndex = 0;
    for (int i = 0; i < n; i++) {
      Character ch = s.charAt(i);

      if (!hashMap.containsKey(ch) && hashMap.size() == k) {
        while (hashMap.size() == k && startIndex < i) {
          Character startCh = s.charAt(startIndex);
          if (hashMap.get(startCh) == 1) {
            hashMap.remove(startCh);
          } else {
            hashMap.put(startCh, hashMap.get(startCh) - 1);
          }
          currentLength--;
          startIndex++;
        }
      }

      hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
      maxLength = Math.max(++currentLength, maxLength);
    }

    return maxLength;
  }
}

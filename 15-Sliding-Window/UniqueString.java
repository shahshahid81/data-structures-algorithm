import java.util.HashSet;

public class UniqueString {

  public int lengthOfLongestSubstring(String str) {
    int n = str.length();
    if (n == 0) {
      return 0;
    }

    int max = 1, start = 0;
    HashSet<Character> hashSet = new HashSet<>();

    for (int i = 0; i < n; i++) {
      while (hashSet.contains(str.charAt(i))) {
        hashSet.remove(str.charAt(start++));
      }
      hashSet.add(str.charAt(i));
      max = Math.max(hashSet.size(), max);
    }

    return max;
  }
}

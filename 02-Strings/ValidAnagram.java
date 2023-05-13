import java.util.HashMap;

public class ValidAnagram {

  public boolean isAnagram(String str1, String str2) {
    int str1Length = str1.length(), str2Length = str2.length();
    if (str1Length != str2Length || str1Length == 0) return false;
    HashMap<Character, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < str1Length; i++) {
      char ch = str1.charAt(i);
      hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < str2Length; i++) {
      char ch = str2.charAt(i);
      if (!hashMap.containsKey(ch)) return false;
      int value = hashMap.get(ch);
      if (value == 0) return false;
      hashMap.put(ch, value - 1);
    }

    return true;
  }
}

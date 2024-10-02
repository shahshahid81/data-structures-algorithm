import java.util.HashMap;

public class FirstUniqueCharacter {

  public int firstNonRepeatingCharacterIndex(String str) {
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int n = str.length();
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if (hashMap.get(ch) == 1) return i;
    }
    return -1;
  }

  public char firstNonRepeatingCharacter(String str) {
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int n = str.length();
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if (hashMap.get(ch) == 1) return ch;
    }
    return str.charAt(0);
  }
}

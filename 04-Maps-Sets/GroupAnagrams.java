import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {

  private static String generateKey(String str) {
    char[] temp = new char[26];
    for (char ch : str.toCharArray()) temp[ch - 'a']++;
    return new String(temp);
  }

  public static ArrayList<ArrayList<String>> getGroupedAnagrams(
    ArrayList<String> inputStr,
    int n
  ) {
    HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

    for (String str : inputStr) {
      String sorted = generateKey(str);
      if (!hashMap.containsKey(sorted)) {
        hashMap.put(sorted, new ArrayList<String>());
      }
      hashMap.get(sorted).add(str);
    }

    return new ArrayList<>(hashMap.values());
  }
}

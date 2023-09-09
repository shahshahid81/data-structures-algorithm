import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramSubstringSearch {

  public List<Integer> findAnagrams(String s, String p) {
    int n = s.length(), m = p.length();
    ArrayList<Integer> indexes = new ArrayList<>();

    if (m > n) {
      return indexes;
    }

    HashMap<Character, Integer> pMap = new HashMap<>();
    HashMap<Character, Integer> sMap = new HashMap<>();
    for (int i = 0; i < m; i++) {
      pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    if (sMap.equals(pMap)) {
      indexes.add(0);
    }

    for (int i = m; i < n; i++) {
      char startCh = s.charAt(i - m);
      if (sMap.get(startCh) == 1) {
        sMap.remove(startCh);
      } else {
        sMap.put(startCh, sMap.get(startCh) - 1);
      }

      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
      if (sMap.equals(pMap)) {
        indexes.add(i + 1 - m);
      }
    }

    return indexes;
  }
}

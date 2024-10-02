import java.util.ArrayList;

public class SubSequencesOfString {

  public static ArrayList<String> subsequences(String str) {
    StringBuilder currentString = new StringBuilder();
    ArrayList<String> list = new ArrayList<>();

    subsequences(str, str.length(), 0, currentString, list);

    return list;
  }

  private static void subsequences(
    String str,
    int n,
    int index,
    StringBuilder currentString,
    ArrayList<String> list
  ) {
    if (index >= n) {
      return;
    }

    for (int i = index; i < n; i++) {
      currentString.append(str.charAt(i));
      list.add(currentString.toString());
      subsequences(str, n, ++index, currentString, list);
      currentString.deleteCharAt(currentString.length() - 1);
    }
  }
}

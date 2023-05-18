public class IsSubSequence {

  private int indexOf(String str, char ch, int startIndex) {
    int n = str.length();

    for (int i = startIndex; i < n; i++) {
      if (str.charAt(i) == ch) return i;
    }
    return -1;
  }

  public String isSubsequence(String str1, String str2) {
    int s1Length = str1.length(), s2Length = str2.length();
    int i = 0, j = 0;
    while (i < s1Length && j < s2Length) {
      int index = indexOf(str2, str1.charAt(i), j);
      if (index == -1) return "False";
      i++;
      j = index + 1;
    }
    return i >= s1Length ? "True" : "False";
  }
}

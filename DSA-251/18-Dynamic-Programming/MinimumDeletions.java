public class MinimumDeletions {

  public static int minDeletions(String str) {
    int occurences = 0;
    for (char c : str.toCharArray()) {
      if (c == 'a') occurences++;
    }

    int ans = occurences;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'a') {
        occurences--;
      } else {
        occurences++;
      }
      ans = Math.min(ans, occurences);
    }

    return ans;
  }
}

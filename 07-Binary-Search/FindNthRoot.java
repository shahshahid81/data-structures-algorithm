public class FindNthRoot {

  public static int NthRoot(int n, int m) {
    int low = 1, high = m;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      double nRoot = Math.pow(mid, n);
      if (nRoot == (double) m) {
        return mid;
      } else if (nRoot > m) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }
}

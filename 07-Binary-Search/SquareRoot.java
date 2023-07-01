public class SquareRoot {

  public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
    int low = 2, high = x;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (mid * mid <= x) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low - 1;
  }
}

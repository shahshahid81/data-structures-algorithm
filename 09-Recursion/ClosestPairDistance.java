import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class point {

  int x;
  int y;

  point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class ClosestPairDistance {

  public static long closestPair(point P[], int n) {
    point[] Px = Arrays.copyOf(P, n);
    Arrays.sort(Px, (p1, p2) -> p1.x - p2.x);
    point[] Py = Arrays.copyOf(P, n);
    Arrays.sort(Py, (p1, p2) -> p1.y - p2.y);

    return closestUtil(Px, Py, n);
  }

  private static long closestUtil(point[] Px, point[] Py, int n) {
    if (n <= 3) {
      return bruteForce(Px, n);
    }

    int mid = n / 2;
    point midpoint = Px[mid];

    point[] Pyl = Arrays.copyOfRange(Py, 0, mid);
    point[] Pyr = Arrays.copyOfRange(Py, mid, n);

    long dl = closestUtil(Px, Pyl, mid);
    long dr = closestUtil(Arrays.copyOfRange(Px, mid, n), Pyr, n - mid);

    long d = Math.min(dl, dr);

    List<point> strip = new ArrayList<point>();
    for (point p : Py) {
      if (Math.abs(p.x - midpoint.x) < d) {
        strip.add(p);
      }
    }

    return stripClosest(
      strip.toArray(new point[strip.size()]),
      strip.size(),
      d
    );
  }

  private static long bruteForce(point[] P, int n) {
    long min = Long.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        long dist = distance(P[i], P[j]);
        if (dist < min) {
          min = dist;
        }
      }
    }
    return min;
  }

  private static long stripClosest(point[] strip, int size, long d) {
    long min = d;

    for (int i = 0; i < size; ++i) {
      for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
        long dist = distance(strip[i], strip[j]);
        if (dist < min) {
          min = dist;
        }
      }
    }
    return min;
  }

  private static long distance(point p1, point p2) {
    return (long) Math.pow(p1.x - p2.x, 2) + (long) Math.pow(p1.y - p2.y, 2);
  }
}

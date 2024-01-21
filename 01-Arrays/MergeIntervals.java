import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {

  int start;
  int end;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class IntervalComparator implements Comparator<Interval> {

  public int compare(Interval first, Interval second) {
    if (first.start == second.start) {
      return first.end - second.end;
    }
    return first.start - second.start;
  }
}

public class MergeIntervals {

  public static ArrayList<Interval> mergeIntervals(
    ArrayList<Interval> intervals
  ) {
    ArrayList<Interval> result = new ArrayList<>();
    Collections.sort(intervals, new IntervalComparator());

    int n = intervals.size();
    for (int i = 0; i < n; i++) {
      int m = result.size();
      Interval interval = intervals.get(i);
      if (m == 0 || interval.start > result.get(m - 1).end) {
        result.add(new Interval(interval.start, interval.end));
      } else {
        result.get(m - 1).end = Math.max(result.get(m - 1).end, interval.end);
      }
    }

    return result;
  }
}

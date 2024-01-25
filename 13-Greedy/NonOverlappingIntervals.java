import java.util.Arrays;

public class NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

    int answer = -1;
    int[] previous = intervals[0];

    for (int[] interval : intervals) {
      if (previous[1] > interval[0]) {
        answer++;
      } else {
        previous = interval;
      }
    }

    return answer;
  }
}

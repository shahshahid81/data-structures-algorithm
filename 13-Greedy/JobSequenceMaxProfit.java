import java.util.Arrays;

public class JobSequenceMaxProfit {

  public static int[] jobScheduling(int[][] jobs) {
    Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

    int n = jobs.length;
    int[] deadlines = new int[n];
    for (int i = 0; i < n; i++) {
      int value = jobs[i][2], deadline = jobs[i][1];
      while (deadline - 1 >= 0) {
        if (deadlines[deadline - 1] == 0) {
          deadlines[deadline - 1] = value;
          break;
        }
        deadline--;
      }
    }

    int numberOfJobs = 0, totalProfit = 0;
    for (int i = 0; i < n; i++) {
      if (deadlines[i] != 0) {
        numberOfJobs++;
        totalProfit += deadlines[i];
      }
    }

    return new int[] { numberOfJobs, totalProfit };
  }
}

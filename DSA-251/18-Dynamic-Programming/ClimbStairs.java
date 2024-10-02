public class ClimbStairs {

  public int climbStairs(int n) {
    if (n <= 1) {
      return 1;
    }

    int firstStep = 1, secondStep = 2, finalStep = 2, MOD = 1000000007;
    for (int i = 2; i < n; i++) {
      finalStep = (firstStep + secondStep) % MOD;
      firstStep = secondStep;
      secondStep = finalStep;
    }
    return finalStep;
  }

  public static int countDistinctWayToClimbStair(long nStairs) {
    int n = (int) nStairs;
    if (n <= 1) {
      return 1;
    }

    int firstStep = 1, secondStep = 2, finalStep = 2, MOD = 1000000007;
    for (int i = 2; i < n; i++) {
      finalStep = (firstStep + secondStep) % MOD;
      firstStep = secondStep;
      secondStep = finalStep;
    }
    return finalStep;
  }
}

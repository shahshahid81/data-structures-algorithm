// https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/

import java.util.Arrays;

class FrogJumpRecursion {

  public static int frogJump(int n, int heights[]) {
    return frogJump(n, heights, 0);
  }

  private static int frogJump(int n, int heights[], int currentStep) {
    if (currentStep >= n || currentStep + 1 >= n) {
      return 0;
    }

    int oneStepEnergy =
      Math.abs(heights[currentStep + 1] - heights[currentStep]) +
      frogJump(n, heights, currentStep + 1);

    int twoStepEnergy = Integer.MAX_VALUE;
    if (currentStep + 2 < n) {
      twoStepEnergy =
        Math.abs(heights[currentStep + 2] - heights[currentStep]) +
        frogJump(n, heights, currentStep + 2);
    }

    return Math.min(oneStepEnergy, twoStepEnergy);
  }
}

class FrogJumpRecursionMemoization {

  public static int frogJump(int n, int heights[]) {
    // Memoized Code Start
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    // Memoized Code End

    return frogJump(
      n,
      heights,
      0,
      // Memoized Code Start
      dp
      // Memoized Code End
    );
  }

  private static int frogJump(int n, int heights[], int currentStep, int[] dp) {
    if (currentStep >= n || currentStep + 1 >= n) {
      return 0;
    }

    // Memoized Code Start
    if (dp[currentStep] != -1) {
      return dp[currentStep];
    }
    // Memoized Code End

    int oneStepEnergy =
      Math.abs(heights[currentStep + 1] - heights[currentStep]) +
      frogJump(n, heights, currentStep + 1, dp);

    int twoStepEnergy = Integer.MAX_VALUE;
    if (currentStep + 2 < n) {
      twoStepEnergy =
        Math.abs(heights[currentStep + 2] - heights[currentStep]) +
        frogJump(n, heights, currentStep + 2, dp);
    }

    // Memoized Code Start
    dp[currentStep] = Math.min(oneStepEnergy, twoStepEnergy);
    // Memoized Code End

    return dp[currentStep];
  }
}

class FrogJumpTabulation {

  public static int frogJump(int n, int heights[]) {
    int[] dp = new int[n];

    for (int currentStep = 1; currentStep < n; currentStep++) {
      int oneStepEnergy =
        Math.abs(heights[currentStep] - heights[currentStep - 1]) +
        dp[currentStep - 1];

      int twoStepEnergy = Integer.MAX_VALUE;
      if (currentStep > 1) {
        twoStepEnergy =
          Math.abs(heights[currentStep] - heights[currentStep - 2]) +
          dp[currentStep - 2];
      }

      dp[currentStep] = Math.min(oneStepEnergy, twoStepEnergy);
    }

    return dp[n - 1];
  }
}

class FrogJumpTabulationSpaceOptimized {

  public static int frogJump(int n, int heights[]) {
    int previousOneStep = 0, previousTwoStep = 0;

    for (int currentStep = 1; currentStep < n; currentStep++) {
      int oneStepEnergy =
        Math.abs(heights[currentStep] - heights[currentStep - 1]) +
        previousOneStep;

      int twoStepEnergy = Integer.MAX_VALUE;
      if (currentStep > 1) {
        twoStepEnergy =
          Math.abs(heights[currentStep] - heights[currentStep - 2]) +
          previousTwoStep;
      }

      previousTwoStep = previousOneStep;
      previousOneStep = Math.min(oneStepEnergy, twoStepEnergy);
    }

    return previousOneStep;
  }
}

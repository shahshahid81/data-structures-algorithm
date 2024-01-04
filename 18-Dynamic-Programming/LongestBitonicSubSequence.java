import java.util.Arrays;

public class LongestBitonicSubSequence {

  public static int longestBitonicSequence(int[] arr, int n) {
    int[] longestIncreasingSubSequence = new int[n];
    int[] longestDecreasingSubSequence = new int[n];

    for (int i = 0; i < n; i++) {
      longestIncreasingSubSequence[i] = 1;

      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          longestIncreasingSubSequence[i] =
            Math.max(
              longestIncreasingSubSequence[i],
              longestIncreasingSubSequence[j] + 1
            );
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      longestDecreasingSubSequence[i] = 1;

      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          longestDecreasingSubSequence[i] =
            Math.max(
              longestDecreasingSubSequence[i],
              longestDecreasingSubSequence[j] + 1
            );
        }
      }
    }

    int maxLength = 0;

    for (int i = 0; i < n; i++) {
      maxLength =
        Math.max(
          maxLength,
          longestDecreasingSubSequence[i] + longestIncreasingSubSequence[i] - 1
        );
    }

    return maxLength;
  }
}

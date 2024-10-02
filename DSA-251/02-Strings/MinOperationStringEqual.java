public class MinOperationStringEqual {

  public int minimumOperations(String a, String b) {
    if (a.length() != b.length()) {
      return -1;
    }

    int n = a.length(), numberOfProcess = 0;

    for (int i = 0; i < n / 2; i++) {
      int rightIndex = n - 1 - i;

      if (
        (
          a.charAt(i) == b.charAt(i) &&
          a.charAt(rightIndex) == b.charAt(rightIndex)
        ) ||
        (
          a.charAt(i) == b.charAt(rightIndex) &&
          b.charAt(i) == a.charAt(rightIndex)
        ) ||
        (
          a.charAt(i) == a.charAt(rightIndex) &&
          b.charAt(i) == b.charAt(rightIndex)
        )
      ) {
        continue;
      }

      if (
        a.charAt(i) == b.charAt(i) ||
        a.charAt(i) == b.charAt(rightIndex) ||
        a.charAt(rightIndex) == b.charAt(i) ||
        a.charAt(rightIndex) == b.charAt(rightIndex) ||
        b.charAt(i) == b.charAt(rightIndex)
      ) {
        numberOfProcess++;
      } else {
        numberOfProcess += 2;
      }
    }

    if (n % 2 == 1 && a.charAt(n / 2) != b.charAt(n / 2)) {
      numberOfProcess++;
    }

    return numberOfProcess;
  }
}

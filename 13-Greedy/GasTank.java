public class GasTank {

  public static int startingPoint(int[] gas, int[] cost, int n) {
    if (gas.length != cost.length) {
      return -1;
    }

    int currentGas = 0, totalGas = 0, minIndex = 0;
    for (int i = 0; i < gas.length; i++) {
      currentGas += gas[i] - cost[i];
      totalGas += gas[i] - cost[i];
      if (currentGas < 0) {
        currentGas = 0;
        minIndex = i + 1;
      }
    }

    return totalGas < 0 ? -1 : minIndex;
  }
}

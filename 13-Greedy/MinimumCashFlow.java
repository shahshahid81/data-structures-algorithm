import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumCashFlow {

  public static int minCashFlow(ArrayList<ArrayList<Integer>> money, int n) {
    int[] balance = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        balance[j] += money.get(i).get(j);
        balance[i] -= money.get(i).get(j);
      }
    }

    // Using map and set as a multiset.
    Map<Integer, Integer> transitMap = new HashMap<Integer, Integer>();
    Set<Integer> transitSet = new HashSet<Integer>();

    for (int i = 0; i < n; i++) {
      // If value already exist in map then add 1 to the previous value.
      if (transitMap.containsKey(balance[i])) {
        transitMap.put(balance[i], transitMap.get(balance[i]) + 1);
      } else {
        transitMap.put(balance[i], 1);
        // Insert the value in the set.
        transitSet.add(balance[i]);
      }
    }

    int cashFlow = 0;
    int smallestElement = Collections.min(transitSet);

    // If smallest element in our set is 0 then we break.
    while (smallestElement != 0) {
      int maxDebt = Collections.max(transitSet);
      int minDebt = Collections.min(transitSet);
      smallestElement = Collections.min(transitSet);
      cashFlow += Math.min(Math.abs(maxDebt), Math.abs(minDebt));

      transitMap.put(maxDebt, transitMap.get(maxDebt) - 1);
      transitMap.put(minDebt, transitMap.get(minDebt) - 1);

      if (transitMap.get(maxDebt) == 0) {
        transitSet.remove(maxDebt);
      }

      if (transitMap.get(minDebt) == 0) {
        transitSet.remove(minDebt);
      }

      maxDebt += Math.min(Math.abs(maxDebt), minDebt);
      minDebt -= Math.min(Math.abs(maxDebt), minDebt);

      if (transitMap.containsKey(maxDebt)) {
        transitMap.put(maxDebt, transitMap.get(maxDebt) + 1);
      } else {
        transitMap.put(maxDebt, 1);
      }

      if (transitMap.containsKey(minDebt)) {
        transitMap.put(minDebt, transitMap.get(minDebt) + 1);
      } else {
        transitMap.put(minDebt, 1);
      }

      if (transitMap.get(maxDebt) > 0) {
        transitSet.add(maxDebt);
      }

      if (transitMap.get(minDebt) > 0) {
        transitSet.add(minDebt);
      }
    }

    return cashFlow;
  }
}

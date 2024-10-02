public class AllocateWeightToShip {

  public int shipWithinDays(int[] weights, int days) {
    int sum = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < weights.length; i++) {
      sum += weights[i];
      max = Math.max(max, weights[i]);
    }

    int low = max, high = sum, answer = sum;

    while (low <= high) {
      int mid = (low + high) / 2;
      int numberOfDays = 1;
      int currentWeight = 0;

      for (int i = 0; i < weights.length; i++) {
        currentWeight += weights[i];
        if (currentWeight > mid) {
          numberOfDays++;
          currentWeight = weights[i];
        }
      }

      if (numberOfDays <= days) {
        answer = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return answer;
  }
}

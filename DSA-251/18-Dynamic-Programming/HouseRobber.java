public class HouseRobber {

  public int rob(int[] nums) {
    int n = nums.length;

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return nums[0];
    }

    int[] maxRob = new int[n];
    maxRob[n - 1] = nums[n - 1];
    maxRob[n - 2] = Math.max(nums[n - 2], maxRob[n - 1]);

    int[] currentRob = new int[n];
    currentRob[n - 1] = nums[n - 1];
    currentRob[n - 2] = nums[n - 2];

    for (int i = n - 3; i >= 0; i--) {
      currentRob[i] = nums[i] + maxRob[i + 2];
      maxRob[i] = Math.max(currentRob[i], maxRob[i + 1]);
    }

    return maxRob[0];
  }
}

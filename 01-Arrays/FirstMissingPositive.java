public class FirstMissingPositive {

  public static int firstMissing(int[] nums, int n) {
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0) {
        nums[i] = n + 1;
      }
    }

    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num > 0 && num <= n) {
        nums[num - 1] = -Math.abs(nums[num - 1]);
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) return i + 1;
    }
    return n + 1;
  }
}

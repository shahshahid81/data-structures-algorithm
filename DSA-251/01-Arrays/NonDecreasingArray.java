public class NonDecreasingArray {

  public boolean isPossible(int[] nums) {
    int numberOfChanges = 0, changeIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        numberOfChanges++;
        changeIndex = i;
      }
    }
    if (numberOfChanges > 1) {
      return false;
    }
    if (numberOfChanges == 0) {
      return true;
    }
    if (changeIndex == 1 || changeIndex == nums.length - 1) {
      return true;
    }
    if (
      nums[changeIndex + 1] < nums[changeIndex - 1] &&
      nums[changeIndex] < nums[changeIndex - 2]
    ) {
      return false;
    }
    return true;
  }
}

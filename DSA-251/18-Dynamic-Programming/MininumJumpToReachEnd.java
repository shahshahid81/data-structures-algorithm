public class MininumJumpToReachEnd {

  public int jump(int[] nums) {
    int jumps = 0, startPoint = 0, endPoint = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      endPoint = Math.max(endPoint, i + nums[i]);
      if (i == startPoint) {
        startPoint = endPoint;
        jumps++;
      }
    }
    return jumps;
  }
}

public class ContainerWithMostWater {

  public static int maxArea(int[] height) {
    int i = 0, j = height.length - 1, maxArea = 0;
    while (i < j) {
      maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
      if (height[i] >= height[j]) j--; else i++;
    }

    return maxArea;
  }
}

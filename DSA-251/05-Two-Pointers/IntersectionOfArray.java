import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfArray {

  public ArrayList<Integer> findSortedArrayIntersection(
    ArrayList<Integer> arr1,
    ArrayList<Integer> arr2
  ) {
    ArrayList<Integer> result = new ArrayList<>();
    int n1 = arr1.size(), n2 = arr2.size();
    if (arr1.get(n1 - 1) < arr2.get(0)) return result;
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (arr1.get(i) == arr2.get(j)) {
        result.add(arr1.get(i));
        i++;
        j++;
      } else if (arr1.get(i) < arr2.get(j)) i++; else j++;
    }
    return result;
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    if (nums1[nums1.length - 1] < nums2[0]) return new int[] {};
    int[] result = new int[Math.max(nums1.length, nums2.length)];
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
      if (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) i++;
      if (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) j++;

      if (nums1[i] == nums2[j]) {
        if (k - 1 < 0 || result[k - 1] != nums1[i]) {
          result[k++] = nums1[i];
        }
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }

    return k == 0 ? new int[] {} : Arrays.copyOfRange(result, 0, k);
  }
}

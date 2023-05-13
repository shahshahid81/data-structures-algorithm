import java.util.ArrayList;

public class MajorityElement2 {

  public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
    ArrayList<Integer> result = new ArrayList<>();
    int n = arr.size();

    int majorityElementOne = Integer.MIN_VALUE, countOne = 0;
    int majorityElementTwo = Integer.MIN_VALUE, countTwo = 0;

    for (int i = 0; i < n; i++) {
      int element = arr.get(i);

      if (element == majorityElementOne) {
        countOne++;
      } else if (element == majorityElementTwo) {
        countTwo++;
      } else if (countOne != 0 && countTwo != 0) {
        countOne--;
        countTwo--;
      } else if (countOne == 0) {
        majorityElementOne = element;
        countOne = 1;
      } else if (countTwo == 0) {
        majorityElementTwo = element;
        countTwo = 1;
      }
    }

    countOne = 0;
    countTwo = 0;
    for (Integer element : arr) {
      if (element == majorityElementOne) {
        countOne++;
      } else if (element == majorityElementTwo) {
        countTwo++;
      }
    }

    double majoritySize = Math.floor(n / 3);
    if (countOne > majoritySize) {
      result.add(majorityElementOne);
    }
    if (countTwo > majoritySize) {
      result.add(majorityElementTwo);
    }

    return result;
  }
}

import java.util.Arrays;

class Pair {

  int weight;
  int value;

  Pair(int weight, int value) {
    this.weight = weight;
    this.value = value;
  }
}

class Ratio {

  int index;
  double value;

  Ratio(int index, double value) {
    this.index = index;
    this.value = value;
  }
}

public class FractionalKnapsack {

  public static double maximumValue(Pair[] items, int n, int w) {
    Ratio[] ratio = new Ratio[items.length];
    for (int i = 0; i < items.length; i++) {
      ratio[i] = new Ratio(i, (items[i].weight * 1.0) / items[i].value);
    }

    Arrays.sort(ratio, (r1, r2) -> Double.compare(r1.value, r2.value));

    double max = 0.0;
    for (int i = 0; i < ratio.length && w != 0; i++) {
      Pair item = items[ratio[i].index];
      if (item.weight <= w) {
        max += item.value;
        w -= item.weight;
      } else {
        double val = (w * 1.0 / item.weight) * item.value;
        max += val;
        w = 0;
      }
    }
    return max;
  }
}

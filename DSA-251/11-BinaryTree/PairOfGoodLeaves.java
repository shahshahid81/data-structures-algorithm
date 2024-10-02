public class PairOfGoodLeaves {

  int count;

  public int countPairs(TreeNode root, int distance) {
    count = 0;
    countPairsHelper(root, distance);
    return count;
  }

  public List<Integer> countPairsHelper(TreeNode root, int distance) {
    if (root == null) {
      return new ArrayList<Integer>();
    }

    if (root.left == null && root.right == null) {
      List<Integer> sublist = new ArrayList<Integer>();
      sublist.add(1);
      return sublist;
    }

    List<Integer> leftDistanceList = countPairsHelper(root.left, distance);
    List<Integer> rightDistanceList = countPairsHelper(root.right, distance);

    for (int left : leftDistanceList) {
      for (int right : rightDistanceList) {
        if (left + right <= distance) {
          count++;
        }
      }
    }

    List<Integer> list = new ArrayList<Integer>();
    for (int leftDistance : leftDistanceList) {
      list.add(leftDistance + 1);
    }
    for (int rightDistance : rightDistanceList) {
      list.add(rightDistance + 1);
    }
    return list;
  }
}

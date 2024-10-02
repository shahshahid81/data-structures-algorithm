public class FamilyTree {

  public String kthChildNthGeneration(int n, long k) {
    if (n == 1) {
      return "Male";
    }

    String parent = kthChildNthGeneration(n - 1, (k + 1) / 2);

    boolean isFirstChild = k % 2 != 0;
    if (parent.equals("Male")) {
      return isFirstChild ? "Male" : "Female";
    }

    return isFirstChild ? "Female" : "Male";
  }
}

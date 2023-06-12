public class FamilyTree {

  public String kthChildNthGeneration(int n, long k) {
    if (n == 1 && k == 1) {
      return "Male";
    }

    long parent = (long) Math.floor((k + 1) / 2);
    String parentGender = kthChildNthGeneration(n - 1, parent);
    boolean isFirstChild = k % 2 != 0;
    return isFirstChild
      ? parentGender.equals("Male") ? "Male" : "Female"
      : parentGender.equals("Male") ? "Female" : "Male";
  }
}

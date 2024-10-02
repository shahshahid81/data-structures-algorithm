class Node {

  Node keys[] = new Node[26];
  int prefixCount = 0;
  int endCount = 0;

  boolean containsKey(char ch) {
    return keys[ch - 'a'] != null;
  }

  void put(char ch, Node temp) {
    keys[ch - 'a'] = temp;
  }

  Node get(char a) {
    return keys[a - 'a'];
  }

  void incrementPrefixCount() {
    prefixCount++;
  }

  void incrementEndCount() {
    endCount++;
  }

  void decrementPrefixCount() {
    prefixCount--;
  }

  void decrementEndCount() {
    endCount--;
  }

  int getPrefixCount() {
    return prefixCount;
  }

  int getEndCount() {
    return endCount;
  }
}

public class TrieWithDelete {

  static Node root;

  public TrieWithDelete() {
    root = new Node();
  }

  public void insert(String word) {
    Node temp = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!temp.containsKey(ch)) {
        temp.put(ch, new Node());
      }
      temp = temp.get(ch);
      temp.incrementPrefixCount();
    }
    temp.incrementEndCount();
  }

  public int countWordsEqualTo(String word) {
    Node temp = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);

      if (temp.containsKey(ch)) {
        temp = temp.get(ch);
      } else {
        return 0;
      }
    }

    return temp.getEndCount();
  }

  public int countWordsStartingWith(String word) {
    Node temp = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);

      if (temp.containsKey(ch)) {
        temp = temp.get(ch);
      } else {
        return 0;
      }
    }

    return temp.getPrefixCount();
  }

  public void erase(String word) {
    Node temp = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      temp = temp.get(ch);
      temp.decrementPrefixCount();
    }
    temp.decrementEndCount();
  }
}

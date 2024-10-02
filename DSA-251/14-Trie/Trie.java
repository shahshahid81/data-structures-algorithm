class TrieNode {

  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

public class Trie {

  static TrieNode root;

  public static void insert(String word) {
    root = insert(word.toCharArray(), 0, root);
  }

  private static TrieNode insert(char[] word, int index, TrieNode root) {
    if (index >= word.length || index < 0) {
      return root;
    }

    if (root == null) {
      root = new TrieNode();
    }

    int insertionIndex = word[index] - 'a';
    if (root.children[insertionIndex] == null) {
      root.children[insertionIndex] = new TrieNode();
    }

    if (index == word.length - 1) {
      root.children[insertionIndex].isEnd = true;
    } else {
      root.children[insertionIndex] =
        insert(word, ++index, root.children[insertionIndex]);
    }
    return root;
  }

  public static boolean search(String word) {
    return search(word, word.length(), 0, root);
  }

  private static boolean search(String word, int n, int index, TrieNode root) {
    if (index >= n || index < 0) {
      return false;
    }

    int searchIndex = word.charAt(index) - 'a';
    if (root == null || root.children[searchIndex] == null) {
      return false;
    }

    if (index == n - 1) {
      return root.children[searchIndex].isEnd;
    } else {
      return search(word, n, ++index, root.children[searchIndex]);
    }
  }

  public static boolean startsWith(String prefix) {
    return startsWith(prefix, prefix.length(), 0, root);
  }

  private static boolean startsWith(
    String prefix,
    int n,
    int index,
    TrieNode root
  ) {
    if (index >= n || index < 0) {
      return false;
    }

    int searchIndex = prefix.charAt(index) - 'a';
    if (root == null || root.children[searchIndex] == null) {
      return false;
    }

    if (index == n - 1) {
      for (int i = 0; i < root.children[searchIndex].children.length; i++) {
        if (root.children[searchIndex].children[i] != null) {
          return true;
        }
      }
      return root.children[searchIndex].isEnd;
    } else {
      return startsWith(prefix, n, ++index, root.children[searchIndex]);
    }
  }
}

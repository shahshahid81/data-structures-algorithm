class TrieNode {

  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

class Trie {

  TrieNode root;
  int total;

  public void insert(String word) {
    root = insert(word.toCharArray(), 0, root);
  }

  private TrieNode insert(char[] word, int index, TrieNode root) {
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

    if (index == word.length - 1 && !root.children[insertionIndex].isEnd) {
      total++;
      root.children[insertionIndex].isEnd = true;
    } else {
      root.children[insertionIndex] =
        insert(word, ++index, root.children[insertionIndex]);
    }
    return root;
  }
}

public class CountDistinctSubString {

  public static int distinctSubstring(String word) {
    Trie trie = new Trie();
    int n = word.length();
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < n; j++) {
        sb.append(word.charAt(j));
        trie.insert(sb.toString());
      }
    }
    return trie.total;
  }
}

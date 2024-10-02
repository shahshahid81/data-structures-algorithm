import java.util.ArrayList;
import java.util.HashSet;

class TrieNode {

  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

class Trie {

  TrieNode root;

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

    if (index == word.length - 1) {
      root.children[insertionIndex].isEnd = true;
    } else {
      root.children[insertionIndex] =
        insert(word, ++index, root.children[insertionIndex]);
    }
    return root;
  }

  public boolean search(String word) {
    return search(word, word.length(), 0, root);
  }

  private boolean search(String word, int n, int index, TrieNode root) {
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

  public ArrayList<String> startsWith(String prefix) {
    ArrayList<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    startsWith(prefix, prefix.length(), 0, root, result, sb);
    return result;
  }

  private void startsWith(
    String prefix,
    int n,
    int index,
    TrieNode root,
    ArrayList<String> result,
    StringBuilder sb
  ) {
    if (root == null) {
      return;
    }

    if (index < 0 || index >= n) {
      getAllWordsWithPrefix(root, result, sb);
      return;
    }

    int searchIndex = prefix.charAt(index) - 'a';
    if (root.children[searchIndex] != null) {
      sb.append(prefix.charAt(index));
      startsWith(prefix, n, ++index, root.children[searchIndex], result, sb);
    } else {
      getAllWordsWithPrefix(root, result, sb);
    }
  }

  private void getAllWordsWithPrefix(
    TrieNode root,
    ArrayList<String> result,
    StringBuilder sb
  ) {
    if (root == null) {
      return;
    }

    if (root.isEnd) {
      result.add(sb.toString());
      return;
    }

    for (int i = 0; i < root.children.length; i++) {
      if (root.children[i] == null) {
        continue;
      }

      sb.append((char) ('a' + i));
      if (!root.children[i].isEnd) {
        getAllWordsWithPrefix(root.children[i], result, sb);
      } else {
        result.add(sb.toString());
      }
      sb.setLength(Math.max(sb.length() - 1, 0));
    }
  }
}

public class SpellCheck {

  public static ArrayList<String> spellChecker(
    ArrayList<String> dictionary,
    String query
  ) {
    Trie trie = new Trie();
    ArrayList<String> words = new ArrayList<>(new HashSet<>(dictionary));
    for (String word : words) {
      trie.insert(word);
    }

    if (trie.search(query)) {
      return new ArrayList<>();
    } else {
      ArrayList<String> result = trie.startsWith(query);
      return result.size() == 0 ? words : result;
    }
  }
}

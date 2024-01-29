import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

class Trie {

  private class TrieNode {

    int endCount;
    HashMap<Character, TrieNode> children;

    TrieNode() {
      endCount = 0;
      children = new HashMap<>();
    }
  }

  TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    if (word.length() == 0) {
      return;
    }
    insert(word, 0, root);
  }

  public boolean search(String word) {
    if (word.length() == 0) {
      return false;
    }
    return search(word, 0, root);
  }

  public boolean startsWith(String prefix) {
    if (prefix.length() == 0) {
      return false;
    }
    return startsWith(prefix, 0, root);
  }

  private void insert(String word, int index, TrieNode root) {
    if (root == null) {
      root = new TrieNode();
    }

    char ch = word.charAt(index);

    if (!root.children.containsKey(ch)) {
      root.children.put(ch, new TrieNode());
    }

    TrieNode node = root.children.get(ch);
    if (index + 1 == word.length()) {
      node.endCount++;
    } else {
      insert(word, index + 1, node);
    }
  }

  private boolean startsWith(String prefix, int index, TrieNode root) {
    char ch = prefix.charAt(index);
    if (!root.children.containsKey(ch)) {
      return false;
    }

    if (index + 1 == prefix.length()) {
      return true;
    }

    return startsWith(prefix, index + 1, root.children.get(ch));
  }

  private boolean search(String word, int index, TrieNode root) {
    char ch = word.charAt(index);
    if (!root.children.containsKey(ch)) {
      return false;
    }

    if (index + 1 == word.length()) {
      return root.children.get(ch).endCount >= 1;
    }

    return search(word, index + 1, root.children.get(ch));
  }
}

public class WordBreak2 {

  public List<String> wordBreak(String s, List<String> wordDict) {
    Trie trie = new Trie();
    for (String word : wordDict) {
      trie.insert(word);
    }

    Set<String> result = new HashSet<>();
    ArrayList<String> words = new ArrayList<>();

    wordBreak(s, trie, result, words, 0);
    return new ArrayList<>(result);
  }

  private void wordBreak(
    String s,
    Trie trie,
    Set<String> result,
    ArrayList<String> words,
    int index
  ) {
    if (index >= s.length()) {
      StringJoiner sj = new StringJoiner(" ");
      for (String word : words) {
        sj.add(word);
      }
      result.add(sj.toString());
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = index; i < s.length(); i++) {
      sb.append(s.charAt(i));
      String prefix = sb.toString();
      if (!trie.startsWith(prefix)) {
        return;
      }

      if (trie.search(prefix)) {
        ArrayList<String> newWords = new ArrayList<>();
        for (String word : words) {
          newWords.add(word);
        }
        newWords.add(prefix);
        wordBreak(s, trie, result, newWords, i + 1);
      }
    }
  }
}

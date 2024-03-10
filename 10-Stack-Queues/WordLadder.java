import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

  public int ladderLength(
    String beginWord,
    String endWord,
    List<String> wordList
  ) {
    Set<String> words = new HashSet<>();

    for (String word : wordList) {
      words.add(word);
    }

    if (!words.contains(endWord)) {
      return 0;
    }

    List<String> currTransformations = new ArrayList<>();
    currTransformations.add(beginWord);

    List<String> nextTransformations = null;
    int level = 1;

    while (!currTransformations.isEmpty()) {
      nextTransformations = new ArrayList<>();

      for (String word : currTransformations) {
        if (word.equals(endWord)) {
          return level;
        }

        nextTransformations.addAll(getNextTransformations(word, words));
      }

      currTransformations = nextTransformations;
      ++level;
    }

    return 0;
  }

  public List<String> getNextTransformations(String word, Set<String> words) {
    List<String> next = new ArrayList<>();
    int diff = 0;

    for (String w : words) {
      diff = 0;

      for (int i = 0; i < word.length(); ++i) {
        if (word.charAt(i) != w.charAt(i)) {
          ++diff;

          if (diff > 1) {
            break;
          }
        }
      }

      if (diff == 1) {
        next.add(w);
      }
    }

    words.removeAll(next);

    return next;
  }
}

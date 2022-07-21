package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.print.DocFlavor.STRING;

public final class WordCounter {

  private final Map<String, Integer> counts;

  public WordCounter(String text) {
    String[] words = splitWords(text);
    counts = Collections.unmodifiableMap(countWords(words)); // Using the Collection.unmodifiableMap decorator to restrict what the map can do. In this case, the map won't allow .put to modify the map
  }

  public Set<String> words() {
    return counts.keySet();
  }

  public int getCount(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return counts;
  }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase() // converts all text to lowercase
        .split("[\\W_]+"); // W = non-word char and _; + means 1 or more; and replace that all with a space char
  }

    Map<String, Integer> countWords(String[] words) {
      Map<String, Integer> counts = new HashMap<>();
      for (String word : words) {
        // DONE Check if word is already present as a key in counts:
        //  if it's not present, add it to counts with a value of 1;
        //  otherwise, get the current value, add 1 to it, and update the map with the value.
        if (!counts.containsKey(word)) {
          counts.put(word, 1);
        } else {
          int previousCount = counts.get(word);
          counts.put(word, previousCount + 1);
        }
      }
      return counts;
    }
}

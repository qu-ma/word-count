package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCounter {

  private final Map<String, Integer> counts = new HashMap<>();
  private int totalWords;

  public Set<String> words() {
    return counts.keySet();
  }

  public int get(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add (String text) {
    String trimmedLined = text.trim();
    if (!trimmedLined.isEmpty()) {
      String[] words = splitWords(trimmedLined);
      countWords(words);
    }
  }

  public int size() {
    return counts.size();
  }

  public int total() {
    return totalWords;
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

    void countWords(String[] words) {
      for (String word : words) {
        // DONE Check if word is already present as a key in counts:
        //  if it's not present, add it to counts with a value of 1;
        //  otherwise, get the current value, add 1 to it, and update the map with the value.
        counts.put(word, get(word) + 1);
        totalWords++;
      }
    }
}

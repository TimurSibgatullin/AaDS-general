package itis.grp403.TimurSibgatullin.HW2;

import java.util.*;

public class Task1 {
    public static Map<String, Integer> countWordOccurrences(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();
        StringBuilder word = new StringBuilder();
        int length = text.length();

        for (int i = 0; i <= length; i++) {
            char c = i < length ? text.charAt(i) : ' ';
            if (Character.isLetterOrDigit(c)) {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    String w = word.toString();
                    wordCounts.put(w, wordCounts.getOrDefault(w, 0) + 1);
                    word.setLength(0);
                }
            }
        }

        return wordCounts;
    }

    public static void main(String[] args) {
        String text = "яблоко яблоко яблока дом домик дом";
        Map<String, Integer> result = countWordOccurrences(text);
        System.out.println(result);
    }
}
package com.bernar.adventofcode2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {
    public static void main(String[] args) {
        List<String> words = FileInput.getInstance().readStringFromFile("input5.txt");
        System.out.println(words.stream().filter(Day5::isNice1).count());
        System.out.println(words.stream().filter(Day5::isNice2).count());
    }

    private static boolean isNice1(String word) {
        return threeVowels(word) && twoLettersInARow(word) && subSets(word);
    }

    private static boolean isNice2(String word) {
        return twoPairs(word) && sandwich(word);
    }

    private static boolean threeVowels(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count >= 3;
    }

    private static boolean twoLettersInARow(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean subSets(String word) {
        return (!word.contains("ab") && !word.contains("cd") && !word.contains("pq") && !word.contains("xy"));
    }

    private static boolean twoPairs(String word) {
        Map<String, List<Integer>> pairCounter = new HashMap<>();
        for (int i = 0; i < word.length() - 1; i++) {
            String sub = word.substring(i, i + 2);
            if (!pairCounter.containsKey(sub)) {
                List<Integer> initialList = new ArrayList<>();
                initialList.add(i);
                pairCounter.put(sub, initialList);
            } else {
                List<Integer> currentList = pairCounter.get(sub);
                currentList.add(i);
                pairCounter.put(sub, currentList);
            }
        }
        return pairCounter.values().stream().filter(pairValue -> pairValue.size() > 1)
                .anyMatch(Day5::pairsDifferMoreThanOne);

    }

    private static boolean pairsDifferMoreThanOne(List<Integer> list) {
        if (list.size() > 2) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) > 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean sandwich(String word) {
        for (int i = 0; i < word.length() - 2; i++) {
            if (word.charAt(i) == word.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

}

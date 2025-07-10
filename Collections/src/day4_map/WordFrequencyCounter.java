package day4_map;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String input ="Shoheb Pathan Shoheb";
        countWords(input);
    }

    public static void countWords(String text) {
        String[] words = text.split(" ");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        freqMap.forEach((k, v) -> System.out.println(k + " = " + v));
    }

}

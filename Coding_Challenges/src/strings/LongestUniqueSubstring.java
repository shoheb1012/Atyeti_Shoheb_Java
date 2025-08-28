package strings;

import java.util.HashSet;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring_HashSet(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0, maxLength = 0;
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (set.contains(currentChar)) {

                set.remove(s.charAt(j));
                j++;
            }

            set.add(currentChar);

            // Check if this is the longest so far
            if (i - j + 1 > maxLength) {
                maxLength = i - j + 1;
                longestSubstring = s.substring(j, i + 1); // Current window

            }
        }
        System.out.println("Longest substring: " + longestSubstring );

        return maxLength;

    }
    
    public static void main(String[] args) {
        int le = lengthOfLongestSubstring_HashSet("abcabcbb");
        System.out.println(le);
    }
}

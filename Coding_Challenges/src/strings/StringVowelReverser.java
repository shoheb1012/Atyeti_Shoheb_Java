package strings;

import java.util.*;

/*
Given a string s, reverse only the vowels of the string and return it.
Input: s = "hello" Output: "holle"
 */
public class StringVowelReverser {
//
    public static String reverseVowels(String input)
    {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        char[] charArray = input.toCharArray();

        for(char ch : charArray)
        {
            if(vowelSet.contains(ch))
            {
                stack.push(ch);
            }
        }

        for(char ch: charArray)
        {
            if(vowelSet.contains(ch))
            {
                result.append(stack.pop());
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the String");
            String input = sc.nextLine();
            String output = reverseVowels(input);
            System.out.println(output);
        }
    }
}

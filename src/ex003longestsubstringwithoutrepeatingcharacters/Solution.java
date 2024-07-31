package ex003longestsubstringwithoutrepeatingcharacters;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {"abcabcbb", "bbbbb", "pwwkew", " ", "12345678", "aabaab!bb", "bpfbhmipx"};
        for (String input : inputs) {
            solution.display(input, solution.longestSubstringWithoutRepeatingCharacters(input));
        }
    }

    public int longestSubstringWithoutRepeatingCharacters(String input) {
        int maxLength = 0, processedChars = 0;
        Map<Character, Integer> longestSubstring = new HashMap<>();
        char[] letters = input.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            Integer foundIndex = longestSubstring.get(letter);
            if (!Objects.isNull(foundIndex)) {
                maxLength = Math.max(maxLength, longestSubstring.size());
                for (int j = processedChars; j <= foundIndex; j++) {
                    longestSubstring.remove(letters[j]);
                }
                processedChars = foundIndex+1;
            }
            longestSubstring.put(letter, i);
        }
        return Math.max(maxLength, longestSubstring.size());
    }

    private void display(String input, int output) {
        System.out.println("input: " + input + " -> output: " + output);
    }
}

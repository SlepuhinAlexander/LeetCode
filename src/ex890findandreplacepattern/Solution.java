package ex890findandreplacepattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input1 = {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, input2 = {"a", "b", "c"};
        String pattern1 = "abb", pattern2 = "a";
        solution.display(input1, pattern1, solution.findAndReplacePattern(input1, pattern1));
        solution.display(input2, pattern1, solution.findAndReplacePattern(input2, pattern2));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return Arrays.stream(words).parallel().filter(word -> checkPattern(word, pattern)).collect(Collectors.toList());
    }

    private boolean checkPattern(String word, String pattern) {
        if (word == null || pattern == null || word.length() != pattern.length() || word.length() == 0) {
            return false;
        }
        Map<Character, Character> permutation = new HashMap<>();
        Map<Character, Character> reversePermutation = new HashMap<>();
        char wordChar, patChar;
        Character mutated, reversed;
        for (int i = 0; i < word.length(); i++) {
            wordChar = word.charAt(i);
            patChar = pattern.charAt(i);
            mutated = permutation.get(wordChar);
            reversed = reversePermutation.get(patChar);
            if (mutated != null && reversed != null)
                if (mutated != patChar || reversed != wordChar) {
                    return false;
                } else {
                    continue;
                }
            if (mutated == null && reversed == null) {
                permutation.put(wordChar, patChar);
                reversePermutation.put(patChar, wordChar);
                continue;
            }
            return false;
        }
        return true;
    }

    private void display(String[] input, String pattern, List<String> output) {
        System.out.println("input: " + Arrays.toString(input) + "; pattern: " + pattern + " -> output: " + output);
    }
}

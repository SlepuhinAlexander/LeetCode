package ex014longestcommonprefix;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input1 = {"flower", "flow", "flight"}, input2 = {"dog", "racecar", "car"};
        solution.display(input1, solution.longestCommonPrefix(input1));
        solution.display(input2, solution.longestCommonPrefix(input2));
    }

    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (longestCommonPrefix.isEmpty()) {
                return longestCommonPrefix;
            }
            longestCommonPrefix = longestCommonPrefix(longestCommonPrefix, strs[i]);
        }
        return longestCommonPrefix;
    }

    private String longestCommonPrefix(String first, String second) {
        int maxLength = Math.min(first.length(), second.length());
        if (second.startsWith(first)) {
            return first;
        }
        for (int i = 0; i < maxLength; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first.substring(0, maxLength);
    }

    private void display(String[] input, String output) {
        System.out.println("input: " + Arrays.toString(input) + " -> output: " + output);
    }
}

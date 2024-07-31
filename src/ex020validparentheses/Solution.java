package ex020validparentheses;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {"()", "()[]{}", "(]"};
        for (String input : inputs) {
            System.out.println("input: " + input + " -> is valid: " + solution.isValid(input));
        }
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                Character last = stack.poll();
                if (last == null || revert(c) != last) {
                    return false;
                }
            }
        }
        return stack.poll() == null;
    }

    private boolean isOpening(char c) {
       return c == '(' || c == '[' || c == '{';
    }

    private char revert(char c) {
        switch (c) {
            case '(': return  ')';
            case ')': return  '(';
            case '[': return  ']';
            case ']': return  '[';
            case '{': return  '}';
            case '}': return  '{';
            default: throw new RuntimeException();
        }
    }
}

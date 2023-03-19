package ex345reversevowelsofastring;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input1 = "hello", input2 = "leetcode";
        solution.display(input1, solution.reverseVowels(input1));
        solution.display(input2, solution.reverseVowels(input2));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (isVowel(chars[left])) {
                if (isVowel(chars[right])) {
                    swap(chars, left, right);
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    private void swap(char[] chars, int left, int right) {
        char swap = chars[left];
        chars[left] = chars[right];
        chars[right] = swap;
    }

    private void display(String input, String output) {
        System.out.println("input: " + input + " -> output: " + output);
    }
}

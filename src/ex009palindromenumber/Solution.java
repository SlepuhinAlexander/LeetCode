package ex009palindromenumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int input1 = 121, input2 = -123, input3 = 10;
        solution.display(input1, solution.isPalindrome(input1));
        solution.display(input2, solution.isPalindrome(input2));
        solution.display(input3, solution.isPalindrome(input3));
    }

    public boolean isPalindrome(int x) {
        return x >= 0 && inverse(x) == x;
    }

    private int inverse(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }

    private void display(int input, boolean output) {
        System.out.println("input: " + input + " -> output: " + output);
    }
}

package ex268missingnumber;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {3, 0, 1}, input2 = {0, 1}, input3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        solution.display(input1, solution.missingNumber(input1));
        solution.display(input2, solution.missingNumber(input2));
        solution.display(input3, solution.missingNumber(input3));
    }

    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    private void display(int[] input, int output) {
        System.out.println("input: " + Arrays.toString(input) + " -> output: " + output);
    }
}

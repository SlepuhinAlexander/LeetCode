package ex056maximumsubarray;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}, input2 = {1}, input3 = {5, 4, -1, 7, 8};
        solution.display(input1, solution.maxSubArray(input1));
        solution.display(input2, solution.maxSubArray(input2));
        solution.display(input3, solution.maxSubArray(input3));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    private void display(int[] input, int output) {
        System.out.println("input: " + Arrays.toString(input) + " -> output: " + output);
    }
}

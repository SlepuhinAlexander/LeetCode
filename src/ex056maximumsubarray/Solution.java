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
        int currentMax = Integer.MIN_VALUE, overallMax = 0;
        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMax = Math.max(currentMax, overallMax);
        }
        return currentMax;
    }

    private void display(int[] input, int output) {
        System.out.println("input: " + Arrays.toString(input) + " -> output: " + output);
    }
}

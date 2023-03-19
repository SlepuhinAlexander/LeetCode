package ex581shortestunsortedcontinuoussubarray;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {2, 6, 4, 8, 10, 9, 15}, input2 = {1, 2, 3, 4}, input3 = {1};
        solution.display(input1, solution.findUnsortedSubarray(input1));
        solution.display(input2, solution.findUnsortedSubarray(input2));
        solution.display(input3, solution.findUnsortedSubarray(input3));
    }

    public int findUnsortedSubarray(int[] nums) {
        int last = nums.length - 1;
        int left = 0, right = last;
        while (left < last && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left == last) {
            return 0;
        }
        while (right > 1 && nums[right] >= nums[right - 1]) {
            right--;
        }
        int leftMax = nums[left], rightMin = nums[right];
        int midMin = nums[left], midMax = nums[left];
        for (int i = left; i < right; i++) {
            midMin = Math.min(nums[i], midMin);
            midMax = Math.max(nums[i], midMax);
        }
        while (left > 0 && (nums[left - 1] == leftMax || nums[left - 1] > rightMin || nums[left - 1] > midMin)) {
            left--;
        }
        while (right < last && (nums[right + 1] == rightMin || nums[right + 1] < leftMax || nums[right + 1] < midMax)) {
            right++;
        }
        return right - left + 1;
    }

    private void display(int[] input, int output) {
        System.out.println("input: " + Arrays.toString(input) + " -> output: " + output);
    }
}

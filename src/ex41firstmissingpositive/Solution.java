package ex41firstmissingpositive;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] inputs = {{2, 1}, {1, 2, 0}, {3, 4, -1, 1}, {7, 8, 9, 11, 12}, {1, 2, 3}};
        for (int[] input : inputs) {
            System.out.println("input: " + Arrays.toString(input) +
                               " -> first missing positive: " + solution.firstMissingPositive(input));
        }
    }

    public int firstMissingPositive(int[] nums) {
        int length = squeeze(nums);
        int min = Integer.MAX_VALUE, num = 0;
        for (int i = 0; i < length; i++) {
            min = Math.min(min, nums[i]);
        }
        if (min > 1) {
            return 1;
        }
        int swap = 0;
        for (int i = 0; i < length; i++) {
            num = nums[i];
            if (num == 0 || num == i + 1) {
                continue;
            }
            swap = swap(nums, i, 0);
            while (swap != 0) {
                if (swap > length) {
                    swap = 0;
                    break;
                }
                num = nums[swap - 1];
                if (num == 0 || num == swap) {
                    nums[swap - 1] = swap;
                    swap = 0;
                } else {
                    swap = swap(nums, swap - 1, swap);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private int swap(int[] nums, int index, int newVal) {
        int swap = nums[index];
        nums[index] = newVal;
        return swap;
    }

    private int squeeze(int[] nums) {
        int trash = 0;
        for (int num : nums) {
            if (num <= 0) {
                trash++;
            }
        }
        int valueThreshold = nums.length - trash;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= valueThreshold) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}

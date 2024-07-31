package ex912sortanarray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] inputs = {{7, 7, 3, 3, 6, 5, 2, 4},
                {8, 7, 6, 5, 4, 3, 2, 1},
                {5, 2, 3, 1},
                {5, 1, 1, 1, 2, 0, 0, 0},
                {5, 1, 1, 2, 0, 0}};
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(input) + " -> " + Arrays.toString(solution.sortArray(input)));
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] arr, int from, int to) {
        int left = from;
        int right = to - 1;
        if (left > right) {
            return;
        }
        int random = arr[to];
        while (left < right) {
            while (arr[left] < random && left < to) {
                left++;
            }
            while (arr[right] > random && right > from) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        if (left == right && arr[left] <= random) {
            left++;
        }
        swap(arr, left, to);
        sort(arr, from, left - 1);
        sort(arr, left + 1, to);
    }

    private void swap(int[] arr, int first, int second) {
        int swap = arr[first];
        arr[first] = arr[second];
        arr[second] = swap;
    }
}

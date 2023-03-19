package ex074searcha2dmatrix;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
                input2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target1 = 3, target2 = 13;
        solution.display(input1, target1, solution.searchMatrix(input1, target1));
        solution.display(input2, target2, solution.searchMatrix(input2, target2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int left = 0, right = height * width - 1;
        int mid, check;
        while (left <= right) {
            mid = (left + right) / 2;
            check = matrix[mid / width][mid % width];
            if (target == check) {
                return true;
            } else if (target < check) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }

    private void display(int[][] input, int target, boolean output) {
        System.out.println("input: " + Arrays.deepToString(input) + "; target: "+ target  + " -> output: " + output);
    }
}

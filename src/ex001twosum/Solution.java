package ex001twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {2, 7, 11, 15}, input2 = {3, 2, 4}, input3 = {3, 3};
        int target1 = 9, target2 = 6, target3 = 6;
        solution.display(input1, target1, solution.twoSum(input1, target1));
        solution.display(input2, target2, solution.twoSum(input2, target2));
        solution.display(input3, target3, solution.twoSum(input3, target3));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        Integer second;
        for (int first = 0; first < nums.length; first++) {
            if ((second = visited.get(target - nums[first])) != null) {
                return toArray(second, first);
            }
            visited.put(nums[first], first);
        }
        return null;
    }

    private int[] toArray(int first, int second) {
        int[] result = new int[2];
        result[0] = first;
        result[1] = second;
        return result;
    }

    private void display(int[] input, int target, int[] output) {
        System.out.println("input: " + Arrays.toString(input) + "; target: " + target +
                           " -> output: " + Arrays.toString(output));
    }
}

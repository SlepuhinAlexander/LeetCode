package t001issortedarray;

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkSorted("1,1,1,1");
        solution.checkSorted("1,2,2,3");
        solution.checkSorted("3,2,2,1");
        solution.checkSorted("1,3,5,7");
        solution.checkSorted("7,5,3,4");
        solution.checkSorted("1,2,3,2");
    }

    public void checkSorted(String heightsInput) {
        int[] heights;
        try {
            heights = parseInput(heightsInput);
            output(isSorted(heights));
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
            output(false);
        }
    }

    private boolean isSorted(int[] heights) {
        Boolean ascending = null;
        for (int i = 1; i < heights.length; i++) {
            if (ascending == null && heights[i] != heights[i - 1]) {
                ascending = heights[i] > heights[i - 1];
                continue;
            }
            if (Objects.equals(ascending, Boolean.TRUE) && heights[i] < heights[i - 1]) {
                return false;
            }
            if (Objects.equals(ascending, Boolean.FALSE) && heights[i] > heights[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int[] parseInput(String input) {
        String[] parts = input.split(",");
        int[] result = new int[4];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }
        return result;
    }

    private void output(boolean result) {
        System.out.println(result ? "YES" : "NO");
    }
}

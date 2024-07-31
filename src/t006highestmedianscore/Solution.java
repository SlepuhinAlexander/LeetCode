package t006highestmedianscore;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.highestMedianScore("3,10\n1,2\n3,4\n5,6");
    }

    public void highestMedianScore(String inputs) {
        int[][] input;
        try {
            input = parseInput(inputs);
            int count = input[0][0];
            int sumLimit = input[0][1];
            int[][] limits = Arrays.copyOfRange(input, 1, input.length);
            output(calculateHighestMedianScore(count, sumLimit, limits));
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }

    private int calculateHighestMedianScore(int count, int sumLimit, int[][] limits) {
        return 0;
    }

    private int[][] parseInput(String inputs) {
        String[] lines = inputs.split("\n");
        String[] parts = lines[0].split(",");
        int count = Integer.parseInt(parts[0].trim());
        int sumLimit = Integer.parseInt(parts[1].trim());
        int[][] input = new int[count+1][2];
        input[0] = new int[]{count, sumLimit};
        for (int i = 1; i <= count; i++) {
            parts = lines[i].split(",");
            input[i] = new int[]{Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())};
        }
        return input;
    }

    private void output(int result) {
        System.out.println(result);
    }
}

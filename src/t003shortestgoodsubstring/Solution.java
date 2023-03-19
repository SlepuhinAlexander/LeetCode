package t003shortestgoodsubstring;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.shortestGoodSubstring("6\nababcd");
        solution.shortestGoodSubstring("5\nababc");
        solution.shortestGoodSubstring("12\naaabbbcccdba");
        solution.shortestGoodSubstring("17\naaabbbcccdbbacbdd");
        solution.shortestGoodSubstring("7\nddababa");
        solution.shortestGoodSubstring("8\nddbbaacc");
    }

    public void shortestGoodSubstring(String inputs) {
        String input;
        try {
            input = parseInput(inputs);
            output(shortestGoodSubstringLength(input));
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }

    private int shortestGoodSubstringLength(String input) {
        System.out.println(input);
        int shortest = firstGoodSubstringLength(input, 0);
        if (shortest < 0) {
            return -1;
        }
        for (int startingIndex = 1; startingIndex < input.length() - 4; startingIndex++) {
            int currentShortest = firstGoodSubstringLength(input, startingIndex);
            if (currentShortest < 0) {
                break;
            } else if (currentShortest == 4) {
                return 4;
            } else {
                shortest = Math.min(shortest, currentShortest);
            }
        }
        return shortest;
    }

    private int firstGoodSubstringLength(String input, int startingIndex) {
        int[] indices = new int[4];
        indices[0] = input.indexOf('a', startingIndex);
        indices[1] = input.indexOf('b', startingIndex);
        indices[2] = input.indexOf('c', startingIndex);
        indices[3] = input.indexOf('d', startingIndex);
        int min = min(indices), max = max(indices);
        return min < 0 ? -1 : max - min;
    }

    private int min(int[] arr) {
        int min = arr[0];
        for (int elem : arr) {
            min = Math.min(min, elem);
        }
        return min;
    }

    private int max(int[] arr) {
        int max = arr[0];
        for (int elem : arr) {
            max = Math.max(max, elem);
        }
        return max;
    }

    private String parseInput(String inputs) {
        String[] lines = inputs.split("\n");
        int length = Integer.parseInt(lines[0]);
        return lines[1].substring(0, length);
    }

    private void output(int result) {
        System.out.println(result);
    }
}

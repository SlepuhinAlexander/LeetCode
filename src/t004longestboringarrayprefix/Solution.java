package t004longestboringarrayprefix;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestBoringArrayPrefix("3\n1,2,3");
        solution.longestBoringArrayPrefix("4\n1,2,3,1");
        solution.longestBoringArrayPrefix("5\n1,2,3,1,2");
        solution.longestBoringArrayPrefix("6\n1,2,3,1,2,3");
        solution.longestBoringArrayPrefix("7\n1,2,3,1,2,3,1");
        solution.longestBoringArrayPrefix("8\n1,2,3,1,2,3,1,2");
        solution.longestBoringArrayPrefix("4\n1,1,2,2");
        solution.longestBoringArrayPrefix("6\n1,1,2,2,3,3");
    }

    public void longestBoringArrayPrefix(String inputs) {
        int[] input;
        try {
            input = parseInput(inputs);
            output(longestBoringArrayPrefixLength(input));
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }

    private int longestBoringArrayPrefixLength(int[] input) {
        int longestPrefix = 0;
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            if (frequencies.containsKey(number)) {
                frequencies.put(number, frequencies.get(number) + 1);
            } else {
                frequencies.put(number, 1);
            }
            if (i < 2 || isBoring(frequencies)) {
                longestPrefix = i + 1;
            }
        }
        return longestPrefix;
    }

    private boolean isBoring(Map<Integer, Integer> frequencies) {
        Collection<Integer> values = frequencies.values();
        return hasOnlyOnes(values) ||
               hasAllEqualsAndSingleLargerByOne(values) ||
               hasAllEqualsNotOnesAndSingleOne(values);
    }

    private boolean hasOnlyOnes(Collection<Integer> values) {
        return values.stream().allMatch(v -> v == 1);
    }

    private boolean hasAllEqualsAndSingleLargerByOne(Collection<Integer> values) {
        Map<Integer, Long> differentFrequencies =
                values.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<Integer> keySet = differentFrequencies.keySet();
        Integer minKey = Collections.min(keySet);
        Integer maxKey = Collections.max(keySet);
        return keySet.size() == 2 && maxKey == minKey + 1 && differentFrequencies.get(maxKey) == 1;
    }

    private boolean hasAllEqualsNotOnesAndSingleOne(Collection<Integer> values) {
        int allEqual = 0;
        boolean hasSingleOne = false;
        for (Integer value : values) {
            if (value == 1) {
                if (hasSingleOne) {
                    return false;
                }
                hasSingleOne = true;
                continue;
            }
            if (allEqual == 0) {
                allEqual = value;
                continue;
            }
            if (allEqual != value) {
                return false;
            }
        }
        return hasSingleOne;
    }

    private int[] parseInput(String inputs) {
        String[] lines = inputs.split("\n");
        int length = Integer.parseInt(lines[0]);
        int[] input = new int[length];
        String[] parts = lines[1].split(",");
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(parts[i].trim());
        }
        return input;
    }

    private void output(int result) {
        System.out.println(result);
    }
}

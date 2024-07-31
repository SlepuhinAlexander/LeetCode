package ex046permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3}, {0, 1}, {1}, {1, 2, 3, 4}};
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(input) + " -> " + new Solution().permute(input));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int indexes = (1 << nums.length) - 1;
        List<List<Integer>> result = iteration(indexes, nums.length);
        return result.stream().map(sequence -> makeNode(nums, sequence)).collect(Collectors.toList());
    }

    private List<List<Integer>> iteration(int indexes, int depth) {
        if (depth == 1) {
            List<Integer> newSequence = new ArrayList<>();
            int copy = indexes;
            int pos = 0;
            while (copy % 2 == 0) {
                pos++;
                copy >>= 1;
            }
            newSequence.add(pos);
            List<List<Integer>> newSequences = new ArrayList<>();
            newSequences.add(newSequence);
            return newSequences;
        }
        List<List<Integer>> newSequences = new ArrayList<>();
        int copy = indexes;
        int pos = 0;
        while (copy > 0) {
            if (copy % 2 == 1) {
                int newIndexes = indexes ^ (1 << pos);
                List<List<Integer>> iterationResult = iteration(newIndexes, depth - 1);
                for (List<Integer> sequence : iterationResult) {
                    List<Integer> newSequence = new ArrayList<>(sequence);
                    newSequence.add(pos);
                    newSequences.add(newSequence);
                }
            }
            copy >>= 1;
            pos++;
        }
        return newSequences;
    }

    private List<Integer> makeNode(int[] nums, List<Integer> indexes) {
        return indexes.stream().map(index -> nums[index]).collect(Collectors.toList());
    }
}

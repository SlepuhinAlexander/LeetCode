package ex051nqueens;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int n = 1; n <= 9; n++) {
            List<List<String>> solutions = solution.solveNQueens(n);
            System.out.println("---------> " + n + " : " + solutions.size() + " solutions <---------");
//            printNormally(solutions);
        }
    }

    private static void printNormally(List<List<String>> solutions) {
        for (List<String> solution : solutions) {
            for (String row : solution) {
                char[] chars = row.toCharArray();
                for (char cell : chars) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            List<List<String>> solutions = new ArrayList<>();
            List<String> solution = new ArrayList<>();
            solution.add("Q");
            solutions.add(solution);
            return solutions;
        }
        if (n == 2 || n == 3) {
            return new ArrayList<>();
        }
        int indexes = (1 << n) - 1;
        List<int[]> permutations = permute(indexes, n, n);
        return permutations.stream()
                .filter(this::isValid)
                .map(permutation -> toDisplay(permutation, ".".repeat(n)))
                .collect(Collectors.toList());
    }

    private List<int[]> permute(int indexes, int depth, int size) {
        if (depth == 1) {
            int[] newSequence = new int[size];
            int copy = indexes;
            int pos = 0;
            while (copy % 2 == 0) {
                pos++;
                copy >>= 1;
            }
            newSequence[depth - 1] = pos;
            List<int[]> newSequences = new ArrayList<>();
            newSequences.add(newSequence);
            return newSequences;
        }
        List<int[]> newSequences = new ArrayList<>();
        int copy = indexes;
        int pos = 0;
        while (copy > 0) {
            if (copy % 2 == 1) {
                int newIndexes = indexes ^ (1 << pos);
                List<int[]> iterationResult = permute(newIndexes, depth - 1, size);
                for (int[] sequence : iterationResult) {
                    int[] newSequence = sequence.clone();
                    newSequence[depth - 1] = pos;
                    newSequences.add(newSequence);
                }
            }
            copy >>= 1;
            pos++;
        }
        return newSequences;
    }

    private boolean isValid(int[] solution) {
        for (int row = 0; row < solution.length; row++) {
            int positionInRow = solution[row];
            for (int i = row + 1; i < solution.length; i++) {
                if (Math.abs(solution[i] - positionInRow) == i - row) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> toDisplay(int[] field, String pattern) {
        List<String> representation = new ArrayList<>();
        for (int positionInRow : field) {
            StringBuilder sb = new StringBuilder(pattern);
            sb.setCharAt(positionInRow, 'Q');
            representation.add(sb.toString());
        }
        return representation;
    }
}

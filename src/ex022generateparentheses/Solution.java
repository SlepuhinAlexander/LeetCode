package ex022generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputs = {3};
        for (int input : inputs) {
            System.out.println("input: " + input + " -> : " + solution.generateParenthesis(input));
        }
    }

    public List<String> generateParenthesis(int n) {
        int bitset = 1;
        List<String> result = new ArrayList<>();
        iteration(1, n, n, bitset, result);
        return result;
    }

    private void iteration(int opened, int notClosed, int limit, int bitset, List<String> result) {
        if (notClosed < 1) {
            result.add(stringify(bitset));
            return;
        }
        if (opened < limit) {
            iteration(opened + 1, notClosed, limit, open(bitset), result);
        }
        if (opened > 0) {
            iteration(opened - 1, notClosed - 1, limit - 1, close(bitset), result);
        }
    }

    private String stringify(int bitset) {
        StringBuilder sb = new StringBuilder();
        while (bitset > 0) {
            sb.append(bitset % 2 == 0 ? ")" : "(");
            bitset >>= 1;
        }
        return sb.reverse().toString();
    }

    private int open(int bitset) {
        return bitset * 2 + 1;
    }

    private int close(int bitset) {
        return bitset * 2;
    }

}

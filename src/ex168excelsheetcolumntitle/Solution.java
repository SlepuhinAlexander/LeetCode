package ex168excelsheetcolumntitle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int input1 = 1, input2 = 28, input3 = 701;
        solution.display(input1, solution.convertToTitle(input1));
        solution.display(input2, solution.convertToTitle(input2));
        solution.display(input3, solution.convertToTitle(input3));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while (columnNumber-- > 0) {
            title.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return title.reverse().toString();
    }

    private void display(int input, String output) {
        System.out.println("input: " + input + " -> output: " + output);
    }
}

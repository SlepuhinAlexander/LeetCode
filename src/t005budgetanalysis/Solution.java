package t005budgetanalysis;

/**
 * Условия задачи трактуются не однозначно:
 * <ol>
 *     <li>Не указано, что "разумные" и "нормальные" отрезки должны быть длиннее 1 дня.</li>
 *     <li>Не указано, что "разумные" отрезки не могут пересекаться. В таком случае в последовательности [0, 0, 0, 0] -
 *         десять "разумных" отрезков.</li>
 *     <li>Не указано, что "разумный" и "нормальный" отрезок не могут совпадать (т.е. что "нормальный" отрезок должен
 *         быть строго шире "разумного" хотя бы одной из границ).</li>
 *     <li>Не указано, что "нормальные" отрезки не могут пересекаться. В последовательности [-1, 1, 2, 3, 4] сколько
 *         "нормальных" отрезков, 1 или 4?</li>
 *     <li>Не указано, что внутри "нормального" отрезка должно быть можно найти строго 1 "разумный" отрезок (т.е.
 *         что "нормальный" отрезок не может содержать более 1 "разумного" отрезка), либо, например, что "нормальный"
 *         отрезок - это наиболее широкий такой отрезок, в котором можно найти хотя бы один "разумный" отрезок </li>
 * </ol>
 * Таким образом, величина "количество нормальных отрезков" для массива - не может быть однозначно определена и задача
 * в текущей формулировке решения не имеет.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.analyseBudget("3\n1,2,3");
        solution.analyseBudget("4\n1,2,3,1");
        solution.analyseBudget("5\n1,2,3,1,2");
        solution.analyseBudget("6\n1,2,3,1,2,3");
        solution.analyseBudget("7\n1,2,3,1,2,3,1");
        solution.analyseBudget("8\n1,2,3,1,2,3,1,2");
        solution.analyseBudget("4\n1,1,2,2");
        solution.analyseBudget("6\n1,1,2,2,3,3");
    }

    public void analyseBudget(String inputs) {
        int[] input;
        try {
            input = parseInput(inputs);
            output(countNormalPeriods(input));
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }

    private int countNormalPeriods(int[] input) {
        return 0;
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

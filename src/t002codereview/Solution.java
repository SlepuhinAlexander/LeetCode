package t002codereview;

import java.util.Arrays;

/**
 * Условия задачи трактуются не однозначно:
 * <ol>
 *     <li>из задачи не понятно, какой результат интересует:
 *         <ul>
 *             <li>Суммарные тудозатраты, потраченные всеми ревьюверами, т.е. каждый синьор потратил на ревью p_i минут
 *             (i = 1, ... , m) и нужна сумма всех p_i</li>
 *             <li>Либо сколько минут пройдёт на общих часах с момента начала первого ревью до момента окончания
 *             последнего ревью при параллельной работе всех сеньоров</li>
 *         </ul>
 *     Более вероятно, что интересует второе: реальное время параллельной работы.
 *     </li>
 *     <li>в задаче не указано, но логично предположить, что интересует минимальное возможное количество времени,
 *     потраченное на ревью.
 *     В противном случае удовлетворяющим ответом будет n * k, независимо от m, т.е. никакие два ревьювера не работают
 *     параллельно.</li>
 * </ol>
 *
 */
public class Solution {
    private static final int SINGLE_REVIEW_DURATION = 1;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.planReview("10,1,1");
        solution.planReview("10,1,2");
        solution.planReview("10,2,1");
        solution.planReview("10,10,2");
        solution.planReview("10,3,3");
        solution.planReview("1,5,3");
    }

    /**
     * Стратегия:
     * <ul>
     *     <li>очередь (массив) ревьюверов ищет себе работу</il>
     *     <li>очередь (массив) задач (равно массиву джунов) ждёт когда будет обработан хотя бы k раз</li>
     *     <li>поскольку все задачи и все ревьюверы взаимозаменяемы и занимают одинаковое количество времени выполнения,
     *         обработку задач можно делать итерациями (по 1 минуте длительности).</li>
     *     <li>помним количество пройденных итераций</li>
     *     <li>для каждой задачи помним сколько её раз проревьювили</li>
     *     <li>с прошлой итерации помним наименьшее число из количеств осуществлённых проверок отдельной задачи</li>
     *     <li>итерация:
     *         <ul>
     *            <li>если минимум >= k, то конец алгоритма</li>
     *            <li>каждый из ревьюверов последовательно ищет себе работу</li>
     *            <li>берёт в работу первую попавшуюся задачу, у которой число проверок меньше k, но при этом равно
     *                запомненному минимуму с прошлой итерации</li>
     *            <li>и т.д. вплоть до k</li>
     *            <li>если не нашлось, то ревьювер отдыхает</li>
     *            <li>взятая в работу ревьювером задача равно инкремент количества осуществлённых проверок этой задачи
     *                плюс пометка, что задача взята, чтобы другой ревьювер не мог её взять параллельно.
     *            </li>
     *         </ul>
     *     </li>
     * </ul>
     */
    public void planReview(String input) {
        int[] inputs;
        try {
            inputs = parseInput(input);
            output(calculateReviewTime(inputs[0], inputs[1], inputs[2]));
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }

    private int calculateReviewTime(int juniors, int seniors, int reviewsRequired) {
        int[] reviews = new int[juniors];
        boolean[] tasks = new boolean[juniors];
        int iterations = 0, leastReviews;
        while (true) {
            leastReviews = min(reviews);
            if (leastReviews >= reviewsRequired) {
                break;
            }
            Arrays.fill(tasks, false);
            for (int senior = 0; senior < seniors; senior++) {
                int leastReviewsToTake = leastReviews;
                findTask: while (leastReviewsToTake < reviewsRequired) {
                    for (int task = 0; task < reviews.length; task++) {
                        if (reviews[task] <= leastReviewsToTake && !tasks[task]) {
                            reviews[task]++;
                            tasks[task] = true;
                            break findTask;
                        }
                    }
                    leastReviewsToTake++;
                }
            }
            iterations++;
        }
        return iterations * SINGLE_REVIEW_DURATION;
    }

    private int min(int[] arr) {
        int min = arr[0];
        for (int elem : arr) {
            min = Math.min(min, elem);
        }
        return min;
    }

    private int[] parseInput(String input) {
        String[] parts = input.split(",");
        int[] result = new int[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }
        return result;
    }

    private void output(int result) {
        System.out.println(result);
    }
}

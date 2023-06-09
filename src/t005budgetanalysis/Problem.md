Саша ведёт бюджет и анализирует, как изменялся баланс на его счету. Он выписал числа `a_1, a_2, ..., a_n` - изменения 
баланса за последние `n` дней.

Отрезок из дней `[i, j]` Саша считает _"разумным"_, если суммарное изменение баланса с `i`-го по `j`-й день равно нулю,
т.е. `a_i + a_i+1 + ... + a_j = 0`. Отрезок из дней `[l, r]` считается _"нормальным"_, если внутри данного отрезка 
можно найти _разумный_ подотрезок.

Помогите Саше проанализировать эффективность ведения бюджета и посчитайте количество нормальных отрезков в массиве 
изменений баланса его счетов.

**Формат входных данных**

Первая строка содержит число `n` (`1 <= n <= 2* 10^5)` - количество дней, для которых Саша записывал изменения баланса.
Вторая строка содержит `n` чисел `a_1, a_2, ..., a_n` (`-10^9 <= a_i <= 10^9`) - значения изменений балансов. 

**Формат выходных данных**

Выведите одно число - количество нормальных отрезков для данного массива.   
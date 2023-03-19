Набор чисел `x_1, x_2, ..., x_k` назовём "скучным", если возможно удалить из него один элемент так, чтобы каждое число 
в данном наборе встречалось одинаковое количество раз.

Дан массив `a_1, a_2, ..., a_n` длины `n`. Найдите такое максимальное число `l` (`2 <= l <= n`), что префикс длины `l` 
является скучным.

**Формат входных данных**

Первая строка содержит число `n` (`2 <= n <= 2 * 10^5`) - размер массива.
Во второй строке находятся `n` чисел из массива `a_1, a_2, ..., a_n` (`1 <= a_i <= 2 * 10^5`).

**Формат выходных данных**

Выведите одно число - максимальное `l`, такое что префикс длины `l` массива `a` является скучным.   
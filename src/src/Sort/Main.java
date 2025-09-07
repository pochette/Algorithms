package Sort;
import java.util.Arrays;
import java.util.Random;

import static Sort.BinarySearch.binarySearch;
import static Sort.InsertionSort.insertionSort;

public class Main {
    public static void main(String[] args) {
        // Тест 1: Обычный случай
        testSort(new int[]{5, 2, 4, 6, 1, 3}, new int[]{1, 2, 3, 4, 5, 6});

        // Тест 2: Уже отсортированный массив
        testSort(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});

        // Тест 3: Обратно отсортированный массив
        testSort(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5});

        // Тест 4: Массив с дубликатами
        testSort(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5}, new int[]{1, 1, 2, 3, 4, 5, 5, 6, 9});

        // Тест 5: Один элемент
        testSort(new int[]{42}, new int[]{42});

        // Тест 6: Пустой массив
        testSort(new int[]{}, new int[]{});

        // Тест 7: Большой массив
        testLargeArray();

        System.out.println("Все тесты пройдены успешно!");
    }

    private static void testSort(int[] input, int[] expected) {
        int[] arrayToSort = input.clone(); // копируем массив
        InsertionSort.insertionSort(arrayToSort);

        if (!Arrays.equals(arrayToSort, expected)) {
            System.out.println("Ошибка!");
            System.out.println("Вход: " + Arrays.toString(input));
            System.out.println("Ожидалось: " + Arrays.toString(expected));
            System.out.println("Получено: " + Arrays.toString(arrayToSort));
            throw new AssertionError("Тест не пройден");
        }

        System.out.println("✓ Тест пройден: " + Arrays.toString(input) + " → " + Arrays.toString(expected));
    }

    private static void testLargeArray() {
        int[] largeArray = new int[1000];
        Random random = new Random();

        // Заполняем случайными числами
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = random.nextInt(1000);
        }

        int[] sortedCopy = largeArray.clone();
        Arrays.sort(sortedCopy); // эталонная сортировка

        InsertionSort.insertionSort(largeArray);

        if (!Arrays.equals(largeArray, sortedCopy)) {
            throw new AssertionError("Большой массив не отсортирован правильно");
        }

        System.out.println("✓ Большой массив отсортирован правильно");
    }

}

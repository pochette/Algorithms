package Sort;

import java.util.Arrays;

public class RadixSortTest {

    public static void main(String[] args) {
        // Тест со смешанными числами
        int[] array1 = {4, 2, 1, 5, 3};
        System.out.println("Original array: " + Arrays.toString(array1));
        RadixSort.radixSort(array1);
        System.out.println("Sorted array:   " + Arrays.toString(array1));
        System.out.println("Expected:       [1, 2, 3, 4, 5]");
        System.out.println();

        // Тест с дубликатами
        int[] array2 = {4, 2, 1, 5, 3, 2, 1, 4};
        System.out.println("Original array: " + Arrays.toString(array2));
        RadixSort.radixSort(array2);
        System.out.println("Sorted array:   " + Arrays.toString(array2));
        System.out.println("Expected:       [1, 1, 2, 2, 3, 4, 4, 5]");
        System.out.println();

        // Тест с уже отсортированным массивом
        int[] array3 = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(array3));
        RadixSort.radixSort(array3);
        System.out.println("Sorted array:   " + Arrays.toString(array3));
        System.out.println("Expected:       [1, 2, 3, 4, 5]");
        System.out.println();

        // Тест с пустым массивом
        int[] array4 = {};
        System.out.println("Original array: " + Arrays.toString(array4));
        RadixSort.radixSort(array4);
        System.out.println("Sorted array:   " + Arrays.toString(array4));
        System.out.println("Expected:       []");
        System.out.println();

        // Тест с массивом, содержащим одинаковые элементы
        int[] array5 = {2, 2, 2, 2, 2};
        System.out.println("Original array: " + Arrays.toString(array5));
        RadixSort.radixSort(array5);
        System.out.println("Sorted array:   " + Arrays.toString(array5));
        System.out.println("Expected:       [2, 2, 2, 2, 2]");
        System.out.println();
    }
}

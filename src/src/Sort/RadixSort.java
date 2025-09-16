package Sort;

public class RadixSort {
    // Метод сортировки массива целых чисел
    public static void radixSort (int[] array) {
        int n = array.length; // длина массива
        int[] counter = new int[6]; // массив для подсчета количества элементов (от 0 до 9)

        // Подсчитываем количество каждого числа в массиве
        for (int i = 0; i < array.length; i++) {
            counter[array[i]] += 1;
        }
        int i = 0; // показывает позицию, на которую нужно поставить следующий элемент
        // Записываем отсортированные элементы обратно в исходный массив
        for (int j = 0; j < counter.length; j++) {
            if (counter[j] > 0) {
                for (int k = 0; k < counter[j]; k++) {
                    array[i] = j; // записываем число j в массив
                    i++;
                }
            }
    }

    }
}

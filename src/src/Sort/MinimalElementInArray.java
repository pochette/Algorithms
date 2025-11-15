package Sort;

public class MinimalElementInArray {
    public static void main(String[] args) {
        int[] array = new int[]{64, 25, 12, 22, 11, 90, 15, 64, 795, 31, 1, 5, 6, 4, 8, 9, 41, 31, 13165, 54};
        int min = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        System.out.println("min value = " + min + " index = " + minIndex);

    }
}

class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{64, 25, 12, 22, 11, 90, 15, 64, 795, 31, 1, 5, 6, 4, 8, 9, 41, 31, 13165, 54};

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }

            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

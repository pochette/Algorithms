package Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{64, 4123, 456, 8, 23, 4, 2, 89, 94, 5263, 4, 8, 6, 0, 45, 5, 6, 48, 8, 88, 96, 4, 5, 6, 7, 86};
        for(int step = 0; step < array.length; step++) {
            int minIndex = min(array, step);
            if (array[step] > array[minIndex]) {
                int temp = array[step];
                array[step] = array [minIndex];
                array[minIndex] = temp;
            }
            System.out.println("\n");
            arrayToString(array);
        }
    }
    private static int min(int[] array, int start) {
        int minValue = array[start];
        int minIndex = start;

        for (int i = start + 1; i < array.length; i++) {
            if(array[i] < minValue) {
                minIndex = i;
                minValue = array[i];
            }
        }
        return minIndex;
    }

    private static void arrayToString(int[] array) {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}


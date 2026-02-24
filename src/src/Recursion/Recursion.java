package Recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Recursion {
    static public int getSumByRecursionWithSubarray(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            int[] subArray = Arrays.copyOfRange(array, 1, array.length);
            return array[0] + getSumByRecursionWithSubarray(subArray);
        }
    }

   static public int getSumByRecursionWithIndex(int[] array, int index) {
        if (index >= array.length) {
            return 0;
        }
        return array[index] + getSumByRecursionWithIndex(array, index + 1);
    }
//    IntStream.range(startInclusive, endExclusive)
//         .forEach(i -> array[i] = generator.applyAsInt(i)

    public static void main(String[] args) {
        int[] array  = new int[10];
        Random random = new Random();
        Arrays.setAll(array, i -> random.nextInt(100));
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Sum by subarray recursion: " + getSumByRecursionWithSubarray(array));
        System.out.println("Sum by index recursion: " + getSumByRecursionWithIndex(array, 0));
    }
}
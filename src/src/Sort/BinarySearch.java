package Sort;

public class BinarySearch {
    public static int binarySearch(int array[], int target) {
        int low = 0;
        int high = array.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
}



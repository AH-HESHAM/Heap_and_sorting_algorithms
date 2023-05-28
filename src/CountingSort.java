import java.util.Arrays;

public class CountingSort {
    int[] arr;
    int[] countArray;
    int[] result;
    int min; // minimum value in the input array
    int[][] intermediate;

    public CountingSort(int[] inputArr) {
        arr = inputArr;
        result = new int[arr.length];
        intermediate = new int[2 * arr.length + 1][arr.length];
        min = findMin();
    }

    private int findMax() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    private int findMin() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    private void updateCount() {
        // Add the minimum value to all elements.
        for (int i = 0; i < arr.length; i++) {
            intermediate[i] = Arrays.copyOf(arr, arr.length);
            arr[i] -= min;
        }
        countArray = new int[findMax() + 1];
        // Initialize the count array with zeros
        Arrays.fill(countArray, 0);

        // Count the frequency of each element
        for (int j : arr) {
            countArray[j]++;
        }

        // Modify the count array so that each element represents the number of elements
        // less than or equal to i
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
    }

    public void sort() {
        updateCount();
        // start from end to preserve order of numbers having same value.
        for (int i = arr.length - 1; i >= 0; i--) {
            int element = arr[i];
            int index = countArray[element] - 1;
            result[index] = element;
            countArray[element]--;
        }

        for (int i = 0; i < arr.length; i++) {
            intermediate[i + arr.length] = Arrays.copyOf(arr, arr.length);
            arr[i] = result[i] + min; // add the minimum value back to each element
        }
        intermediate[2 * arr.length] = Arrays.copyOf(arr, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        CountingSort test = new CountingSort(arr);
        test.sort();
        for (int i = 0; i < arr.length * 2 + 1; i++) {
            System.out.println(Arrays.toString(test.intermediate[i]));
        }

    }
}
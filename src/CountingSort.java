
import java.util.Arrays;

public class CountingSort {
    int[] arr;
    int[] countArray;
    int[] result;
    int min; // minimum value in the input array
    int[][] intermediate;
    private long time = 0;
    public CountingSort(int[] inputArr) {

        arr = inputArr;
        result = new int[arr.length];
        intermediate = new int[arr.length+1][arr.length];
        long start = System.nanoTime();
        min = findMin();
        time += (System.nanoTime() - start);
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
        long start = System.nanoTime();
        updateCount();
        // start from end to preserve order of numbers having same value.
        for (int i = arr.length - 1; i >= 0; i--) {
            int element = arr[i];
            int index = countArray[element] - 1;
            result[index] = element;
            countArray[element]--;
            arr[i] = result[i] + min; // add the minimum value back to each element
        }
        time += (System.nanoTime() - start);
        Arrays.fill(arr,0);
        for (int i = 0; i < arr.length; i++) {
            intermediate[i] = Arrays.copyOf(arr, arr.length);
            arr[i] = result[i] + min; // add the minimum value back to each element
        }

        intermediate[arr.length] = Arrays.copyOf(arr, arr.length);

        getTime();
    }

    private void print1Array(int[] toPrint) {
        System.out.print("[");
        for (int i = 0; i < toPrint.length - 1; i++) {
            System.out.print(toPrint[i] + ", ");
        }
        System.out.print(toPrint[toPrint.length - 1]);
        System.out.print("]");
    }

    public void printLast() {
        print1Array(arr);
        System.out.println();
    }

    public void printAll() {
        for (int i = 1; i <= intermediate.length; i++) {
            System.out.print(i + ") ");
            print1Array(intermediate[i - 1]);
            System.out.println();
        }
    }
    public void getTime() {
        System.out.println("Count Sort Time in micro = " + time / 1000);
        System.out.println("Count Sort Time in milli = " + time / 1000000);
    }

}

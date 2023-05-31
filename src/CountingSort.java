import java.io.FileWriter;
import java.io.IOException;
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
        intermediate = new int[arr.length + 1][arr.length];
        long start = System.nanoTime();
        min = findMin();
        time = (System.nanoTime() - start);
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
        long unused;
        // start from end to preserve order of numbers having same value.
        for (int i = arr.length - 1; i >= 0; i--) {
            int element = arr[i];
            int index = countArray[element] - 1;
            result[index] = element + min; // add the minimum value back to each element
            countArray[element]--;
            unused = System.nanoTime();
            intermediate[arr.length-i] = Arrays.copyOf(result, arr.length);
            time -= (System.nanoTime() - unused);
        }
        time += (System.nanoTime() - start);
        //Arrays.fill(arr, 0);
        for (int i = 0; i < arr.length; i++) {
            //intermediate[i] = Arrays.copyOf(arr, arr.length);
            arr[i] = result[i];
        }

        //intermediate[arr.length] = Arrays.copyOf(arr, arr.length);

    }

    private void print1Array(int[] toPrint, FileWriter writer) throws IOException {
        writer.append("[");
        for (int i = 0; i < toPrint.length - 1; i++) {
            writer.append(toPrint[i] + ", ");
        }
        writer.append(toPrint[toPrint.length - 1] + "");
        writer.append("]");
    }

    public void printLast() {
        String path = "src/countOut.txt";
        try (FileWriter writer = new FileWriter(path)) {
            print1Array(arr, writer);
            writer.append("\n");
//            writer.append("Count sort time for size = " + arr.length + " in micro = " + ((time) / 1000) + "\n"
//                    + "Count sort time for size = " + arr.length + " in milli = " + ((time) / 1000000) + "\n");
            //getTime("C:/Users/ADMIN/Desktop/DS 2 assignments/assignment 4/Heap_and_sorting_algorithms/src/countOut.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printAll() {
        String path = "src/countOut.txt";
        try (FileWriter writer = new FileWriter(path)) {
            writer.append("Intermediate:\n");
            for (int i = 0; i < intermediate.length-1; i++) {
                writer.append((i + 1) + ") ");
                print1Array(intermediate[i], writer);
                writer.append(", ");
                writer.append("\n");
            }
            writer.append(intermediate.length + ") ");
            print1Array(intermediate[intermediate.length-1], writer);
//            writer.append("\nCount sort time for size = " + arr.length + " in micro = " + ((time) / 1000) + "\n"
//                    + "Count sort time for size = " + arr.length + " in milli = " + ((time) / 1000000) + "\n");
            //getTime("C:/Users/ADMIN/Desktop/DS 2 assignments/assignment 4/Heap_and_sorting_algorithms/src/countOut.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTime(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append("Count sort time for size = " + intermediate.length + "in micro = " + ((time) / 1000) + "\n"
            + "Count sort time for size = " + intermediate.length + " in milli = " + ((time) / 1000000) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//     public static void main(String[] args) {
//         int[] arr = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381};
//         CountingSort test = new CountingSort(arr);
//         test.sort();
//         //for (int i = 0; i < arr.length+1; i++) {
//         //System.out.println(Arrays.toString(test.intermediate[i]));
//         //}
//        // test.getTime();
//         //System.out.print(Arrays.toString(test.arr));
//         //test.printLast();
//         test.printAll();
//     }
}
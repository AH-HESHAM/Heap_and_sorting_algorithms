import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    long timeMicros = 0;
    int[] arr;
    int size = 0;

    public int[] sort(int[] array, boolean intermediate) {
        MaxHeap mh = new MaxHeap();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arr.add(i, array[i]);
        }
        int n = arr.size();
        mh.buildMaxHeap(arr);

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/HeapOut.txt"))) {
            for (int i = n - 1; i > 0; i--) {
                if (intermediate) {
                    writer.println(arr); // Write each intermediate array to a new line
                }
                long startTime = System.nanoTime();
                mh.swap(arr, 0, i);
                mh.maxHeapify(arr, i, 0);
                long endTime = System.nanoTime();
                timeMicros += (endTime - startTime) / 1000;

            }

                writer.println(arr); // Write the final sorted array to a new line

        } catch (IOException e) {
            e.printStackTrace();
        }
        size = arr.size();
        return MaxHeap.listToArray(arr);
    }



    private void print1Array(List<Integer> toPrint, FileWriter writer) throws IOException {
        writer.append("[");
        for (int i = 0; i < toPrint.size() - 1; i++) {
            writer.append(toPrint.get(i) + ", ");
        }
        writer.append(toPrint.get(toPrint.size() - 1) + "");
        writer.append("]");
    }

    private void print(List<Integer> arr) {
        String path = "src/HeapOut.txt";
        try (FileWriter writer = new FileWriter(path)) {
            print1Array(arr, writer);
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print2(int[] arr) {
        String path = "src/HeapOut.txt";
        try (FileWriter writer = new FileWriter(path)) {
            print2Array(arr, writer);
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void print2Array(int[] toPrint, FileWriter writer) throws IOException {
        writer.append("[");
        for (int i = 0; i < toPrint.length - 1; i++) {
            writer.append(toPrint[i] + ", ");
        }
        writer.append(toPrint[toPrint.length -1 ] + "");
        writer.append("]");
    }

    public void getTime(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(
                    "Merge sort time for size = " + size + "in micro = " + timeMicros + "\n");
            writer.append(
                    "Merge sort time for size = " + size + " in milli = " + (timeMicros / 1000) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
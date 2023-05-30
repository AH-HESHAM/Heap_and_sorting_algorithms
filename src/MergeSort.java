import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSort {
    private int[] arr;
    private ArrayList<ArrayList<int[]>> allArrays = new ArrayList<ArrayList<int[]>>();
    private ArrayList<ArrayList<int[]>> splited = new ArrayList<ArrayList<int[]>>();
    private long time = 0;
    private long notUsed = 0;

    MergeSort(int[] arr) {
        this.arr = new int[arr.length];
        this.arr = arr.clone();
        long start = System.nanoTime();
        sort(0, arr.length - 1, 0);
        time = (System.nanoTime() - start);

    }

    private void sort(int first, int last, int levelnum) {
        long start = System.nanoTime();
        if (allArrays.size() < levelnum + 1) {
            allArrays.add(new ArrayList<int[]>());
        }
        if (splited.size() < levelnum + 1) {
            splited.add(new ArrayList<int[]>());
        }
        notUsed += (System.nanoTime() - start);
        if (first < last) {
            start = System.nanoTime();
            splited.get(levelnum).add(makeList(first, last));
            notUsed += (System.nanoTime() - start);
            int mid = (first + last) / 2;
            sort(first, mid, levelnum + 1);
            sort(mid + 1, last, levelnum + 1);
            int[] temp = merge(first, mid, last);
            start = System.nanoTime();
            allArrays.get(levelnum).add(temp);
            notUsed += (System.nanoTime() - start);
        } else {
            start = System.nanoTime();
            int[] lastElem = new int[1];
            lastElem[0] = arr[first];
            allArrays.get(levelnum).add(lastElem);
            splited.get(levelnum).add(lastElem);
            notUsed += (System.nanoTime() - start);
        }

    }

    private int[] makeList(int l, int h) {
        int[] ans = new int[h - l + 1];
        for (int i = l; i <= h; i++) {
            ans[i - l] = arr[i];
        }
        return ans;
    }

    private int[] merge(int l, int m, int h) {
        int[] afterMerge = new int[h - l + 1];
        int count = 0;
        int i = l;
        int j = m + 1;
        while (i <= m && j <= h) {
            if (arr[i] < arr[j]) {
                afterMerge[count++] = arr[i++];
            } else {
                afterMerge[count++] = arr[j++];
            }
        }
        while (i <= m) {
            afterMerge[count++] = arr[i++];
        }
        while (j <= h) {
            afterMerge[count++] = arr[j++];
        }
        for (int k = l; k <= h; k++) {
            arr[k] = afterMerge[k - l];
        }
        return afterMerge;
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
        String path = "/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/mergeOut.txt";
        try (FileWriter writer = new FileWriter(path)) {
            print1Array(arr, writer);
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printAll() {
        String path = "/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/mergeOut.txt";
        try (FileWriter writer = new FileWriter(path)) {
            int n1 = splited.size();
            writer.append("Splitting\n");
            writer.append("|->> initial\n");
            for (int i = 0; i < n1; i++) {
                int m = splited.get(i).size();
                writer.append((i + 1) + ") ");
                for (int j = 0; j < m - 1; j++) {
                    print1Array(splited.get(i).get(j), writer);
                    writer.append(", ");
                }
                print1Array(splited.get(i).get(m - 1), writer);
                writer.append("\n");
            }
            int n = allArrays.size();
            writer.append("merging\n");
            for (int i = n - 1; i >= 0; i--) {
                int m = allArrays.get(i).size();
                writer.append((n - i) + ") ");
                for (int j = 0; j < m - 1; j++) {
                    print1Array(allArrays.get(i).get(j), writer);
                    writer.append(", ");
                }
                print1Array(allArrays.get(i).get(m - 1), writer);
                writer.append("\n");
            }
            writer.append("|_>> Sorted Array\n");
        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }

    public void getTime(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(
                    "Merge sort time for size = " + arr.length + "in micro = " + ((time - notUsed) / 1000) + "\n");
            writer.append(
                    "Merge sort time for size = " + arr.length + " in milli = " + ((time - notUsed) / 1000000) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getResult() {
        return this.arr;
    }

}
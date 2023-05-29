import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    public static void maxHeapify(List<Integer> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        if (right < n && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    public static void buildMaxHeap(List<Integer> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    public static void heapSort(List<Integer> arr) {
        int n = arr.size();

        buildMaxHeap(arr);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }

    public static void maxHeapInsert(List<Integer> arr, int num) {
        arr.add(num);
        int i = arr.size() - 1;

        while (i > 0 && arr.get((i - 1) / 2) < arr.get(i)) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static int heapExtractMax(List<Integer> arr) {

        int max = arr.get(0);
        int n = arr.size();
        arr.set(0, arr.get(n - 1));
        arr.remove(n - 1);
        maxHeapify(arr, arr.size(), 0);
        return max;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);
        return list;
    }

    public static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
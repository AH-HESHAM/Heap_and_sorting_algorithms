import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public int[] sort(int[] array, boolean intermediate) {
        MaxHeap mh = new MaxHeap();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arr.add(i, array[i]);
        }
        int n = arr.size();
        mh.buildMaxHeap(arr);

        for (int i = n - 1; i > 0; i--) {
            mh.swap(arr, 0, i);
            mh.maxHeapify(arr, i, 0);
            if (intermediate) {
                System.out.print((n - i) + ") ");
                print(arr);
                System.out.println();
            }
        }
        if (!intermediate)
            print(arr);
        return MaxHeap.listToArray(arr);
    }

    private void print(List<Integer> arr) {
        int size = arr.size();
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(arr.get(i));
            if (i < size - 1) {
                System.out.print(", ");

            }
        }
        System.out.print("]");
    }
}
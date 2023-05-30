import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    long timeMicros = 0; // Use long to store larger time values accurately
    public int[] sort(int[] array, boolean intermediate) {
        MaxHeap mh = new MaxHeap();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            arr.add(i, array[i]);
        }

        int n = arr.size();

        timeMicros = 0;
        long startBuildTime = System.nanoTime();
        mh.buildMaxHeap(arr);
        long endBuildTime = System.nanoTime();
        timeMicros += (endBuildTime - startBuildTime) / 1000;

        for (int i = n - 1; i > 0; i--) {
            long startTime = System.nanoTime();
            mh.swap(arr, 0, i);
            mh.maxHeapify(arr, i, 0);
            long endTime = System.nanoTime();
            timeMicros += (endTime - startTime) / 1000;
            if (intermediate) {
                System.out.print((n - i) + ") ");
                print(arr);
                System.out.println();
            }
        }
        //System.out.println("Time: " + timeMicros + " microseconds");
//        if (!intermediate)
//            print(arr);
        return MaxHeap.listToArray(arr);
    }

    void getTime(int[] array){
        sort(array, false);
        System.out.println("Time in micros = " + timeMicros);
        System.out.println("Time in millis = " + timeMicros / 1000);
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
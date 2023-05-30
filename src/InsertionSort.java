public class InsertionSort {
    long time = 0;

    public int[] sort(int[] arr, int size, boolean intermediate) {
        long start = System.nanoTime();
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            if (intermediate) {
                System.out.print(i + ") ");
                print(arr);
                System.out.println();
            }
        }
        time += (System.nanoTime() - start);
        if (!intermediate) {
            print(arr);
            System.out.println();
        }
        return arr;
    }

    private void print(int[] arr) {
        int size = arr.length;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) {
                System.out.print(", ");

            }
        }
        System.out.print("]");
    }

    public void getTime() {
         System.out.println("Time in micro = " + time / 1000);
        System.out.println("insertion time in milli = " + time / 1000000);
    }

}
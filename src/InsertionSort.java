public class InsertionSort {
    public int[] sort(int[] arr, int size, boolean intermediate) {
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

}
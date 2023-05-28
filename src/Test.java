import static org.junit.Assert.assertArrayEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// import org.junit.Test;

public class Test {

    public String readFile(String path) {
        String input = "";
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            input = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    public int[] parseInput(String input) {
        String[] arr = input.split(", ");
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = Integer.parseInt(arr[i]);
        }
        return ans;
    }

    public int[] getInput(String path) {
        return parseInput(readFile(path));
    }
    // start merge sort

    @org.junit.Test
    // small unsorted odd size array with negative and zero
    public void test1Merge() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        MergeSort mysort = new MergeSort(arr);
        int[] ans = { -1, 0, 2, 4, 7, 10, 21 };
        assertArrayEquals(ans, mysort.getResult());
    }

    @org.junit.Test
    // larg randome numbers even size
    public void test2Merge() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        MergeSort mysort = new MergeSort(arr);
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        assertArrayEquals(ans, mysort.getResult());
    }

    @org.junit.Test
    // already sorted
    public void test3Merge() {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        MergeSort mysort = new MergeSort(arr);
        int[] ans = { 10, 20, 30, 40, 50, 60 };
        assertArrayEquals(ans, mysort.getResult());
    }

    @org.junit.Test
    // reversed
    public void test4Merge() {
        int[] arr = { 100, 80, 60, 40, 30, 20 };
        MergeSort mysort = new MergeSort(arr);
        int[] ans = { 20, 30, 40, 60, 80, 100 };
        assertArrayEquals(ans, mysort.getResult());
    }

    // end merge sort

    // start count sort

    @org.junit.Test
    // small unsorted odd size array with negative and zero
    public void test1Count() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        CountingSort mysort = new CountingSort(arr);
        int[] ans = { -1, 0, 2, 4, 7, 10, 21 };
        mysort.sort();
        assertArrayEquals(ans, mysort.intermediate[mysort.intermediate.length - 1]);
    }

    @org.junit.Test
    // larg randome numbers even size
    public void test2Count() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        CountingSort mysort = new CountingSort(arr);
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        mysort.sort();
        assertArrayEquals(ans, mysort.intermediate[mysort.intermediate.length - 1]);
    }

    @org.junit.Test
    // already sorted
    public void test3Count() {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        CountingSort mysort = new CountingSort(arr);
        int[] ans = { 10, 20, 30, 40, 50, 60 };
        mysort.sort();
        assertArrayEquals(ans, mysort.intermediate[mysort.intermediate.length - 1]);
    }

    @org.junit.Test
    // reversed
    public void test4Count() {
        int[] arr = { 100, 80, 60, 40, 30, 20 };
        CountingSort mysort = new CountingSort(arr);
        int[] ans = { 20, 30, 40, 60, 80, 100 };
        mysort.sort();
        assertArrayEquals(ans, mysort.intermediate[mysort.intermediate.length - 1]);
    }

    // end count sort

    // start insertion sort
    @org.junit.Test
    // small unsorted odd size array with negative and zero
    public void test1Insert() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        InsertionSort mysort = new InsertionSort();
        int[] ans = { -1, 0, 2, 4, 7, 10, 21 };
        assertArrayEquals(ans, mysort.sort(arr, 7, false));
    }

    @org.junit.Test
    // larg randome numbers even size
    public void test2Insert() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        InsertionSort mysort = new InsertionSort();
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        assertArrayEquals(ans, mysort.sort(arr, 10, false));
    }

    @org.junit.Test
    // already sorted
    public void test3Insert() {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        InsertionSort mysort = new InsertionSort();
        int[] ans = { 10, 20, 30, 40, 50, 60 };
        assertArrayEquals(ans, mysort.sort(arr, 6, false));
    }

    @org.junit.Test
    // reversed
    public void test4Insert() {
        int[] arr = { 100, 80, 60, 40, 30, 20 };
        InsertionSort mysort = new InsertionSort();
        int[] ans = { 20, 30, 40, 60, 80, 100 };
        assertArrayEquals(ans, mysort.sort(arr, 6, false));
    }

    // end insertion sort

    // O(N^2) and O(n log n) methods million larg file
    @org.junit.Test
    public void testAll() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/1000000n1.txt");
        MergeSort ms = new MergeSort(arr);
        // CountingSort cs = new CountingSort(arr);
        InsertionSort is = new InsertionSort();
        assertArrayEquals(ms.getResult(), is.sort(arr, 1000000, false));
    }

    @org.junit.Test
    // 10 k words all methods
    public void testAll2() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000n1.txt");
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 10000, false));
    }

    @org.junit.Test
    // 20 k words all methods
    public void testAll3() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/20000n1.txt");
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length -
                1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 20000, false));
    }

}

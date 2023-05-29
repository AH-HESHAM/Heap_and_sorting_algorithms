import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
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

    // start haep

    @org.junit.Test
    // larg randome numbers even size
    public void test1Heap() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        assertArrayEquals(ans, MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // build heap , extrct max, insert new in the middle and soet new array
    public void test2Heap() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.buildMaxHeap(li);
        assertEquals(21, MaxHeap.heapExtractMax(li));
        MaxHeap.maxHeapInsert(li, 5);
        MaxHeap.heapSort(li);
        int[] ans = { -1, 0, 2, 4, 5, 7, 10 };
        assertArrayEquals(ans, MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // already sorted
    public void test3Heap() {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        int[] ans = { 10, 20, 30, 40, 50, 60 };
        assertArrayEquals(ans, MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // reversed
    public void test4Heap() {
        int[] arr = { 60, 50, 40, 30, 20, 10 };
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        int[] ans = { 10, 20, 30, 40, 50, 60 };
        assertArrayEquals(ans, MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // insert max, insert min, extract twice
    public void test5Heap() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.buildMaxHeap(li);
        MaxHeap.maxHeapInsert(li, 50);
        MaxHeap.maxHeapInsert(li, -20);
        int[] ans = { -20, -1, 0, 2, 4, 7, 10, 21, 50 };
        MaxHeap.heapSort(li);
        assertArrayEquals(ans, MaxHeap.listToArray(li));
        assertEquals(50, MaxHeap.heapExtractMax(li));
        assertEquals(21, MaxHeap.heapExtractMax(li));
    }

    // end heap

    // heap, O(N^2) and O(n log n) methods 100k larg file
    @org.junit.Test
    public void testAll() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/100000n1.txt");
        MergeSort ms = new MergeSort(arr);
        InsertionSort is = new InsertionSort();
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        assertArrayEquals(ms.getResult(), is.sort(arr, 100000, false));
        assertArrayEquals(ms.getResult(), MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // 10 k words all methods
    public void testAll2() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000n1.txt");
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 10000, false));
        assertArrayEquals(ms.getResult(), MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // 20 k words all methods
    public void testAll3() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/20000n1.txt");
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 20000, false));
        assertArrayEquals(ms.getResult(), MaxHeap.listToArray(li));
    }

    @org.junit.Test
    // only one element
    public void testAll4() {
        int[] arr = { 205 };
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        List<Integer> li = MaxHeap.arrayToList(arr);
        MaxHeap.heapSort(li);
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 1, false));
        assertArrayEquals(ms.getResult(), MaxHeap.listToArray(li));
    }

}

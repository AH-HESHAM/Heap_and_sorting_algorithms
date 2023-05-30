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
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
    }

    @org.junit.Test
    // larg randome numbers even size
    public void test2Merge() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        MergeSort mysort = new MergeSort(arr);
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        assertArrayEquals(ans, mysort.getResult());
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
    }

    @org.junit.Test
    // already sorted
    public void test3Merge() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000down1.txt");
        int[] ans = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        MergeSort mysort = new MergeSort(arr);
        assertArrayEquals(ans, mysort.getResult());
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/bestCase.txt");
    }

    @org.junit.Test
    // reversed
    public void test4Merge() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000down1.txt");
        int[] ans = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        MergeSort mysort = new MergeSort(arr);
        assertArrayEquals(ans, mysort.getResult());
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/worstCase.txt");
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
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
    }

    @org.junit.Test
    // larg randome numbers even size
    public void test2Count() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        CountingSort mysort = new CountingSort(arr);
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        mysort.sort();
        assertArrayEquals(ans, mysort.intermediate[mysort.intermediate.length - 1]);
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
    }

    @org.junit.Test
    // already sorted
    public void test3Count() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        CountingSort mysort = new CountingSort(arr);
        mysort.sort();
        assertArrayEquals(arr, mysort.intermediate[mysort.intermediate.length - 1]);
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/bestCase.txt");
    }

    @org.junit.Test
    // reversed
    public void test4Count() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000down1.txt");
        int[] ans = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        CountingSort mysort = new CountingSort(arr);
        mysort.sort();
        assertArrayEquals(ans, mysort.intermediate[mysort.intermediate.length - 1]);
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/worstCase.txt");
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
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
    }

    @org.junit.Test
    // larg randome numbers even size
    public void test2Insert() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        InsertionSort mysort = new InsertionSort();
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        assertArrayEquals(ans, mysort.sort(arr, 10, false));
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
    }

    @org.junit.Test
    // already sorted
    public void test3Insert() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        InsertionSort mysort = new InsertionSort();
        assertArrayEquals(arr, mysort.sort(arr, 10000, false));
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/bestCase.txt");
    }

    @org.junit.Test
    // reversed
    public void test4Insert() {
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000down1.txt");
        int[] ans = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        InsertionSort mysort = new InsertionSort();
        assertArrayEquals(ans, mysort.sort(arr, 10000, false));
        mysort.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/worstCase.txt");
    }

    // end insertion sort

    // start haep

    @org.junit.Test
    // larg randome numbers even size
    public void test1Heap() {
        HeapSort hs = new HeapSort();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10n1.txt");
        int[] temp = hs.sort(arr, false);
        int[] ans = { -7538, -6475, -5335, -2770, -1459, -1028, -439, 869, 2858, 9381 };
        assertArrayEquals(ans, temp);
        // call get time here
    }

    @org.junit.Test
    // build heap , extrct max, insert new in the middle and sort new array
    public void test2Heap() {
        HeapSort hs = new HeapSort();
        MaxHeap mh = new MaxHeap();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        List<Integer> li = MaxHeap.arrayToList(arr);
        mh.buildMaxHeap(li);
        assertEquals(21, mh.heapExtractMax());
        mh.maxHeapInsert(5);
        int[] temp = hs.sort(mh.heapified, false);
        int[] ans = { -1, 0, 2, 4, 5, 7, 10 };
        assertArrayEquals(ans, temp);
        // call get time here
    }

    @org.junit.Test
    // already sorted
    public void test3Heap() {
        HeapSort hs = new HeapSort();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        int[] temp = hs.sort(arr, false);
        assertArrayEquals(arr, temp);
        // call get time here
    }

    @org.junit.Test
    // reversed
    public void test4Heap() {
        HeapSort hs = new HeapSort();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000down1.txt");
        int[] temp = hs.sort(arr, false);
        int[] ans = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        assertArrayEquals(ans, temp);
        // call get time here
    }

    @org.junit.Test
    // insert max, insert min, extract twice
    public void test5Heap() {
        HeapSort hs = new HeapSort();
        MaxHeap mh = new MaxHeap();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/test1.txt");
        List<Integer> li = MaxHeap.arrayToList(arr);
        mh.buildMaxHeap(li);
        mh.maxHeapInsert(50);
        mh.maxHeapInsert(-20);
        int[] ans = { -20, -1, 0, 2, 4, 7, 10, 21, 50 };
        int[] temp = hs.sort(mh.heapified, false);
        assertArrayEquals(ans, temp);
        assertEquals(50, mh.heapExtractMax());
        assertEquals(21, mh.heapExtractMax());
        // call get time here
    }

    // end heap

    // heap, O(N^2) and O(n log n) methods 100k larg file
    @org.junit.Test
    public void testAll() {
        HeapSort hs = new HeapSort();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/100000n1.txt");
        MergeSort ms = new MergeSort(arr);
        InsertionSort is = new InsertionSort();
        int[] temp = hs.sort(arr, false);
        assertArrayEquals(ms.getResult(), is.sort(arr, 100000, false));
        assertArrayEquals(ms.getResult(), temp);
        ms.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        is.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        // call get time here
    }

    @org.junit.Test
    // 10 k words all methods
    public void testAll2() {
        HeapSort hs = new HeapSort();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000n1.txt");
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        int[] temp = hs.sort(arr, false);
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 10000, false));
        assertArrayEquals(ms.getResult(), temp);
        ms.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        is.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        cs.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        // call get time here
    }

    @org.junit.Test
    // 20 k words all methods
    public void testAll3() {
        HeapSort hs = new HeapSort();
        int[] arr = getInput("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/20000n1.txt");
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        int temp[] = hs.sort(arr, false);
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 20000, false));
        assertArrayEquals(ms.getResult(), temp);
        ms.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        is.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        cs.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/avergeCase.txt");
        // call get time here
    }

    @org.junit.Test
    // only one element
    public void testAll4() {
        HeapSort hs = new HeapSort();
        int[] arr = { 205 };
        MergeSort ms = new MergeSort(arr);
        CountingSort cs = new CountingSort(arr);
        cs.sort();
        InsertionSort is = new InsertionSort();
        ;
        int temp[] = hs.sort(arr, false);
        assertArrayEquals(ms.getResult(), cs.intermediate[cs.intermediate.length - 1]);
        assertArrayEquals(ms.getResult(), is.sort(arr, 1, false));
        assertArrayEquals(ms.getResult(), temp);
        ms.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/bestCase.txt");
        is.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/bestCase.txt");
        cs.getTime("/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/bestCase.txt");
        // call get time here
    }

}

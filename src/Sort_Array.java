import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sort_Array {
    private int[] elements;
    private int size;

    Sort_Array(String filePath) {
        init(filePath);
        size = elements.length;
    }

    private void init(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(", ");
            int[] numbers = new int[0];
            while (scanner.hasNextInt()) {
                int[] temp = new int[numbers.length + 1];
                System.arraycopy(numbers, 0, temp, 0, numbers.length);
                temp[numbers.length] = scanner.nextInt();
                numbers = temp;
            }
            elements = numbers;
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public void Simple_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        InsertionSort is = new InsertionSort();
        if(intermediate) System.out.println("Sorted array with intermediate steps using Insertion Sort:");
        else System.out.println("Sorted array using Insertion Sort:");
        is.sort(elementsClone, size, intermediate);
        if(intermediate) System.out.println("|_>> Sorted Array");
    }

    public void Efficient_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        MergeSort ms = new MergeSort(elementsClone);
        if(intermediate) {
            System.out.println("Sorted array with intermediate steps using Merge Sort:");
            ms.printAll();
        }
        else {
            System.out.println("Sorted array using Merge Sort:");
            ms.printLast();
        }
        if(intermediate) System.out.println("|_>> Sorted Array");
    }

    public void Non_Comparison_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        CountingSort cs = new CountingSort(elementsClone);
        cs.sort();
        if(intermediate) {
            System.out.println("Sorted array with intermediate steps using Counting Sort:");
            cs.printAll();
        }
        else {
            System.out.println("Sorted array using Counting Sort:");
            cs.printLast();
        }
        if(intermediate) System.out.println("|_>> Sorted Array");
    }

    public void Heap_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        HeapSort hs = new HeapSort();
        if(intermediate) System.out.println("Sorted array with intermediate steps using Heap Sort:");
        else System.out.println("Sorted array using Heap Sort:");
        hs.sort(elementsClone, intermediate);
        if(intermediate) System.out.println("|_>> Sorted Array");
    }
}

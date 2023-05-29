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
        InsertionSort is = new InsertionSort();
        if(intermediate) System.out.println("Sorted array with intermediate steps using Insertion Sort:");
        else System.out.println("Sorted array using Insertion Sort:");
        is.sort(elements, size, intermediate);
    }

    public void Efficient_Sort(boolean intermediate) {
        MergeSort ms = new MergeSort(elements);
        if(intermediate) {
            System.out.println("Sorted array with intermediate steps using Merge Sort:");
            ms.printAll();
        }
        else {
            System.out.println("Sorted array using Merge Sort:");
            ms.printLast();
        }
    }

    public void Non_Comparison_Sort(boolean intermediate) {
        CountingSort cs = new CountingSort(elements);
        cs.sort();
        if(intermediate) {
            System.out.println("Sorted array with intermediate steps using Counting Sort:");
            cs.printAll();
        }
        else {
            System.out.println("Sorted array using Counting Sort:");
            cs.printLast();
        }
    }

    public void Heap_Sort(boolean intermediate) {
        HeapSort hs = new HeapSort();
        if(intermediate) System.out.println("Sorted array with intermediate steps using Heap Sort:");
        else System.out.println("Sorted array using Heap Sort:");
        hs.sort(elements, intermediate);
    }
}

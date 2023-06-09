import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sort_Array {
    private int[] elements;
    private int size;

    Sort_Array(String filePath) throws NumberFormatException, IOException {
        init(filePath);
        size = elements.length;
    }

    private void init(String filePath) throws NumberFormatException, IOException {
        List<Integer> integers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(", ");
            for (String token : tokens) {
                integers.add(Integer.parseInt(token.trim()));
            }
        }
        reader.close();
        elements = integers.stream().mapToInt(Integer::intValue).toArray();
    }



    public void Simple_Sort(boolean intermediate) throws IOException {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        InsertionSort is = new InsertionSort();
        if (intermediate)
            System.out.println("Sorted array with intermediate steps using Insertion Sort in file insertOut.txt");
        else
            System.out.println("Sorted array using Insertion Sort in file insertOut.txt");
        is.sort(elementsClone, size, intermediate);
        if (intermediate)
            System.out.println("Sorted Array in file insertOut.txt ");
    }


    public void Efficient_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        MergeSort ms = new MergeSort(elementsClone);
        if (intermediate) {
            System.out.println("Sorted array with intermediate steps using Merge Sort are in MeergeOut.txt");
            ms.printAll();
        } else {
            System.out.println("Sorted array using is in MeergeOut.txt");
            ms.printLast();
        }
        // if(intermediate) System.out.println("|_>> Sorted Array");
    }

    public void Non_Comparison_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        CountingSort cs = new CountingSort(elementsClone);
        cs.sort();
        if (intermediate) {
            System.out.println("Sorted array with intermediate steps using Counting Sort:");
            cs.printAll();
        } else {
            System.out.println("Sorted array using Counting Sort:");
            cs.printLast();
        }
        if (intermediate)
            System.out.println("|_>> Sorted Array");
    }

    public void Heap_Sort(boolean intermediate) {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        HeapSort hs = new HeapSort();
        if (intermediate)
            System.out.println("Sorted array with intermediate steps using Heap Sort:");
        else
            System.out.println("Sorted array using Heap Sort:");
        hs.sort(elementsClone, intermediate);
        if (intermediate)
            System.out.println("|_>> Sorted Array");
    }
}

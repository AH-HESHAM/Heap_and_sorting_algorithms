import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sort_Array {
    private int[] elements;
    private int size;

    Sort_Array(String filePath) throws IOException {
        init(filePath);
        size = elements.length;
    }

    private void init(String filePath) throws IOException {
        String file = filePath;
        Path path = Paths.get(file);
        List<String> lines = Files.readAllLines(path);

        List<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                numbers.add(number);
            }
        }
        elements = new int[numbers.size()];
        for(int i=0; i< numbers.size(); i++){
            elements[i] = numbers.get(i);
        }
    }

    public void Simple_Sort(boolean intermediate) throws IOException {
        int[] elementsClone = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            elementsClone[i] = elements[i];
        }
        InsertionSort is = new InsertionSort();
        if (intermediate)
            System.out.println("Sorted array with intermediate steps using Insertion Sort:");
        else
            System.out.println("Sorted array using Insertion Sort:");
        is.sort(elementsClone, size, intermediate);
        if (intermediate)
            System.out.println("|_>> Sorted Array");
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

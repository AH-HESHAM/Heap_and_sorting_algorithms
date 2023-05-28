import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);
            List<Integer> lines = new ArrayList<>();

            while(true) {
                System.out.println("1-Build Max Heap");
                System.out.println("2-Max Heap Insert");
                System.out.println("3-HeapExtract Max");
                System.out.println("4-Heap Sort \n");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        lines = reader();
                        System.out.println("Before Max Heap Build: " + lines);
                        MaxHeap.buildMaxHeap(lines);
                        System.out.println("After Max Heap build: " + lines);
                        writer(lines);
                    }
                    break;
                    case 2: {
                        System.out.println("Number to insert..\n");
                        int num = sc.nextInt();
                        System.out.println("Before Max Heap Insert: " + lines);
                        MaxHeap.maxHeapInsert(lines, num);
                        System.out.println("After Max Heap Insert: " + lines);
                        writer(lines);
                    }break;
                    case 3: {
                        if(lines.size() == 0){
                            System.out.println("Nothing to extract .. ");
                            break;
                        }
                        System.out.println("Extracted number from Max Heap = " + MaxHeap.heapExtractMax(lines) + "\n");
                        writer(lines);
                    }break;
                    case 4: {
                        System.out.println("1- Existing array , 2- New file \n");
                        int choice2 = sc.nextInt();
                        switch (choice2){
                            case 1: {
                                System.out.println("Before Max Heap Sort: " + lines);
                                List<Integer> temp = new ArrayList<>(lines);
                                MaxHeap.heapSort(temp);
                                System.out.println("After Max Heap Sort: " + temp);
                                writer(temp);
                            }break;
                            case 2: {
                                lines = reader();
                                System.out.println("Before Max Heap Sort: " + lines);
                                MaxHeap.heapSort(lines);
                                System.out.println("After Max Heap Sort: " + lines);
                                writer(lines);
                            }
                        }

                    }

                }
            }





    }
    static void writer(List<Integer> arr){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Output.txt"))) {
            for (Integer number : arr) {
                writer.write(number.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    static List<Integer> reader(){
        String Filename = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert File path \n");
        Filename = sc.nextLine();
        List<Integer> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numberStrings = line.split(" ");
                for (String numberString : numberStrings) {
                    int number = Integer.parseInt(numberString);
                    lines.add(number);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
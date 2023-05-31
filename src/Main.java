import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /* ------------------------Utils------------------------ */
    public static final String ANSI_RESET = "\u001B[0m", BLACK = "\u001B[30m", RED = "\u001B[31m", GREEN = "\u001B[32m",
      YELLOW = "\u001B[33m", BLUE = "\u001B[34m", PURPLE = "\u001B[35m", CYAN = "\u001B[36m";

    public static void prompt(){
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static boolean assertStr(char[] str){
        if(str.length == 0) return false;
        for(int i = 0; i < str.length; ++i){
            if(str[i] < '0' || str[i] > '9') return false;
        }
        return true;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static List<Integer> parseIntegersFromFile(String filePath) throws IOException {
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
        return integers;
    }

    public static void print1Array(List<Integer> toPrint) {
        System.out.print("[");
        for (int i = 0; i < toPrint.size() - 1; i++) {
            System.out.print(toPrint.get(i) + ", ");
        }
        System.out.print(toPrint.get(toPrint.size() - 1));
        System.out.print("]");
        System.out.println();
    }

    /* ------------------------End Utils------------------------ */
    public static void main(String[] args) throws Exception {
        // int[] arr = { 10, 4, 6, 7, 2, 1 };
        // MergeSort ms = new MergeSort(arr);
        // ms.printLast();
        // ms.printAll();
        // ms.getTime();
        // Sort_Array s = new Sort_Array("C:/Users/moham/Desktop/Heap_and_sorting_algorithms/src/10n1.txt");
        // s.Simple_Sort(true);
        // s.Efficient_Sort(true);
        // s.Non_Comparison_Sort(false);
        // s.Heap_Sort(true);

        /* -------------------- Command Line Interface -------------------- */

        clearScreen();
        Sort_Array sorting_object = null;
        MaxHeap m = new MaxHeap();
        Scanner sc = new Scanner(System.in);

        boolean built = false;
        List<Integer> temp_arr = null;
        while(true) {
            String selection0 = "0";
            while(!selection0.equals("1") && !selection0.equals("2") && !selection0.equals("3") && !selection0.equals("4") && !selection0.equals("5")) {
                clearScreen();
                System.out.println(BLACK + "--> " + PURPLE + "1. " + CYAN + "Build Heap" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "2. " + CYAN + "Heap Sort" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "3. " + CYAN + "Extract Max" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "4. " + CYAN + "Insert" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "5. " + CYAN + "Sorting Techniques" + ANSI_RESET);
                selection0 = sc.nextLine();
            }
            if(selection0.equals("5")) break;
            
            
            switch(selection0) {
                case "1": {
                    clearScreen();
                    boolean initialized0 = false;
                    while(!initialized0){
                        clearScreen();
                        System.out.print(GREEN + "Enter the File's Path: " + ANSI_RESET);
                        initialized0 = true;
                        try {
                            String filePath = sc.nextLine();
                            m.buildMaxHeap(parseIntegersFromFile(filePath));
                            temp_arr = parseIntegersFromFile(filePath);
                        } catch (Exception e) {
                            System.out.println("Press any key to try again.");
                            sc.nextLine();
                            initialized0 = false;
                        }
                    }
                    System.out.println("Heap build successfully");
                    built = true;
                    prompt();
                    break;
                }
                case "2": {
                    if(!built) {
                        System.out.println("Heap is not built yet");
                        prompt();
                    } else {
                        HeapSort hs0 = new HeapSort();
                        hs0.sort(MaxHeap.listToArray(temp_arr), false);
                        System.out.println("Sorted array out in HeapOut.txt");
                        m.heapSort(temp_arr);
                        prompt();
                    }
                    break;
                }
                case "3": {
                    if(!built) {
                        System.out.println("Heap is not built yet");
                        prompt();
                    } else {
                        System.out.println("Max: " + m.heapExtractMax());
                        prompt();
                    }
                    break;
                }
                case "4": {
                    if(!built) {
                        System.out.println("Heap is not built yet");
                        prompt();
                    } else {
                        int num = 0;
                        System.out.print("Number to insert: ");
                        num = sc.nextInt();
                        m.maxHeapInsert(num);
                        temp_arr.add(temp_arr.size(), num);
                        System.out.println(num + " Inserted successfully");
                        prompt();
                    }
                    break;
                }
            }
        }
        
        // Initialize the Sorting Object
        boolean initialized = false;
        while(!initialized){
            clearScreen();
            System.out.print(GREEN + "Enter the File's Path: " + ANSI_RESET);
            initialized = true;
            try {
                String filePath = sc.nextLine();
                sorting_object = new Sort_Array(filePath);
            } catch (Exception e) {
                System.out.println("Press any key to try again.");
                sc.nextLine();
                initialized = false;
            }
        }

        while(true) {
            // Main menu
            String selection = "0";
            while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4") && !selection.equals("5")) {
                clearScreen();
                System.out.println(BLACK + "--> " + PURPLE + "1. " + CYAN + "Simple Sort. (Insertion Sort)" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "2. " + CYAN + "Efficient Sort. (Merge Sort)" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "3. " + CYAN + "Non-Comparison Sort. (Counting Sort)" + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "4. " + CYAN + "Heap Sort." + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "5. " + CYAN + "Exit." + ANSI_RESET);
                selection = sc.nextLine();
            }
            if(selection.equals("5")) break;

            // Sub Menu
            String intermediateString = "NAN";
            while(!intermediateString.equals("1") && !intermediateString.equals("2") && !intermediateString.equals("3")) {
                clearScreen();
                System.out.println(BLACK + "--> " + PURPLE + "1. " + CYAN + "Don't show intermediate arrays." + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "2. " + CYAN + "Show intermediate arrays." + ANSI_RESET);
                System.out.println(BLACK + "--> " + PURPLE + "3. " + CYAN + "Back to main menu." + ANSI_RESET);
                intermediateString = sc.nextLine();
            }
            if(intermediateString.equals("3")) continue;

            // Set the Intermediate Flag
            boolean intermediate = false;
            if(intermediateString.equals("1")) intermediate = false;
            else intermediate = true;

            // Sort
            switch(selection) {
                case "1":{
                    sorting_object.Simple_Sort(intermediate);
                    break;
                }
                case "2": {
                    sorting_object.Efficient_Sort(intermediate);
                    break;
                }
                case "3": {
                    sorting_object.Non_Comparison_Sort(intermediate);
                    break;
                }
                case "4": {
                    sorting_object.Heap_Sort(intermediate);
                    break;
                }
                default: break; // this is unreachable
            }

            prompt();

        }

        sc.close();

        /* ---------------------------------------------------------------- */
    }
}

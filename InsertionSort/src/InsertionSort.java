import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertionSort {
    private FileWriter fileWriter = new FileWriter("insertion.txt");

    public InsertionSort() throws IOException {
    }

    int [] sort(int[] arr, int size , boolean intermediate) throws IOException {
         for (int i = 1; i < size; i++) {
             int key = arr[i];
             int j = i - 1;
             while (j >= 0 && arr[j] > key) {
                 arr[j + 1] = arr[j];
                 j--;
             }
             arr[j + 1] = key;
             if (intermediate){
                 print(arr);
             }
         }
         if (!intermediate){
             print(arr);
         }
         return arr;
     }

    private void print(int[] arr) throws IOException {
        PrintWriter printWriter= new  PrintWriter(fileWriter);
        int size =  arr.length;
        printWriter.print("[");
        for (int i = 0 ; i < size; i++){
            printWriter.print(arr[i]);
            if (i < size -1 ){
                printWriter.print(" ,");

            }
        }
        printWriter.print("]");
        printWriter.println();
        printWriter.flush();
    }
    public void close () throws IOException {
        fileWriter.close();
    }
}


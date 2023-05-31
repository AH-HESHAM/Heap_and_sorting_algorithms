import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumbersGenerator {
    public static void main(String[] args) {
        NumbersGenerator ng = new NumbersGenerator();
        ng.generate(10000, "/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000n1.txt");
        ng.upSeq(10000, "/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000up1.txt");
        ng.downSeq(10000, "/home/ahmed/level2term2/Ds2/Heap_and_sorting_algorithms/src/10000down1.txt");
    }

    public void generate(int num, String path) {
        Random randNum = new Random();
        Random randSign = new Random();
        try (FileWriter writer = new FileWriter(path)) {
            for (int i = 0; i < num - 1; i++) {
                int numToAdd = randNum.nextInt(10000);
                if (randSign.nextInt(2) == 1)
                    numToAdd *= -1;
                writer.write(numToAdd + ", ");
            }
            int numToAdd = randNum.nextInt(10000);
            if (randSign.nextInt(2) == 1)
                numToAdd *= -1;
            writer.write(numToAdd + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upSeq(int num, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (int i = 0; i < num - 1; i++) {
                writer.write(i + ", ");
            }
            writer.write((num - 1) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downSeq(int num, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (int i = num - 1; i > 0; i--) {
                writer.write(i + ", ");
            }
            writer.write(0 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* ------------Merge Sort Worst Case Generator------------ */

    static void join(int arr[], int left[], int right[],
                    int l, int m, int r)
    {
        int i;
        for (i = 0; i <= m - l; i++)
            arr[i] = left[i];

        for (int j = 0; j < r - m; j++)
            arr[i + j] = right[j];
    }

    // Function to store alternate elements in left
    // and right subarray
    static void split(int arr[], int left[], int right[],
                     int l, int m, int r)
    {
        for (int i = 0; i <= m - l; i++)
            left[i] = arr[i * 2];

        for (int i = 0; i < r - m; i++)
            right[i] = arr[i * 2 + 1];
    }

    // Function to generate Worst Case of Merge Sort
    static void generateWorstCase(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = l + (r - l) / 2;

            // create two auxiliary arrays
            int[] left = new int[m - l + 1];
            int[] right = new int[r - m];

            // Store alternate array elements in left
            // and right subarray
            split(arr, left, right, l, m, r);

            // Recurse first and second halves
            generateWorstCase(left, l, m);
            generateWorstCase(right, m + 1, r);

            // join left and right subarray
            join(arr, left, right, l, m, r);
        }
    }
}

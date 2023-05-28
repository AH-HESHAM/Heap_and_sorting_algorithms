public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = { 10, 4, 6, 7, 2, 1 };
        MergeSort ms = new MergeSort(arr);
        ms.printLast();
        ms.printAll();
        ms.getTime();
    }
}

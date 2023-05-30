public class Main {
    public static void main(String[] args) {
        int arr [] = {10 , 6 ,2,3,4,8 };
        InsertionSort is = new InsertionSort();
        int SarrI [] =  is.sort(arr , 6, true);
        int Sarr [] = is.sort(arr , 6, false);
    }
}
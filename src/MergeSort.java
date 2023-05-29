import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private int[] arr;
    private ArrayList<ArrayList<int[]>> allArrays = new ArrayList<ArrayList<int[]>>();
    private ArrayList<ArrayList<int[]>> splited = new ArrayList<ArrayList<int[]>>();
    private long time = 0;

    MergeSort(int[] arr) {
        this.arr = new int[arr.length];
        this.arr = arr.clone();
        long start = System.nanoTime();
        sort(0, arr.length - 1, 0);
        time = (System.nanoTime() - start);

    }

    private void sort(int first, int last, int levelnum) {
        if (allArrays.size() < levelnum + 1) {
            allArrays.add(new ArrayList<int[]>());
        }
        if (splited.size() < levelnum + 1) {
            splited.add(new ArrayList<int[]>());
        }
        if (first < last) {
            splited.get(levelnum).add(makeList(first, last));
            int mid = (first + last) / 2;
            sort(first, mid, levelnum + 1);
            sort(mid + 1, last, levelnum + 1);
            int[] temp = merge(first, mid, last);
            allArrays.get(levelnum).add(temp);
        } else {
            int[] lastElem = new int[1];
            lastElem[0] = arr[first];
            allArrays.get(levelnum).add(lastElem);
            splited.get(levelnum).add(lastElem);
        }

    }

    private int[] makeList(int l, int h) {
        long start = System.nanoTime();
        int[] ans = new int[h - l + 1];
        for (int i = l; i <= h; i++) {
            ans[i - l] = arr[i];
        }
        time -= (System.nanoTime() - start);
        return ans;
    }

    private int[] merge(int l, int m, int h) {
        int[] afterMerge = new int[h - l + 1];
        int count = 0;
        int i = l;
        int j = m + 1;
        while (i <= m && j <= h) {
            if (arr[i] < arr[j]) {
                afterMerge[count++] = arr[i++];
            } else {
                afterMerge[count++] = arr[j++];
            }
        }
        while (i <= m) {
            afterMerge[count++] = arr[i++];
        }
        while (j <= h) {
            afterMerge[count++] = arr[j++];
        }
        for (int k = l; k <= h; k++) {
            arr[k] = afterMerge[k - l];
        }
        return afterMerge;
    }

    private void print1Array(int[] toPrint) {
        System.out.print("[");
        for (int i = 0; i < toPrint.length - 1; i++) {
            System.out.print(toPrint[i] + ", ");
        }
        System.out.print(toPrint[toPrint.length - 1]);
        System.out.print("]");
    }

    public void printLast() {
        print1Array(arr);
        System.out.println();
    }

    public void printAll() {
        int n1 = splited.size();
        System.out.println("Splitting");
        System.out.println("|->> initial");
        for (int i = 0; i < n1; i++) {
            int m = splited.get(i).size();
            System.out.print((i + 1) + ") ");
            for (int j = 0; j < m - 1; j++) {
                print1Array(splited.get(i).get(j));
                System.out.print(", ");
            }
            print1Array(splited.get(i).get(m - 1));
            System.out.println();
        }
        int n = allArrays.size();
        System.out.println("merging");
        for (int i = n - 1; i >= 0; i--) {
            int m = allArrays.get(i).size();
            System.out.print((n - i) + ") ");
            for (int j = 0; j < m - 1; j++) {
                print1Array(allArrays.get(i).get(j));
                System.out.print(", ");
            }
            print1Array(allArrays.get(i).get(m - 1));
            System.out.println();
        }
    }

    public void getTime() {
        System.out.println("Time in nano = " + time);
        System.out.println("Time in micro = " + time / 1000);
    }

    public int[] getResult() {
        return this.arr;
    }

}

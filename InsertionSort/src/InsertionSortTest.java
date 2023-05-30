import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {


    @Test
    void getter() {
        int arr [] = {10 , 6 ,2,3,4,8 };
        InsertionSort sa = new InsertionSort();
        assertArrayEquals(new int[]{2, 3, 4, 6, 8, 10}, sa.sort(arr,6,false));
    }
}
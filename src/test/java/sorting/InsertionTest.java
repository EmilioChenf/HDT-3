package test.java.sorting;

import main.java.sorting.InsertionSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**Test de insertionSort con integers */
public class InsertionTest {
    @Test
    public void sort_int(){
        InsertionSort sorter = new InsertionSort();
        int[] array = {5, 2, 3 , 1, 6};
        int[] array_expected = {1, 2, 3, 5, 6};
        sorter.sort(array);
        assertArrayEquals(array_expected, array);
    }
    
}

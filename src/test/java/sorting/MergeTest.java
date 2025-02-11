package test.java.sorting;

import main.java.sorting.MergeSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**Test de MergeSort con integers */
public class MergeTest {
    @Test
    public void sort_int(){
        MergeSort sorter = new MergeSort();
        int[] array = {5, 3, 8, 1, 2};
        int[] array_expected = {1, 2, 3, 5, 8};
        sorter.sort(array);
        assertArrayEquals(array_expected, array);
    }
    
}

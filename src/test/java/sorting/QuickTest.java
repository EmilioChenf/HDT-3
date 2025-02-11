package test.java.sorting;

import main.java.sorting.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**Test de QuickSort con integers */
public class QuickTest {
    @Test
    public void sort_int() {
        QuickSort sorter = new QuickSort();
        int[] array = {5, 3, 8, 1, 2};
        int[] array_expected = {1, 2, 3, 5, 8};
        sorter.sort(array);
        assertArrayEquals(array_expected, array);
    }
}
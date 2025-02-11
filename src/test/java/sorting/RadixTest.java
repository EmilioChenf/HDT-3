package test.java.sorting;

import main.java.sorting.RadixSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**Test de RadixSort con integers */
public class RadixTest {
    @Test
    public void sort_int() {
        RadixSort sorter = new RadixSort();
        int[] array = {5, 3, 8, 1, 2};
        int[] array_expected = {1, 2, 3, 5, 8};
        sorter.sort(array);
        assertArrayEquals(array_expected, array);
    }

}

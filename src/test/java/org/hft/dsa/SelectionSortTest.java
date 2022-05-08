package org.hft.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @Test
    void sort() {
        assertEquals(new int[]{1, 65, 433, 555, 666, 777, 787, 954, 10000}, new SelectionSort().selectionSort(new int[]{1, 666, 10000, 555, 65, 433, 787, 777, 954}));
    }
}

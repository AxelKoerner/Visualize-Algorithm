package org.hft.dsa;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RadixSortTest {

    @Test
    void sort() {
        assertArrayEquals(new int[]{1, 65, 555, 10000}, new Radixsort().radixSort(new int[]{1, 10000, 555, 65}));

    }
}

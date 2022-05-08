package org.hft.dsa;

import static jmonitor.instruments.Order.RANDOM;
import jmonitor.instruments.*;

@Environment
public class selectionSortEnv {
    @Size(values = {0, 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000} )
    int n;

    @Element(order = RANDOM, size_ = "n")
    int[] f;

    SelectionSort SeSo = new SelectionSort();

    @Execution(ops = 0, pause = 1000)
    public void selectionSort(){
        SeSo.selectionSort(f);
    }
    public static void main(String[] args) {
        Monitor.START();
    }
}

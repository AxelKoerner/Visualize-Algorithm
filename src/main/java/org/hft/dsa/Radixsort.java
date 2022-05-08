package org.hft.dsa;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Radixsort {

    private static final int BASE = 10;


    public int[] radixSort(int[] s) {

        final int[][] table = new int[BASE][s.length];
        final int[] nextIndex = new int[BASE];

        int divisor = 1;
        int largestNumber = 1;

        for (int value : s) {                                           //iteriert über alle Werte von s und zählt ihre Ziffern, vergleicht alle Werte und sucht die Zahl mit den meisten Ziffern
            int numberLength = (int) Math.log10(value) + 1;
            if (numberLength > largestNumber) {
                largestNumber = numberLength;
            }
        }

        for(int i = 0; i < largestNumber; i++) {                        //wiederholt den Vorgang so oft wie die größte Zahl, Ziffern hat.

            for (int value : s) {                                       //sortiert die Werte in den Hilfsarray ein

                int radixTmp = (value / divisor) % BASE;
                table[radixTmp][nextIndex[radixTmp]] = value;
                nextIndex[radixTmp]++;
            }
            int index = 0;
            while (index != s.length){                                       //schreibt die Werte aus dem Array wieder in den Input Array
                for (int k = 0; k < BASE; k++) {
                    for (int l = 0; l < nextIndex[k]; l++) {
                        s[index] = table[k][l];
                        index++;
                    }
                }
            }

            divisor *= 10;
            Arrays.fill(nextIndex, 0);
        }

        return s;
    }
}

package org.hft.dsa;

import static jmonitor.instruments.Monitor.*;
public class SelectionSort {

    //SelectionSort - einfacher Algorithmus
    public int[] selectionSort(int[] s) {                    OBSERVE(s);
                                                            EOP("=", "<", "length");
        for (int i = 0; i < s.length; i++) {
                                                            EOP("=", "++", "<");
            int mini = i;                                   EOP("=");
                                                            EOP("=", "<", "length", "+");
            for (int k = i + 1; k < s.length; k++) {
                                                            EOP("=", "+", "<", "length", "++");
                                                            EOP("[]", ">", "[]");
                if (s[mini] > s[k]) {
                    mini = k;                               EOP("=");
                }
            }
                                                            SWAP("=", "[]", "[]", "=", "[]", "[]", "=");
            int t = s[i]; s[i] = s[mini]; s[mini] = t;
        }
        return s;
    }

    //QuickSort - schneller Algorithmus
    public int[] quickSort(int[] in, int begin, int end) {   OBSERVE(in);
                                                            EOP("<");
        if(begin < end) {
            int pivotIndex = partition(in, begin, end);     EOP("=");
            quickSort(in, begin, pivotIndex + 1);      EOP("call", "+");
            quickSort(in, pivotIndex + 1, begin);     EOP("call", "+");
        }                                                   EOP("return");
        return in;
    }

    public int partition (int[] in, int begin, int end){

        int pivot = in[end];                                EOP("=", "[]");
        int i = begin - 1;                                  EOP("=", "-");
                                                            EOP("=", "<");
        for (int j = 0; j < end; j++) {                     //iteriert über alle Elemente der partition und tauscht die Zahlen vor das Pivot Element
                                                            //falls der Wert des Elemnts kleiner ist als der Wert des Pivot Elements
                                                            EOP("=", "<", "++");
            if(in[j] <= pivot) {                            EOP("[]", "<=");
                i++;                                        EOP("++");

                int swapTemp = in[j];                       EOP("=", "[]");
                in[i] = in[j];                              SWAP("[]", "=", "[]");
                in[j] = swapTemp;                           SWAP("[]", "=");
            }
        }

        int swapTemp = in[i+1];                             EOP("=", "[]", "+");
                                                            //am Ende gebe ich den Index der Position des Pivot Elements zurück
        in[i+1] = in[end];                                  SWAP("[]", "+", "=", "[]");
        in[end] = swapTemp;                                 SWAP("[]", "=");
                                                            EOP("return", "+");
    return i+1;
    }

}

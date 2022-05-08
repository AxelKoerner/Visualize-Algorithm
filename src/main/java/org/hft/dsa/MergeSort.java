package org.hft.dsa;

import model.Person;
import model.Reader;

public class MergeSort implements Comparable<Person>{

    //MergeSort
    private String firstName;
    private String lastName;

    @Override
    public int compareTo(Person o) {
        this.lastName = o.getNachname();
        this.firstName = o.getVorname();

        return 0;
    }


    public static Person[] sort(Person[] in) {
        int length = in.length;

        if(length > 1) {                                                            //Abbruchbedingung der Rekursion
            int middle = length / 2;
            Person[] left = new Person[middle];
            Person[] right = new Person[length - middle];

            for (int i = 0; i < middle; i++) {                                      //kopiert die Personen in den Linken und rechten Array
                left[i] = in[i];
            }
            for (int i = middle; i < length; i++) {
                right[i - middle] = in[i];
            }
            sort(left);                                                             //führt sort() methode rekursiv auf den linken und rechten Array aus
            sort(right);
            merge(in, left, right);                                                 //merge funktion um linken und rechten array wieder zusammenzuführen
        }

        return in;
    }

    public static void merge(Person[] in, Person[] left, Person[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0; int j = 0; int k = 0;

        while (i < leftSize && j < rightSize) {
            /* Solange die beiden laufindexe i und j die auf dem rechten und linken Array laufen, nicht gleich der Größe der jeweiligen Arrays sind, vergleiche ein Elemnt
            * aus dem linken und rechten Array. Benutze hier compareToIgnoreCase() um den Datensatz nach Nachnamen alphabetisch zu ordnen. Diese Funktion gibt eine Zahl < 0 zurück
            * falls left[i] über right[j] steht, ansonsten >0. Sortiert dann die Elemente geordnet in Person[] in ein. Somit wurde der übergebene Datensatz "in" sortiert. */
            if(left[i].getNachname().compareToIgnoreCase(right[j].getNachname()) < 0) {       
                in[k++] = left[i++];
            }
            else {
                in[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            in[k++] = left[i++];
        }
        while (j < rightSize) {
            in[k++] = right[j++];
        }
    }



    public static void main(String[] args) {
        Person[] daten;

        System.out.println(" == unsortiert == ");
        daten = Reader.getRawSample();
        for(Person p : daten)
            System.out.println(p);

        System.out.println("\n== sortiert == ");
        MergeSort.sort(daten);

        for(Person p : daten)
            System.out.println(p);
    }
}

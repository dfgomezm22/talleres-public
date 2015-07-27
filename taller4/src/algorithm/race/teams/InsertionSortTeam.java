package algorithm.race.teams;

/*
 * InsertionSortTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import java.util.Arrays;
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public class InsertionSortTeam extends AlgorithmTeam {

    public InsertionSortTeam() {
        super("Insertion sort (*)");
        userDefined = false;
    }

    @Override
    public Comparable[] sort(Comparable[] list, TipoOrdenamiento orden) {
        return insertionSort(list, orden);
    }

    /*
     Ordena un arreglo de enteros, usando Ordenamiento por inserción.
     @param arr Arreglo de enteros.
     **/
    private Comparable[] insertionSort(Comparable[] arr, TipoOrdenamiento orden) {
        for (int i = 1; i < arr.length; i++) //La iteración inicia a partir del primer elemento.
        {
            Comparable x = arr[i];                  //Se selecciona el elemento actual.
            int j = i;                              //Índice que describe el fin del arreglo ordenado parcialmente.
            while (j > 0 && getState(arr[j - 1], x, orden)) //Mientras el elemento anterior sea mayor y el índice actual no sea menor a cero
            {
                arr[j] = arr[j - 1];                  //Se realiza un corrimiento de los elementos a la derecha.
                j--;                                //El índice disminuye.
            }
            arr[j] = x;                              //Se ubica el elemento en la posición correcta.
        }
        return arr;
    }

    private boolean getState(Comparable a, Comparable b, TipoOrdenamiento orden) {
        int stat = a.compareTo(b);
        boolean val = stat > 0 && orden == TipoOrdenamiento.ASCENDENTE;
        val = val || stat < 0 && orden == TipoOrdenamiento.DESCENDENTE;
        return val;
    }
}

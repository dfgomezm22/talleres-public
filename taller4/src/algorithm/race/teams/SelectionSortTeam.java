package algorithm.race.teams;

/*
 * SelectionSortTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import java.util.Arrays;
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public class SelectionSortTeam extends AlgorithmTeam {

    public SelectionSortTeam() {
        super("Selection Sort (*)");
        userDefined = false;
    }

    @Override
    public Comparable[] sort(Comparable[] list, TipoOrdenamiento orden) {
        return selectionSort(list, orden);
    }

    /**
     * Ordena un arreglo de enteros, usando Ordenamiento por selección.
     *
     * @param arr Arreglo de enteros.
    *
     */
    private Comparable[] selectionSort(Comparable[] arr, TipoOrdenamiento orden) {
        int elemPos = 0;                     //Índice de almacenamiento del elemento menor, el área de exploración se encuentra 
        //en el intervalo (elemPos, arr.length-1]
        while (elemPos < arr.length) //Mientras el arreglo no haya sido ordenado
        {
            Comparable minElem = null;           //Variable que almacena el elemento menor presente en el área restante del arreglo.
            int pos = elemPos;                     //Variable que almacena el índice del mínimo encontrado.
            for (int i = elemPos; i < arr.length; i++) //Se exploran los elementos presentes en el intervalo
            {
                int stat = 0;
                boolean val = false;
                if (minElem != null) {
                    stat = arr[i].compareTo(minElem);
                    val = stat < 0 && orden == TipoOrdenamiento.ASCENDENTE;
                    val |= stat > 0 && orden == TipoOrdenamiento.DESCENDENTE;
                } else {
                    val = true;
                }
                if (val) //Si el elemento actual es menor que el mínimo reportado
                {
                    pos = i;                //Se reemplaza el mínimo reportado
                    minElem = arr[i];
                }
            }
            Comparable temp = arr[elemPos];         //Se inserta el mínimo global hallado en la posición correspondiente
            arr[elemPos] = minElem;
            arr[pos] = temp;
            elemPos++;                       //Se reduce el área de exploración
        }
        return arr;
    }
}

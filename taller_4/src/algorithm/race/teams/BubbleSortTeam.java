package algorithm.race.teams;

/*
 * BubbleSortTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import java.util.Arrays;
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public class BubbleSortTeam extends AlgorithmTeam {

    public BubbleSortTeam() {
        super("Bubble sort (*)");
        userDefined = false;
    }

    @Override
    public Comparable[] sort(Comparable[] list, TipoOrdenamiento orden) {
        return bubbleSort(list, orden);
    }

    /**
     * Ordena un arreglo de enteros, usando Bubble Sort.
     *
     * @param arr Arreglo de enteros.
     *
     */
    private Comparable[] bubbleSort(Comparable[] arr, TipoOrdenamiento orden) {
        int n = arr.length;           //Índice límite de exploración
        while (n > 0) //Mientras no se haya explorado todo el arreglo
        {
            int nTemp = 0;                 //Variable de límite actual, si se intercambian elementos, 
            //no es necesario volver a visitar el elemento mayor.
            for (int i = 0; i < n - 1; i++) //Exploración al interior del área.
            {
                int stat = arr[i].compareTo(arr[i + 1]);
                boolean val = stat > 0 && orden == TipoOrdenamiento.ASCENDENTE;
                val = val || stat < 0 && orden == TipoOrdenamiento.DESCENDENTE;
                if (val) //Es mayor el primer elemento.
                {
                    Comparable temp = arr[i];     //Intercambiar elementos
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    nTemp = i + 1;           //Límite actual
                }
            }
            n = nTemp;                     //Ahora el máximo tamaño corresponde a la posición del último elemento ordenado
        }
        return arr;
    }
}

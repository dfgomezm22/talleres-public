package algorithm.race.teams;

/*
 * MergeSortTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team
 *
 */
import java.util.Arrays;
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public class MergeSortTeam extends AlgorithmTeam {

    public MergeSortTeam() {
        super("Merge sort");
        userDefined = true;
    }

    @Override
    public Comparable[] sort(Comparable[] list, TipoOrdenamiento orden) {
        return mergeSort(list, orden);
    }

    private Comparable[] mergeSort(Comparable[] lista, TipoOrdenamiento orden) {
        /**
         * A continuación, es posible observar el pseudocódigo de Merge sort.
         * Esta versión es equivalente a la versión implementada en
         * SampleMergeSortTeam proceso de segmentación del arreglo puede ser
         * realizado de forma concurrente, a través del uso de Hilos de
         * ejecución.
         *
         * procedimiento merge_sort(lista : Lista, orden : TipoOrdenamiento) Si
         * longitud(lista) es 1: return lista Opción 1: Implementación paralela
         * Si longitud(lista) > 2: Iniciar un hilo de ejecución y ejecutar:
         * izquierda : Lista -> merge_sort(lista, orden) Más información para
         * retornar un resultado obtenido en la ejecución de un hilo:
         * http://stackoverflow.com/questions/9148899/returning-value-from-thread
         * derecha : Lista -> merge_sort(lista, orden, mitad, fin) De lo
         * contrario, usar la opción 2. Opción 2: Equivalente a la versión del
         * sistema. derecha : Lista -> merge_sort(lista, orden, inicio, mitad)
         * izquierda : Lista -> merge_sort(lista, orden, mitad, fin) lista =
         * merge(lista, orden, derecha, izquierda) return lista
           *
         */

        //TODO Implemente el pseudocódigo que describe el procedimiento de merge_sort.
        return lista;
    }

    private Comparable[] merge(TipoOrdenamiento orden, Comparable[] derecha, Comparable[] izquierda) {
        /**
         * Este procedimiento tiene como objetivo, mezclar dos listas que se
         * encuentran parcialmente ordenadas.
         *
         * function merge(orden : TipoOrdenamiento, derecha : Lista, izquierda :
         * Lista) i : Int -> longitud(izquierda) j : Int -> longitud(derecha)
         *
         * resultado : Lista -> Lista[longitud(izquierda)+longitud(derecha)] pos
         * : Int -> 0
         *
         * Mientras i < longitud(izquierda) y j < longitud(derecha) Si
         * izquierda[i] < derecha[j]       //Si el ordenamiento es DESCENDENTE debe ser izquierda[i]
         * > derecha[j] resultado[pos] = izquierda[i] Incrementar i De lo
         * contrario resultado[pos] = derecha[j] Incrementar j Incrementar pos
         *
         * Mientras i < longitud(izquierda) resultado[pos] = izquierda[i]
         * Incrementar i y pos
         *
         * Mientras j < longitud(derecha) resultado[pos] = derecha[j]
         * Incrementar j y pos
         *
         * return resultado
          *
         */

        //TODO Implementar merge.
        return new Comparable[izquierda.length + derecha.length];
    }
}

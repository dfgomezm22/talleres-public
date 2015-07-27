package algorithm.race.teams;

/*
 * QuickSortTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import java.util.Arrays;
import java.util.Random;
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public class QuickSortTeam extends AlgorithmTeam {

    private Random random = new Random();

    public QuickSortTeam() {
        super("Quicksort");
        userDefined = true;
    }

    @Override
    public Comparable[] sort(Comparable[] list, TipoOrdenamiento orden) {
        quicksort(list, 0, list.length, orden);
        return list;
    }

    private void quicksort(Comparable[] lista, int inicio, int fin, TipoOrdenamiento orden) {
        /**
         * A continuación, se presenta una implementación de Quicksort. Esta
         * implementación difiere de la implementación presentada por el
         * sistema, en la medida que el pro- cedimiento de partición se realiza
         * sin crear listas de uso auxiliar. Al igual que la implementación de
         * Merge Sort, es posible realizar el proceso de forma paralela.
         *
         * procedimiento quicksort(lista : Lista, inicio : Int, final : Int,
         * orden : TipoOrdenamiento) Si final-inicio <= 1
         * return lista
         * pivote : Int -> particion(lista, inicio, fin, orden) Opción 1:
         * Implementación paralela Si final-inicio > 2 Iniciar un hilo de
         * ejecución y ejecutar quicksort(lista, inicio, pivote, orden)
         * quicksort(lista, pivote+1, final, orden) De lo contrario, usar la
         * opción 2. Opción 2: Implementación estándar quicksort(lista, inicio,
         * pivote, orden) quicksort(lista, pivote+1, final, orden)
           *
         */
    }

    private int particion(Comparable[] lista, int inicio, int fin, TipoOrdenamiento orden) {
        /**
         * El presente procedimiento ordena los elementos de una lista de
         * acuerdo a un pivote o valor de referencia bien elegido; los elementos
         * mayores al pivote deben ser ubi- cados a la derecha del mismo, los
         * elementos menores, a la izquierda.
         *
         * procedimiento particion(lista : Lista, inicio : Int, fin : Int, orden
         * : TipoOrdenamiento) indicePivote : Int -> eleccionPivote(inicio, fin)
         * //El procedimiento de elección puede ser aleatorio. Intercambiar
         * lista[inicio] y lista[indicePivote]
         *
         * pivote : Comparable -> lista[inicio]
         *
         * i : Int -> inicio+1 Desde j = inicio+1 hasta fin Si lista[j] < pivote
         * Intercambiar lista[j] y lista[i] Incrementar i Intercambiar
         * lista[inicio] y lista[i-1] return i-1
          *
         */
        return 0;
    }

    private int elecciónPivote(int inicio, int fin) {
        /**
         * Este procedimiento realiza la elección de un índice que corresponde
         * al pivote res- pecto al cual se realizaría la partición de la lista.
         * Se recomienda escoger el ele- mento que se encuentra en la mitad, o
         * de forma aleatoria entre los índices [inicio, fin).
          *
         */

        return 0;
    }

    /**
     * Retorna un número aleatorio que se encuentra en el intervalo [min, max];
     * inclusivo.
     *
     * @param min, índice inicial del intervalo.
     * @param max, índice final del intervalo.
     * @return Un número aleatorio en el intervalo [min, max].
    *
     */
    public int randInt(int min, int max) {
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}

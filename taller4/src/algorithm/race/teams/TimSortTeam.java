package algorithm.race.teams;

/*
 * TimSortTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import java.util.Arrays;
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public class TimSortTeam extends AlgorithmTeam {

    public TimSortTeam() {
        super("Timsort (*)");
        userDefined = false;
    }

    @Override
    public Comparable[] sort(Comparable[] list, TipoOrdenamiento orden) {
        Arrays.sort(list);
        if (orden == TipoOrdenamiento.DESCENDENTE) {
            return reverseArray(list);
        }
        return list;
    }

    public Comparable[] reverseArray(Comparable[] list) {
        for (int i = 0; i < list.length / 2; i++) {
            Comparable temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
        return list;
    }
}

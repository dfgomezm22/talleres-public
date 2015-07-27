package algorithm.race.teams;

/*
 * AlgorithmTeam.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import static algorithm.race.AlgorithmTournament.TipoOrdenamiento;

public abstract class AlgorithmTeam implements Comparable<AlgorithmTeam> {

    public String name;
    public double time;
    public String timeFormat;
    public double accuracy;
    protected boolean userDefined = true;

    public abstract Comparable[] sort(Comparable[] list, TipoOrdenamiento orden);

    public AlgorithmTeam(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%25s | %10s | %12g", name, timeFormat, accuracy); //"Equipo: "+name;//String.format("Equipo: %s | Posición %d | Tiempo total: %.2fs", name, overallPosition, time);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(AlgorithmTeam t) {
        if (time > t.time) {
            return 1;
        } else if (time == t.time) {
            return 0;
        } else {
            return -1;
        }
    }

}

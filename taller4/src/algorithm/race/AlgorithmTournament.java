package algorithm.race;

/*
 * AlgorithmTournament.java
 * This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 */
import java.io.File;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import algorithm.race.teams.*;
import java.io.BufferedReader;
import java.util.PriorityQueue;

public class AlgorithmTournament {

    private PriorityQueue<AlgorithmTeam> positionTable = new PriorityQueue<AlgorithmTeam>();
    private File[] fileList;
    private String username;
    private int runs = 5;
    private int max_size = 50000;
    private int max_file;
    private Random random = new Random();
    private Stopwatch chronometre;
    private TipoOrdenamiento tipoOrdenamiento = TipoOrdenamiento.ASCENDENTE;

    private TimeReference timeUnits;
    private ArrayList<AlgorithmTeam> teamList;

    public AlgorithmTournament() {
        File path = new File("./data/unsorted");
        fileList = path.listFiles();

        teamList = new ArrayList<AlgorithmTeam>();
        teamList.add(new QuickSortTeam());
        teamList.add(new ShellSortTeam());
        teamList.add(new InsertionSortTeam());
        teamList.add(new MergeSortTeam());
        teamList.add(new SelectionSortTeam());
        teamList.add(new TimSortTeam());
        teamList.add(new BubbleSortTeam());

        //TODO Agregue su equipo.
        Arrays.sort(fileList);
        timeUnits = TimeReference.SECONDS;
        max_file = Integer.parseInt(fileList[fileList.length - 1].getName().split("[.]")[0]);

        chronometre = new Stopwatch(timeUnits);

        tipoOrdenamiento = TipoOrdenamiento.ASCENDENTE;
    }

    public void setOrder(TipoOrdenamiento tipo) {
        tipoOrdenamiento = tipo;
    }

    public String currentOrder() {
        return tipoOrdenamiento == TipoOrdenamiento.ASCENDENTE ? "Ascendente" : "Descendente";
    }

    public boolean login() {
        return username != null;
    }

    public String userLogin(String user) {
        username = user;
        return "";
    }

    public int getTotalRuns() {
        return runs;
    }

    public void setTotalRuns(int tRuns) {
        runs = tRuns;
    }

    public void setTimeUnits(TimeReference units) {
        timeUnits = units;
    }

    public String getTimeUnits() {
        return timeUnits == TimeReference.SECONDS ? "Segundos" : "Minutos";
    }

    public int getMaxSize() {
        return max_size;
    }

    public void setMaxSize(int maxSize) {
        max_size = maxSize;
    }

    public String[] getTeamList() {
        String[] teams = new String[teamList.size()];
        int i = 0;
        for (AlgorithmTeam team : teamList) {
            teams[i] = team.name;
            i++;
        }
        return teams;
    }

    public void removeTeam(int index) {
        teamList.remove(index);
    }

    public void reset() {
        max_size = 25000;
        runs = 5;
        tipoOrdenamiento = TipoOrdenamiento.ASCENDENTE;
    }

    public int randInt(int min, int max) {
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public Comparable[] defineList(int size, int fileIndex) {
        Comparable[] arr = new Comparable[size];
        File f = fileList[fileIndex];
        try (BufferedReader br = new BufferedReader(new FileReader("./data/unsorted/" + f.getName()))) {
            String inputLine;
            int i = 0;
            while ((inputLine = br.readLine()) != null && i < size) {
                arr[i] = Integer.parseInt(inputLine);
                i++;
            }
        } catch (Exception e) {
        }
        return arr;
    }

    public double verifySorting(Comparable[] reference_list, Comparable[] list) {
        double accuracy = 0.0;
        for (int i = 0; i < reference_list.length; i++) {
            if (reference_list[i].compareTo(list[i]) == 0) {
                accuracy += 1;
            }
        }
        return 100.0 * (accuracy / list.length);
    }

    public Comparable[] reverseArray(Comparable[] list) {
        for (int i = 0; i < list.length / 2; i++) {
            Comparable temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
        return list;
    }

    public void startTournament() {
        for (int i = 1; i < runs + 1; i++) {
            positionTable.clear();
            int fileIndex = randInt(0, max_file - 1);
            int size = map(i, 1, runs, 100, max_size);
            System.out.println(String.format("\nRonda %d | Tamaño bolsa: %d Elementos\n", i, size));
            Comparable[] list = defineList(size, fileIndex);
            Comparable[] unsorted = Arrays.copyOf(list, list.length);
            Arrays.sort(unsorted);
            unsorted = tipoOrdenamiento == TipoOrdenamiento.ASCENDENTE ? unsorted : reverseArray(unsorted);

            for (AlgorithmTeam team : teamList) {
                System.out.println("Turno Actual: " + team.name);
                chronometre.restartTime();
                Comparable[] sortedList = team.sort(Arrays.copyOf(list, list.length), tipoOrdenamiento);
                double time = chronometre.elapsedTime();
                team.time = time;
                team.timeFormat = formatTime(time);
                team.accuracy = verifySorting(unsorted, sortedList);
                positionTable.add(team);
            }
            int pos = 1;
            System.out.printf("\n%30s | %10s | %12s\n", "Equipo", "Tiempo", "Efectividad");
            while (positionTable.size() > 0) {
                AlgorithmTeam team = positionTable.poll();
                System.out.printf("%3d. %s\n", pos, team.toString());
                pos++;
            }
        }
    }

    public int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public String formatTime(double time) {
        if (timeUnits == TimeReference.SECONDS) {
            return String.format("%.5fs", time);
        } else {
            return String.format("%dm%ds", (time / 60) % 60, time % 60);
        }
    }

    public static class AlgorithmException extends Exception {

        public AlgorithmException(String msg) {
            super(msg);
        }
    }

    public static enum TimeReference {

        SECONDS, MINUTES
    }

    public static enum TipoOrdenamiento {

        ASCENDENTE, DESCENDENTE
    }

}

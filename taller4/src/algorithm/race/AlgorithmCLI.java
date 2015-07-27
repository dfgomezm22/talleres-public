package algorithm.race;

/**
 * AlgorithmCLI.java This file is part of AlgorithmRace
 *
 * Copyright (C) 2015 - ISIS1206 Team
 *
 */
import java.util.Scanner;

public class AlgorithmCLI {

    private AlgorithmTournament tournament;
    private Scanner in;

    public AlgorithmCLI() {
        tournament = new AlgorithmTournament();
        in = new Scanner(System.in);
    }

    public void mainMenu() {
        boolean finish = false;
        while (!finish) {
            Screen.clear();
            System.out.println("------------------------------------------");
            System.out.println("-                                        -");
            System.out.println("-    Carrerítmica: Orden y eficiencia    -");
            System.out.println("-                                        -");
            System.out.println("------------------------------------------");
            System.out.println("¡Bienvenido a la segunda carrera más importante de ordenamiento en el hemisferio occidental!\n");

            System.out.println("Menú principal:");
            System.out.println("-----------------");
            System.out.println("1. Iniciar pruebas y competencias");
            System.out.println("2. Configuración y ajustes");
            System.out.println("3. Extra: El lado oscuro de Quicksort");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opt1 = in.nextInt();
            switch (opt1) {
                case 1:
                    tournamentMenu();
                    break;
                case 2:
                    configureTournament();
                    break;
                case 3:
                    break;
                case 4:
                    finish = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void tournamentMenu() {
        boolean finish = false;
        while (!finish) {
            Screen.clear();
            System.out.println("Menú general del torneo");
            System.out.println("-----------------------");
            System.out.println("1. Ver equipos inscritos");
            System.out.println("2. Iniciar torneo");
            System.out.println("3. Torneo avanzado: Mezcla completa");
            System.out.println("4. Regresar al menú principal");
            System.out.print("\nSeleccione una opción: ");
            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    displayTeams();
                    break;
                case 2:
                    tournament.startTournament();
                    in.nextLine();
                    System.out.print("\nFin del Torneo. Presione cualquier tecla para continuar...");
                    in.nextLine();
                    break;
                case 3:
                    //TODO
                    break;
                case 4:
                    finish = true;
                    break;
            }
        }
    }

    public void displayTeams() {
        boolean finish = false;
        while (!finish) {
            Screen.clear();
            String[] teams = tournament.getTeamList();
            System.out.println("Lista de equipos inscritos");
            System.out.println("--------------------------");
            int index = 1;
            if (teams.length >= 1) {
                for (String team : teams) {
                    System.out.println(String.format("%d. %s", index, team));
                    index++;
                }
                System.out.println(String.format("%d. Regresar al menú anterior", index));
                System.out.println("Si desea eliminar un equipo, ingrese el número correspondiente.");
                System.out.print("Seleccione una opción: ");
                int opt = in.nextInt();
                if (opt == index) {
                    finish = true;
                } else if (opt < index && opt > 0) {
                    tournament.removeTeam(opt - 1);
                }
            } else {
                System.out.println("Actualmente no existen equipos registrados. Debe registrar al menos un equipo\n para poder participar.");
                System.out.print("Presione cualquier tecla para regresar...");
                in.nextLine();
                finish = true;
            }
        }
    }

    public void configureTournament() {
        boolean finish = false;
        while (!finish) {
            Screen.clear();
            System.out.println("Configuración y ajustes del torneo");
            System.out.println("----------------------------------");
            System.out.println("1. Establecer el criterio de orden");
            System.out.println("2. Ajustar el número máximo de rondas");
            System.out.println("3. Establecer el tamaño máximo de las listas por ronda");
            System.out.println("4. Unidades de registro de tiempo");
            System.out.println("5. Reestablecer ajustes");
            System.out.println("6. Regresar al menú principal");
            System.out.print("\nSeleccione una opción: ");
            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    setOrder();
                    break;
                case 2:
                    in.nextLine();
                    int numRounds = tournament.getTotalRuns();
                    System.out.println("El número actual de rondas es : " + numRounds);
                    System.out.print("Ingrese el nuevo número de rondas a disputar (Máximo 80): ");
                    int numR = in.nextInt();
                    tournament.setTotalRuns(numR);
                    break;
                case 3:
                    in.nextLine();
                    int maxSize = tournament.getMaxSize();
                    System.out.println("El tamaño máximo de la bolsa es de : " + maxSize);
                    System.out.print("Ingrese el nuevo tamaño máximo de cada bolsa (Máximo 50000): ");
                    int numS = in.nextInt();
                    tournament.setMaxSize(numS);
                    break;
                case 4:
                    setTimeUnits();
                    break;
                case 5:
                    in.nextLine();
                    System.out.println("Reestableciendo ajustes...");
                    tournament.reset();
                    break;
                case 6:
                    finish = true;
                    break;
            }
        }
    }

    public void setTimeUnits() {
        boolean finish = false;
        while (!finish) {
            Screen.clear();
            System.out.println("Unidades de tiempo usadas en el registro de resultados");
            System.out.println("-------------------------------------------------------\n");
            System.out.println(String.format("Unidades actualmente en uso: %s\n", tournament.getTimeUnits()));
            System.out.println("1. Realizar el registro en Segundos");
            System.out.println("2. Realizar el registro en Minutos");
            System.out.println("3. Regresar al menú anterior");
            System.out.print("\nSeleccione una opción: ");

            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    tournament.setTimeUnits(AlgorithmTournament.TimeReference.SECONDS);
                    break;
                case 2:
                    tournament.setTimeUnits(AlgorithmTournament.TimeReference.MINUTES);
                    break;
                case 3:
                    finish = true;
                    break;
            }

        }
    }

    public void setOrder() {
        boolean finish = false;
        while (!finish) {
            Screen.clear();
            System.out.println("Criterio de orden usado en el torneo");
            System.out.println("-------------------------------------------------------\n");
            System.out.println(String.format("Criterio de orden actual: %s\n", tournament.currentOrder()));
            System.out.println("1. Ordenar de forma Ascendente");
            System.out.println("2. Ordenar de forma Descendente");
            System.out.println("3. Regresar al menú anterior");
            System.out.print("\nSeleccione una opción: ");

            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    tournament.setOrder(AlgorithmTournament.TipoOrdenamiento.ASCENDENTE);
                    break;
                case 2:
                    tournament.setOrder(AlgorithmTournament.TipoOrdenamiento.DESCENDENTE);
                    break;
                case 3:
                    finish = true;
                    break;
            }

        }
    }

}

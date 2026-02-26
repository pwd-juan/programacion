package Vuelos;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static LinkedList<Vuelo> vuelos = new LinkedList<>();

    public static void main(String[] args) {
        anyadirVueloBasicos(vuelos);
        Scanner sc = new Scanner(System.in);
        boolean tiempoEjecucion = true;
        String selecUsu;

        while (tiempoEjecucion) {
            menu();
            selecUsu = sc.nextLine();

            switch (selecUsu) {
                case "1" -> {
                    for (Vuelo x : vuelos) {
                        System.out.println(x);
                    }
                }
                case "2" -> {
                    System.out.print("\n");
                    System.out.println("BUSCAR VUELO POR Nº: ");

                    if (vuelos.isEmpty()) {
                        System.out.println("No existen vuelos.");
                        break;
                    }

                    System.out.print("Número de vuelo: ");
                    selecUsu = sc.nextLine();
                    System.out.print("\n");

                    for (Vuelo x : vuelos) {
                        if (x.getNumero().equals(selecUsu)) System.out.println(x);
                    }
                }
                case "3" -> ;
                case "4" -> ;
                case "5" -> ;
                case "0" -> tiempoEjecucion = false;
                default -> {

                }
            }
        }
    }

    public static void menu(){
        System.out.println("=======================================");
        System.out.println("   VUELOS DEL AEROPUERTO DE VALENCIA   ");
        System.out.println("=======================================");
        System.out.println(" 1 - Imprimir todos los vuelos");
        System.out.println(" 2 - Buscar un número de vuelo");
        System.out.println(" 3 - Buscar vuelo por clave");
        System.out.println(" 4 - Añadir vuelo nuevo");
        System.out.println(" 5 - Borrar vuelo por número");
        System.out.println(" 0 - SALIR");
        System.out.println("---------------------------------------");
        System.out.print("Dame la opción: ");
    }

    public static void anyadirVueloBasicos(LinkedList<Vuelo> vuelos) {
        vuelos.add(new Vuelo(
                "2023-01",
                "Valencia",
                "Menorca",
                "15-08",
                "Turista"
        ));

        vuelos.add(new Vuelo(
                "2023-02",
                "Valencia",
                "Tenerife",
                "20-08",
                "Turista"
        ));

        vuelos.add(new Vuelo(
                "2023-03",
                "París",
                "Valencia",
                "15-08",
                "Primera"
        ));

        vuelos.add(new Vuelo(
                "2023-04",
                "Atenas",
                "Valencia",
                "20-08",
                "Primera"
        ));
    }
}

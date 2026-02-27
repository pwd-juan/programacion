package Vuelos;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static LinkedList<Vuelo> vuelos = new LinkedList<>();

    public static void main(String[] args) {
        anyadirVueloBasicos(vuelos);
        Scanner sc = new Scanner(System.in);
        boolean tiempoEjecucion = true;
        int indiceVueloEncontrado;
        String selecUsu;
        String selecUsuAux;

        while (tiempoEjecucion) {
            menu();
            selecUsu = sc.nextLine();

            switch (selecUsu) {
                case "1" -> {
                    System.out.print("\n");

                    System.out.println("DATOS DE LOS VUELOS: ");
                    if (vuelos.isEmpty()) System.out.println("No existen vuelos.");

                    for (Vuelo x : vuelos) {
                        System.out.println(x);
                    }

                    System.out.print("\n");
                }
                case "2" -> {
                    indiceVueloEncontrado = -1;

                    System.out.print("\n");
                    System.out.println("BUSCAR VUELO POR Nº: ");
                    System.out.print("Número de vuelo: ");
                    selecUsu = sc.nextLine();
                    System.out.print("\n");

                    for (int i = 0; i < vuelos.size(); i++)
                        if (vuelos.get(i).getNumero().equals(selecUsu)) indiceVueloEncontrado = i;

                    if (vuelos.isEmpty()) {
                        System.out.println("No existen vuelos.");
                    } else if (indiceVueloEncontrado != -1) {
                        System.out.println("Datos del vuelo: ");
                        System.out.println(vuelos.get(indiceVueloEncontrado));
                    } else {
                        System.out.println("El número de vuelo no existe.");
                    }
                }
                case "3" -> {
                    System.out.print("\n");
                    System.out.println("BUSCAR VUELO POR CLAVE: ");
                    System.out.print("Clave: ");
                    selecUsu = sc.nextLine();
                    System.out.print("Valor: ");
                    selecUsuAux = sc.nextLine();
                    System.out.print("\n");

                    selecUsu = selecUsu.toUpperCase();

                    if (vuelos.isEmpty()) {
                        System.out.println("No existen vuelos.");
                    } else if (!vuelos.get(0).getValores().containsKey(selecUsu)) {
                        System.out.println("Lo siento pero la clave no existe.");
                    } else {
                        int salidas = vuelos.size();
                        for (Vuelo x : vuelos){
                            if (x.getValores().get(selecUsu).equalsIgnoreCase(selecUsuAux)){
                                System.out.println("Datos del vuelo: ");
                                System.out.println(x);
                                salidas--;
                            }
                        }
                        if (salidas == vuelos.size())
                            System.out.printf(
                                "No existen datos para (%s = %s).\n",
                                selecUsu,
                                selecUsuAux
                            );
                    }
                }
                case "4" -> {
                    Vuelo v = new Vuelo();

                    System.out.print("\n");
                    System.out.println("AÑADIR NUEVO VUELO: ");

                    System.out.print("Número: ");
                    selecUsu = sc.nextLine();
                    v.setNumero(selecUsu);

                    System.out.print("Origen: ");
                    selecUsu = sc.nextLine();
                    v.setOrigen(selecUsu);

                    System.out.print("Destino: ");
                    selecUsu = sc.nextLine();
                    v.setDestino(selecUsu);

                    System.out.print("Día: ");
                    selecUsu = sc.nextLine();
                    v.setDia(selecUsu);

                    System.out.print("Clase: ");
                    selecUsu = sc.nextLine();
                    v.setClase(selecUsu);

                    vuelos.add(v);

                    System.out.println("Vuelo añadido a la lista.");
                }
                case "5" -> {
                    indiceVueloEncontrado = -1;

                    System.out.print("\n");
                    System.out.println("BORRAR VUELO: ");
                    System.out.print("Número de vuelo: ");
                    selecUsu = sc.nextLine();
                    System.out.print("\n");

                    for (int i = 0; i < vuelos.size(); i++)
                        if (vuelos.get(i).getNumero().equals(selecUsu)) indiceVueloEncontrado = i;

                    if (vuelos.isEmpty()) {
                        System.out.println("No existen vuelos.");
                    } else if (indiceVueloEncontrado != -1) {
                        System.out.println("Vuelo nº " + selecUsu + " eliminado.");
                        vuelos.remove(indiceVueloEncontrado);
                    } else {
                        System.out.println("El número de vuelo no existe.");
                    }
                }
                case "0" -> tiempoEjecucion = false;
                default -> {
                    System.out.print("\n");
                    System.out.println("Debes elegir una opción del menu.");
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

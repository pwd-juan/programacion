package Ejer11.Mejora;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clasificacion c = new Clasificacion(
            "src/Ejer11/Mejora/Datos/jugadores.txt",
            "src/Ejer11/Mejora/Datos/clasificacion.csv"
        );
        String path = "src/Ejer11/Mejora/";
        Scanner sc = new Scanner(System.in);
        String entrada;
        String nombreArchivo;
        StringBuilder datos;
        boolean tiempoEjecucion = true;

        while (tiempoEjecucion) {
            entrada = menu(sc).toUpperCase();
            datos = new StringBuilder();

            switch (entrada) {
                case "1" -> {
                    nombreArchivo = pedirNombreArchivo(sc);

                    datos.append(
                        String.format(
                            "%-7s | %-50s %n",
                            "Ranking",
                            "Nombre"
                        )
                    );
                    datos.append(String.format("%-7s | %-50s %n", "", ""));
                    datos.append(c.obtenerJugadoresDeCV("%-7d | %-50s %n"));

                    almacenar(path + nombreArchivo, datos.toString());
                }
                case "2" -> {
                    nombreArchivo = pedirNombreArchivo(sc);

                    datos.append(
                        String.format(
                            "%-7s | %-50s %n",
                            "Ranking",
                            "Nombre"
                        )
                    );
                    datos.append(String.format("%-7s | %-50s %n", "", ""));
                    datos.append(c.obtenerJugadoresAlojados("%-7d | %-50s %n"));

                    almacenar(path + nombreArchivo, datos.toString());
                }
                case "3" -> {
                    nombreArchivo = pedirNombreArchivo(sc);

                    datos.append(
                        String.format(
                            "| %-8s | %-50s | %-9s | %-6s |",
                            "Posición",
                            "Nombre",
                            "ELO FIDE",
                            "Puntos"
                        )
                    );
                    datos.append(String.format("| %-8s | %-50s | %-9s | %-6s |", "", "", "", ""));
                    datos.append(c.obtenerClasificaciones("| %-8d | %-50s | %-9d | %6.1f | %n"));

                    almacenar(path + nombreArchivo, datos.toString());
                }
                case "Q" -> tiempoEjecucion = false;
                default -> System.out.println("\nOpción no valida.");
            }
        }

        sc.close();
    }

    private static String menu(Scanner sc) {
        System.out.println("0==============================0");
        System.out.println("|           Opciones           |");
        System.out.println("}  -----      ----      -----  {");
        System.out.println("|  [1] Jugadores de CV         |");
        System.out.println("|  [2] Jugadores alojados      |");
        System.out.println("|  [3] Ranking                 |");
        System.out.println("|  [Q] Salir                   |");
        System.out.println("0==============================0");

        System.out.print("Que desea hacer: ");
        return sc.nextLine().trim();
    }

    private static String pedirNombreArchivo(Scanner sc) {
        System.out.print("Dale un nombre al archivo: ");
        return sc.nextLine().trim();
    }

    private static void almacenar(String path, String datos) {
        try {
            PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new FileWriter(path)
                )
            );
            pw.print(datos);
            pw.close();
        } catch (IOException e) {
            System.err.println("Ha sucedido un error al guardar el archivo.");
        }
    }
}
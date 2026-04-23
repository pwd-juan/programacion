package Ejer11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clasificacion c = new Clasificacion(
            "src/Ejer11/jugadores.txt",
            "src/Ejer11/clasificacion.csv"
        );
        String path = "src/Ejer11/";
        Scanner sc = new Scanner(System.in);

        c.almacenarPorCSV();

        System.out.print("Dime el nombre del archivo: ");
        path = path + sc.nextLine().trim();

        try {
            PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new FileWriter(path)
                )
            );

            pw.println(
                    String.format(
                            "| %-8s | %-50s | %-9s | %-6s |",
                            "Posición",
                            "Nombre",
                            "ELO FIDE",
                            "Puntos"
                    )
            );
            pw.println(String.format("| %-8s | %-50s | %-9s | %-6s |", "", "", "", ""));
            pw.print(c.obtenerClasificaciones("| %-8d | %-50s | %-9d | %6.1f | %n"));
            pw.close();

        } catch (IOException e) {
            System.err.println("No se encontró la ruta del archivo.");
        }

        sc.close();
    }
}
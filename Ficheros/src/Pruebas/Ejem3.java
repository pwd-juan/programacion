package Pruebas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(new FileWriter("src/Pruebas/Files/ejem3.txt"))
            );
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            String cadena;
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                pw.println(cadena);
                cadena = sc.nextLine();
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

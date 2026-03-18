package Ejer1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("src/Ejer1/fichero")
                    )
            );
            for (int i = 0; i < 100; i++) {
                pw.println(i);
            }
            pw.close();
        } catch (IOException e) {
            System.err.println(
                    "Error al encontrar el archivo: "
                    + e.getMessage()
            );
        }
    }
}

package Ejer3;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String path = "src/Ejer3/primos.dat";

        escribir500PrimerosPrimo(path);
        leerFichero(path);
    }

    public static void escribir500PrimerosPrimo(String path) {
        try {
            PrintWriter fw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(path)
                    )
            );

            for (int i = 1; i <= 500; i++) {
                if (i % 2 != 0) fw.println(i);
            }

            fw.close();
        } catch (IOException e) {
            System.err.println("No se encontro el archivo.");
        }
    }

    public static void leerFichero(String path) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(path));
            String linea;
            do {
                linea = buff.readLine();
                if (linea != null) System.out.println(linea);
            } while (linea != null);
            buff.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo. ");
        }
    }
}

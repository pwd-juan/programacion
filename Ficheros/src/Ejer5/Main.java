package Ejer5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "src/Ejer5/";
        ArrayList<String> palabras;

        palabras = obtenerPalabras(path + "file1");

        palabras.sort(null);
        crearArchivo(path + "file2", palabras);
    }

    public static ArrayList<String> obtenerPalabras(String path) {
        ArrayList<String> palabras = new ArrayList<>();

        try {
            Scanner file = new Scanner(new File(path));

            while (file.hasNext()) {
                palabras.add(file.next());
            }

            file.close();
        } catch (IOException e) {
            System.err.println("No se encontró el elemento.");
        }

        return palabras;
    }

    public static void crearArchivo(String path, ArrayList<String> palabras) {
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(path)
                    )
            );

            int cont = 1;
            for (String palabra : palabras) {
                pw.println(cont + "º - " + palabra);
                cont++;
            }

            pw.close();
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo.");
        }
    }
}

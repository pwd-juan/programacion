package Ejer8;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String fichero = args[0];
            String palabra = args[1];

            if (contPalabra(fichero, palabra) != -1) {
                System.out.print("Ocurrencias encontradas: ");
                System.out.println(contPalabra(fichero, palabra));
                System.out.println("Criterios: ");
                System.out.println("\t· No case-sensitive: Bee==bee");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se encontró parámetros.");
            System.err.println("Parámetros necesarios:");
            System.err.println("\t1º Ruta del fichero.");
            System.err.println("\t2º Palabra a buscar.");
            System.err.println("Ejem.: Main.java C:\\beeMovie Bee");
        }
    }

    public static int contPalabra(String nombreFichero, String palabra) {
        int cont = 0;
        String palabraEv;

        try {
            Scanner file = new Scanner(new File(nombreFichero));
            while (file.hasNext()) {
                palabraEv = file.next();
                palabraEv = palabraEv.replace("!", "");
                palabraEv = palabraEv.replace("?", "");
                palabraEv = palabraEv.replace("¿", "");
                palabraEv = palabraEv.replace("¡", "");
                palabraEv = palabraEv.replace(".", "");
                if (palabraEv.equalsIgnoreCase(palabra)) cont++;
            }
            file.close();
        } catch (IOException e) {
            System.err.println("No se encontró el archivo.");
            return -1;
        }

        return cont;
    }
}

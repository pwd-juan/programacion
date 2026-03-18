package Ejer2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(obtenerSumaNumerosArchivo("src/Ejer2/numNaturales"));
    }

    public static int obtenerSumaNumerosArchivo(String path) {
        int sum = 0;

        try {
            Scanner file = new Scanner(new File(path));

            while (file.hasNextInt()) {
                sum += file.nextInt();
            }
        } catch (IOException e) {
            System.err.println("No se encontró el archivo.");
        }

        return sum;
    }
}

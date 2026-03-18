package Ejer7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String selec;

        System.out.println("1. -> Guion de Bee Movie");
        System.out.println("2. -> Guion de Spiderman 3");
        System.out.println("3. -> Prueba");

        System.out.print("Elige archivo: ");
        selec = sc.nextLine().trim();

        switch (selec) {
            case "1" -> mostrarArchivoPantalla("beeMovie");
            case "2" -> mostrarArchivoPantalla("spiderman3");
            case "3" -> mostrarArchivoPantalla("prueba");
            default -> System.out.println("Opción no encontrada.");
        }
    }

    public static void mostrarArchivoPantalla(String nombre) {
        String path = "src/Ejer7/";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path + nombre));
            String linea = br.readLine();

            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (IOException e){
            System.err.println("No se encontró el archivo");
        }
    }
}

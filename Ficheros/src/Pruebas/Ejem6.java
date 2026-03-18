package Pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejem6 {
    public static void main(String[] args) {
        File f = new File("src/Pruebas/Files/ejem3.txt");
        String cadena;
        Scanner entrada;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                cadena = entrada.nextLine();
                System.out.println(cadena);
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

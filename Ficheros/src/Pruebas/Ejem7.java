package Pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejem7 {
    public static void main(String[] args) {
        File f = new File("src/Pruebas/Files/enteros.txt");
        int numero, suma = 0, cont = 0;
        Scanner entrada;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNextInt()) {
                numero = entrada.nextInt();
                System.out.println(numero);
                suma = suma + numero;
                cont++;
            }
            System.out.println("Número leídos: " + cont);
            System.out.println("Suma " + suma);
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

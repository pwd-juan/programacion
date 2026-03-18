package Ejer9;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("src/Ejer9/empleados.dat")
            );

            dos.writeChars("12345678Q");
            

        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo.");
        } catch (IOException e) {
            System.err.println();
        }
    }
}

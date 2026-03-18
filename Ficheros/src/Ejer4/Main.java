package Ejer4;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "src/Ejer4/file";

        System.out.println(eliminarEspacios(path));
    }

    public static String eliminarEspacios(String path) {
        String txt = "";
        String fragmento;

        try {
            Scanner file = new Scanner(new File(path));

            while (file.hasNextLine()) {
                fragmento = file.nextLine();

                fragmento = fragmento.replace(" ", "");

                txt += fragmento + ((file.hasNextLine()) ? "\n" : "");
            }
        } catch (IOException e){
            System.err.println("No se encontró el archivo.");
        }

        txt = txt.toUpperCase();

        return txt;
    }
}

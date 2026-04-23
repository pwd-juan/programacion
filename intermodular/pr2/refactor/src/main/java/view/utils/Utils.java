package view.utils;

import java.util.ArrayList;

public class Utils {
    public static final String COLOR_NEGRO = "\u001B[30m";
    public static final String COLOR_ROJO = "\u001B[31m";
    public static final String COLOR_VERDE = "\u001B[32m";
    public static final String COLOR_AMARILLO = "\u001B[33m";
    public static final String COLOR_AZUL = "\u001B[34m";
    public static final String COLOR_PURPURA = "\u001B[35m";
    public static final String COLOR_CIAN = "\u001B[36m";
    public static final String COLOR_BLANCO = "\u001B[37m";
    public static final String COLORES_RESET = "\u001B[0m";

    public static void fragmentadorDeStrings(ArrayList<String> array, String frase, int longitud) {
        int inicio = 0;
        int fin = 0;

        while (fin != frase.length()) {
            fin = fin + longitud;
            if (fin > frase.length()) {fin = frase.length();}
            array.add(frase.substring(inicio, fin).trim());
            inicio = fin;
        }
    }

    public static boolean validarEnteroPositivo(String num){
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

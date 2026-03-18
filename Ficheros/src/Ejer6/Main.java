package Ejer6;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int contVocales = 0;
        int contConsona = 0;
        int contNums = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Ejer6/File"));
            String linea = br.readLine();
            Set<Character> vocales = genVocales();

            while (linea != null) {

                for (int i = 0; i < linea.length(); i++) {
                    if (Character.isDigit(linea.charAt(i))) contNums++;

                    if (
                        Character.isLetter(linea.charAt(i)) &&
                        vocales.contains(Character.toLowerCase(linea.charAt(i)))
                    ) {
                        contVocales++;
                    } else if (Character.isLetter(linea.charAt(i))) {
                        contConsona++;
                    }
                }

                linea = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("No se encontro el archivo.");
        }

        System.out.println("Cant. Vocales: " + contVocales);
        System.out.println("Cant. Consonantes: " + contConsona);
        System.out.println("Cant. Números: " + contNums);
    }

    public static Set<Character> genVocales() {
        Set<Character> vocales = new HashSet<>();

        vocales.add('a'); vocales.add('e');
        vocales.add('i'); vocales.add('o');
        vocales.add('u');

        vocales.add('á'); vocales.add('é');
        vocales.add('í'); vocales.add('ó');
        vocales.add('ú');

        return vocales;
    }
}

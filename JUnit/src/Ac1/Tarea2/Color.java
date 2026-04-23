package Ac1.Tarea2;

public class Color {
    public static String queColorSoy(String a) {
        char inicial = a.charAt(0);
        String color = "blanco";

        if (inicial >= 'A' && inicial <= 'F') {
            color = "rojo";
        } else if (inicial >= 'G' && inicial <= 'M') {
            color = "verde";
        } else if (inicial >= 'N' && inicial <= 'S') {
            color = "azul";
        } else if (inicial >= 'T' && inicial <= 'z') {
            color = "amarillo";
        }

        return color;
    }
}

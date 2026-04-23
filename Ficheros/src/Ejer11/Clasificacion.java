package Ejer11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Clasificacion {
    private Map<Integer, Jugador> clasificacion;
    private final String pathJugadores;
    private final String pathClasificacion;

    public Clasificacion(String pathJugadores, String pathClasificacion) {
        this.clasificacion = new HashMap<>();
        this.pathJugadores = pathJugadores;
        this.pathClasificacion = pathClasificacion;
    }

    public void almacenarPorCSV() {
        try {
            Scanner file = new Scanner(new File(pathClasificacion));
            String linea;
            String[] datos;

            while (file.hasNextLine()) {
                linea = file.nextLine();

                if (!Character.isDigit(linea.charAt(0))) continue;

                datos = linea.split(";");

                clasificacion.put(
                        StringAEnterosPositivos(datos[0]),
                        new Jugador(
                                StringAEnterosPositivos(datos[1]),
                                StringAEnterosPositivos(datos[10]),
                                StringADoublesPositivos(datos[3])
                        )
                );
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo CSV.");
        }
    }

    public String obtenerNombreJugador(int ran) {
        String nombre = "";

        try {
            Scanner file = new Scanner(new File(pathJugadores));
            String linea;
            String[] datos;

            while (file.hasNextLine()) {
                linea = file.nextLine();

                if (!Character.isDigit(linea.charAt(0))) continue;

                datos = linea.split(";");

                if (StringAEnterosPositivos(datos[0]) == ran) {
                    nombre = datos[2];
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo con los jugadores.");
        }

        return nombre;
    }

    public String obtenerClasificaciones(String formato){
        boolean existePosicion = true;
        int posicion = 1;
        StringBuilder x = new StringBuilder();
        Jugador j;

        while (existePosicion) {
            j = clasificacion.get(posicion);

            j.setNombre(obtenerNombreJugador(j.getRanking()));

            x.append(
                String.format(
                    formato,
                    posicion,
                    j.getNombre(),
                    j.getELO(),
                    j.getPuntos()
                )
            );

            posicion++;
            if (!clasificacion.containsKey(posicion)) existePosicion = false;
        }

        return x.toString();
    }

    private int StringAEnterosPositivos(String x) {
        boolean pos = true;
        int resultado;

        x = x.trim();
        for (int i = 0; i < x.length(); i++) {
            if (!Character.isDigit(x.charAt(i))) pos = false;
        }

        if (pos) {
            resultado = Integer.parseInt(x);
        } else {
            resultado = -1;
        }

        return resultado;
    }

    private double StringADoublesPositivos(String x) {
        boolean pos = true;
        double resultado;

        x = x.trim();

        if (x.indexOf(",") == x.lastIndexOf(",")) {
            x = x.replace(",", ".");
        }

        for (int i = 0; i < x.length(); i++) {
            if (!Character.isDigit(x.charAt(i)) && x.charAt(i) != '.') pos = false;
        }

        if (pos) {
            resultado = Double.parseDouble(x);
        } else {
            resultado = -1;
        }

        return resultado;
    }
}

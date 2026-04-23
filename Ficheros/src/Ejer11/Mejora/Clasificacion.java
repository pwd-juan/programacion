package Ejer11.Mejora;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Clasificacion {
    private final Map<Integer, Jugador> clasificacion;
    private final ArrayList<Jugador>  jugadoresAlojados;
    private final ArrayList<Jugador> jugadoresDeCV;
    private final String pathJugadores;
    private final String pathClasificacion;

    public Clasificacion(String pathJugadores, String pathClasificacion) {
        this.pathJugadores = pathJugadores;
        this.pathClasificacion = pathClasificacion;

        this.clasificacion = almacenarClasificacion();
        this.jugadoresAlojados = almacenarJugadoresX("H");
        this.jugadoresDeCV = almacenarJugadoresX("CV");
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

            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo con los jugadores.");
        }

        return nombre;
    }

    public String obtenerClasificaciones(String formato) {
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

    public String obtenerJugadoresAlojados(String formato) {
        StringBuilder datos = new StringBuilder();

        for (Jugador j : jugadoresAlojados) {
            datos.append(
                String.format(
                    formato,
                    j.getRanking(),
                    j.getNombre()
                )
            );
        }

        return datos.toString();
    }

    public String obtenerJugadoresDeCV(String formato) {
        StringBuilder datos = new StringBuilder();

        for (Jugador j : jugadoresDeCV) {
            datos.append(
                    String.format(
                            formato,
                            j.getRanking(),
                            j.getNombre()
                    )
            );
        }

        return datos.toString();
    }

    private Map<Integer, Jugador> almacenarClasificacion() {
        Map<Integer, Jugador> m = new HashMap<>();

        try {
            Scanner file = new Scanner(new File(pathClasificacion));
            String linea;
            String[] datos;

            while (file.hasNextLine()) {
                linea = file.nextLine();

                if (!Character.isDigit(linea.charAt(0))) continue;

                datos = linea.split(";");

                m.put(
                        StringAEnterosPositivos(datos[0]),
                        new Jugador(
                                StringAEnterosPositivos(datos[1]),
                                StringAEnterosPositivos(datos[10]),
                                StringADoublesPositivos(datos[3])
                        )
                );
            }

            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo CSV.");
        }

        return m;
    }

    private ArrayList<Jugador> almacenarJugadoresX(String valor) {
        ArrayList<Jugador> j = new ArrayList<>();

        try {
            Scanner file = new Scanner(new File(pathJugadores));
            String linea;
            String[] datos;

            while (file.hasNextLine()) {
                linea = file.nextLine();

                if (!Character.isDigit(linea.charAt(0))) continue;
                datos = linea.split(";");

                if (datos[7].contains(valor)) {
                    j.add( new Jugador(datos[2], StringAEnterosPositivos(datos[0])));
                }
            }

            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo de jugadores.txt");
        }

        return j;
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

package Ac10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Jugadores {
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Jugador> jugadoresAlojados;
    private final ArrayList<Jugador> jugadoresDeCV;

    public Jugadores() {
        this.jugadores = new ArrayList<>();
        this.jugadoresAlojados = new ArrayList<>();
        this.jugadoresDeCV = new ArrayList<>();
    }

    public boolean anadirJugador(int rango, String nombre, boolean utilizaHotel, boolean esCV) {
        return jugadores.add(new Jugador(rango, nombre, utilizaHotel, esCV));
    }

    public void genJugadoresAlojados() {
        for (Jugador j : jugadores) {
            if (j.isUtilizaHotel()) jugadoresAlojados.add(j);
        }
    }

    public void genJugadoresDeCV() {
        for (Jugador j : jugadores) {
            if (j.isEsCV()) jugadoresDeCV.add(j);
        }
    }

    public void genArchivoAlojados(String path) {
        String estructuraTitulo = "%7s -- %-50s";
        String estructuraDatos = "%7d -- %-50s";

        try {
            PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new FileWriter(path)
                )
            );

            pw.println("Lista de jugadores alojados en Hotel Melià");
            pw.print("\n");
            pw.println(String.format(estructuraTitulo, "Ranking", "Nombre"));
            pw.println("----------------------------------------");

            for (Jugador j : jugadoresAlojados) {
                pw.println(String.format(
                        estructuraDatos,
                        j.getRango(),
                        j.getNombre()
                ));
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("No se encontró ruta para guardar el fichero.");
        }
    }

    public void genArchivoCV(String path) {
        String estructuraTitulo = "%7s -- %-50s";
        String estructuraDatos = "%7d -- %-50s";

        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(path)
                    )
            );

            pw.println("Jugadores de la Comunidad Valenciana.");
            pw.print("\n");
            pw.println(String.format(estructuraTitulo, "Ranking", "Nombre"));
            pw.println("----------------------------------------");

            for (Jugador j : jugadoresDeCV) {
                pw.println(String.format(
                        estructuraDatos,
                        j.getRango(),
                        j.getNombre()
                ));
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("No se encontró ruta para guardar el fichero.");
        }
    }
}

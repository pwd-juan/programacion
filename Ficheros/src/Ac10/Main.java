package Ac10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean tiempoEjecucion = true;
        String usu;
        Scanner sc = new Scanner(System.in);
        Jugadores j = new Jugadores();

        guardarJugadores(j, "src/Ac10/jugadores.txt");

        while (tiempoEjecucion) {
            imprMenu();

            usu = sc.nextLine().trim().toLowerCase();

            switch (usu) {
                case "1" -> {
                    j.genJugadoresAlojados();
                    j.genArchivoAlojados("src/Ac10/alojados.txt");

                    System.out.print("\n");
                    System.out.println("Archivo generado satisfactoriamente.");
                }
                case "2" -> {
                    j.genJugadoresDeCV();
                    j.genArchivoCV("src/Ac10/jugadoresCV.txt");

                    System.out.print("\n");
                    System.out.println("Archivo generado satisfactoriamente.");
                }
                case "q" -> tiempoEjecucion = false;
            }
        }
    }

    private static void guardarJugadores(Jugadores j, String path){
        int rango;
        boolean utilizaHotel;
        boolean esCV;
        String lineaActual;
        String[] datosJugador;

        try {
            Scanner file = new Scanner(new File(path));

            while (file.hasNextLine()) {
                lineaActual = file.nextLine();
                if (!Character.isDigit(lineaActual.charAt(0))) continue;

                datosJugador = lineaActual.split(";");
                rango = Integer.parseInt(datosJugador[0]);
                utilizaHotel = datosJugador[7].contains("H");
                esCV = datosJugador[7].contains("CV");

                j.anadirJugador(
                        rango,
                        datosJugador[2],
                        utilizaHotel,
                        esCV
                );
            }

            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró la lista de jugadores.");
        }
    }

    private static void imprMenu() {
        System.out.println("==================================");
        System.out.println(" [1] Recuperar alojados en hotel. ");
        System.out.println(" [2] Recuperar jugadores de CV.   ");
        System.out.println(" [Q] Salir.   ");
        System.out.println("==================================");
        System.out.print("Opción: ");
    }
}

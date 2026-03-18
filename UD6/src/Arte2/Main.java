package Arte2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ObraArtista obras = new ObraArtista();
        Scanner sc = new Scanner(System.in);
        boolean tiempoEjecucion = true;
        String entrada;

        obras.generarEstructuraBasica();

        while (tiempoEjecucion) {
            imprMenu();

            entrada = sc.nextLine();
            entrada = entrada.trim();

            switch (entrada) {
                case "1" -> {
                    boolean esPosibleCrear = true;
                    String nombre;  String tipo;
                    String precio;  String anyo;
                    String num;

                    System.out.print("Nombre de la obra: ");
                    nombre = sc.nextLine();

                    System.out.print("Tipo de la obra: ");
                    tipo = sc.nextLine();

                    System.out.print("Precio de la obra: ");
                    precio = sc.nextLine();

                    System.out.print("Año de creación de la obra: ");
                    anyo = sc.nextLine();

                    System.out.println("\\----/");

                    System.out.println("Selecciona un artista al que le pertenezca la obra.");
                    for (int i = 0; i < obras.getArtistas().size(); i++) {
                        System.out.println(i+1 + ". " + obras.getArtistas().get(i));
                    }
                    System.out.print("Num. artista: ");
                    num = sc.next();
                    num = num.trim();

                    for (int i = 0; i < num.length() && esPosibleCrear; i++) {
                        if (!Character.isDigit(num.charAt(i))) {
                            System.out.println("Valor de artista no valido.");
                            esPosibleCrear = false;
                        }
                    }

                    int numArtista = Integer.parseInt(num) - 1;

                    if (numArtista < 0 || numArtista > obras.getArtistas().size()) {
                        System.out.println("Número de artista fuera de rango.");
                        esPosibleCrear = false;
                    }

                    if (esPosibleCrear) {
                        obras.anyadirRelacion(
                                new Obra(nombre, tipo, precio, Integer.parseInt(anyo)),
                                numArtista
                        );

                        System.out.println("Obra creada.");
                    }

                    sc.nextLine();
                }
                case "2" -> {
                    String nombre;  String nacionalidad;

                    System.out.print("Nombre del artista: ");
                    nombre = sc.nextLine();

                    System.out.print("Nacionalidad del artista: ");
                    nacionalidad = sc.nextLine();

                    obras.anyadirArtista(new Artista(nombre, nacionalidad));
                    System.out.println("Artista creado");
                }
                case "3" -> {
                    boolean noEncontrado = true;
                    String nombre;

                    System.out.print("Nombre de la obra: ");
                    nombre = sc.nextLine().trim();

                    for (Obra o : obras.getRelacion().keySet()) {
                        if (o.getNombre().equals(nombre)) {
                            System.out.println(o);
                            noEncontrado = false;
                        }
                    }

                    if (noEncontrado) {
                        System.out.println("No se encontró la obra.");
                    }
                }
                case "4" -> {
                    boolean existeArtista = true;
                    String num;

                    System.out.println("Selecciona un artista: ");
                    for (int i = 0; i < obras.getArtistas().size(); i++) {
                        System.out.println(i+1 + ". " + obras.getArtistas().get(i));
                    }
                    System.out.print("Num. artista: ");
                    num = sc.next().trim();

                    for (int i = 0; i < num.length() && existeArtista; i++) {
                        if (!Character.isDigit(num.charAt(i))) {
                            System.out.println("Valor de artista no valido.");
                            existeArtista = false;
                        }
                    }

                    int numArtista = Integer.parseInt(num) - 1;

                    if (numArtista < 0 || numArtista > obras.getArtistas().size()) {
                        System.out.println("Número de artista fuera de rango.");
                        existeArtista = false;
                    }

                    if (existeArtista) {
                        for (Obra o: obras.getObrasArtista(numArtista)) {
                            System.out.println(o);
                        }
                    }

                    sc.nextLine();
                }
                case "5" -> {
                    String num;
                    int numObra;
                    ArrayList<Obra> listaObrasActual = obras.getObras();
                    boolean error = false;

                    int sel;
                    for (int i = 0; i < listaObrasActual.size(); i++) {
                        sel = i + 1;
                        System.out.println(sel + ". " + listaObrasActual.get(i));
                    }

                    System.out.print("Selecciona la obra a eliminar: ");
                    num = sc.nextLine().trim();

                    for (int i = 0; i < num.length() && !error; i++) {
                        if (!Character.isDigit(num.charAt(i))) {
                            System.out.println("Valor de artista no valido.");
                            error = true;
                        }
                    }

                    numObra = Integer.parseInt(num) - 1;

                    if (numObra < 0 || numObra > listaObrasActual.size()) {
                        System.out.println("Número de artista fuera de rango.");
                        error = false;
                    }

                    if (!error) {
                        obras.eliminarObra(listaObrasActual.get(numObra));
                    }

                    System.out.println("Obra Eliminada.");
                }
                case "6" -> {
                    System.out.println("La obra(s) más barata(s) es: ");
                    for (Obra o : obras.getObrasMasBaratas()) {
                        System.out.println(o);
                    }
                }
                case "7" -> {
                    System.out.println("La obra(s) más moderna(s) es: ");
                    for (Obra o : obras.getObrasMasModernar()) {
                        System.out.println(o);
                    }
                }
                case "8" -> tiempoEjecucion = false;
                default -> {
                    System.out.println("Opción no valida.");
                }
            }

            System.out.print("\n");
        }
    }

    public static void imprMenu() {
        System.out.println("1. Añadir obra");
        System.out.println("2. Añadir artista");
        System.out.println("3. Buscar obra por nombre");
        System.out.println("4. Buscar obras por artista");
        System.out.println("5. Eliminar obra");
        System.out.println("6. Encontrar obra más barata");
        System.out.println("7. Encontrar obra más moderna");
        System.out.println("8. Salir");
        System.out.print("Selecciona: ");
    }
}

package Arte;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Artista> artistas = crearDatos();
        Map<Integer, Integer> obraActual;
        boolean tiempoEjecucion = true;
        Scanner sc = new Scanner(System.in);
        String entradaUsu;

        while (tiempoEjecucion) {
            menu();
            entradaUsu = sc.nextLine();

            switch (entradaUsu) {
                case "1" -> {
                    System.out.print("Nombre de la Obra: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo de Obra: ");
                    String tipo = sc.nextLine();
                    System.out.print("Precio de la Obra: ");
                    String precio = sc.nextLine();
                    System.out.print("Año de creación de la Obra: ");
                    String anyo = sc.nextLine();
                    System.out.print("Propietario de la Obra: ");
                    String artista = sc.nextLine();

                    boolean encontrado = false;
                    for (Artista x : artistas) {
                        if (x.getNombre().equals(artista)) {
                            x.setObra(nombre, tipo, precio, anyo);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) System.out.println("No se ha encontrado a el artista.");
                }
                case "2" -> {
                    System.out.print("Nombre del Artistas: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nacionalidad del Artista: ");
                    String nacionalidad = sc.nextLine();

                    if (nombre.isEmpty() || nacionalidad.isEmpty()) {
                        System.out.println("Nombre no valido");
                        continue;
                    }

                    nombre = nombre.trim();
                    nacionalidad = nacionalidad.trim();

                    artistas.add(new Artista(nombre, nacionalidad));
                }
                case "3" -> {
                    System.out.print("Nombre de la obra: ");
                    entradaUsu = sc.nextLine();

                    for (Artista artista : artistas) {
                        for (Map obra : artista.getObras()) {
                            if (obra.get("Nombre").equals(entradaUsu)) {
                                System.out.print("Artista: " + artista.getNombre());
                                System.out.print("Nacionalidad: " + artista.getNacionalidad());
                                imprObra(obra);
                            }
                        }
                    }
                }
                case "4" -> {
                    System.out.print("Nombre del artista: ");
                    entradaUsu = sc.nextLine();

                    for (Artista artista : artistas) {
                        if (artista.getNombre().equals(entradaUsu)) {
                            System.out.print("Artista: " + artista.getNombre());
                            System.out.print("Nacionalidad: " + artista.getNacionalidad());
                             for (Map obra : artista.getObras()) {
                                 imprObra(obra);
                             }
                        }
                    }
                }
                case "6" -> {
                    System.out.print("Nombre de la obra: ");

                    int precioMasBajo = Integer.MAX_VALUE;
                    String nombreObraPrecioMasAlto = null;
                    for (Artista a : artistas) {
                        for (Map.Entry<String, Integer> precio : a.getPrecioObras().entrySet()) {
                            if (precioMasBajo > precio.getValue()) {
                                nombreObraPrecioMasAlto = precio.getKey();
                                precioMasBajo = precio.getValue();
                            }
                        }
                    }

                    if (precioMasBajo != 0)
                        System.out.println("Obra más barata es: " + nombreObraPrecioMasAlto);
                    else
                        System.out.println("No se encontraron obras.");
                }
                case "0" -> tiempoEjecucion = false;
                default -> {
                    System.out.print("\n");
                    System.out.println("Entrada no valida.");
                }
            }

            System.out.print("\n");
        }
    }

    private static void menu() {
        System.out.println("1. Añadir obra.");
        System.out.println("2. Añadir artista.");
        System.out.println("3. Buscar Obra por nombre ");
        System.out.println("4. Buscar Obras por artista");
        System.out.println("5. Eliminar Obra");
        System.out.println("6. Encontrar obra más barata");
        System.out.println("7. Encontrar obra más moderna");
        System.out.println("8. Salir");
        System.out.print("Selecciona: ");
    }

    private static void imprObra(Map obra) {
        System.out.println("Nombre: " + obra.get("Nombre"));
        System.out.println("Tipo: " + obra.get("Tipo"));
        System.out.println("Precio: " + obra.get("Precio"));
        System.out.println("Año de realización: " + obra.get("Realizacion"));
    }

    private static void mostrarArtistas(ArrayList<Artista> artistas) {
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println(i+1 + ". " + artistas.get(i).getNombre());
        }
        System.out.print("Selecciona: ");
    }

    private static ArrayList<Artista> crearDatos() {
        ArrayList<Artista> artistas = new ArrayList<>();

        artistas.add(new Artista("Leonardo da Vinci", "Italiano"));
        artistas.add(new Artista("Pablo Piccaso", "Español"));
        artistas.add(new Artista("Aguste Rodin", "Francés"));

        artistas.get(0).setObra(
                "Salvator Mundi",
                "Óleo sobre madera",
                "450M",
                "1500"
        );
        artistas.get(0).setObra(
                "La Gioconda",
                "Óleo sobre madera",
                "870M",
                "1503"
        );

        artistas.get(1).setObra(
                "El pensador",
                "Escultura",
                "11M",
                "1904"
        );

        artistas.get(2).setObra(
                "El sueño",
                "Óleo sobre lienzo",
                "155M",
                "1932"
        );
        artistas.get(2).setObra(
                "El Guernica",
                "Óleo sobre lienzo",
                "2000M",
                "1937"
        );

        return artistas;
    }
}

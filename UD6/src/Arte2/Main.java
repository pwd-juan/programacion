package Arte2;

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
                case "1" -> {}
                case "2" -> {}
                case "3" -> {}
                case "4" -> {}
                case "5" -> {}
                case "6" -> {}
                case "7" -> {}
                case "8" -> tiempoEjecucion = false;
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
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

package JuegoRol;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean tiempoEjecucion = true;
        String selec;
        Scanner sc = new Scanner(System.in);
        Personaje pInicial;
        Jugadores jugadores = new Jugadores();
        jugadores.crearPersonajesBasicos();

        while (tiempoEjecucion) {
            System.out.println("Bienvenido.");

            imprimirPeronajes(jugadores);
            pInicial = selecionPersonaje(jugadores, sc);

            imprimirMenu();
            selec = sc.nextLine().trim();

            switch (selec) {
                case "1" -> {
                    System.out.println("Nombre: " + pInicial.getNombre());
                    System.out.println("Tipo: " + pInicial.getTipo() + " | Vida: " + pInicial.getVida());
                    System.out.println("Herramientas: ");
                    System.out.println(pInicial.getMochila());
                }
                case "2" -> jugar(pInicial, jugadores, sc);
                case "3" -> tiempoEjecucion = false;
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
        }

        sc.close();
    }

    private static void imprimirMenu() {
        System.out.println("1. Imprime todos tus datos.");
        System.out.println("2. Jugar.");
        System.out.println("3. Salir.");
        System.out.print("Selecciona: ");
    }

    private static void imprimirPeronajes(Jugadores j) {
        System.out.println("Selecciona a tu personaje:");
        for (String n : j.getNombrePersonajes()) {
            System.out.println(n);
        }
    }

    private static void imprimirPeronajes(Personaje p, Jugadores j) {
        System.out.println("Selecciona a tu personaje:");
        for (String n : j.getNombrePersonajes()) {
            if (!n.equals(p.getNombre())) System.out.println(n);
        }
    }

    private static Personaje selecionPersonaje(Jugadores j, Scanner sc) {
        String usu;
        boolean esValido = false;

        do {
            System.out.print("Nombre del personaje: ");
            usu = sc.nextLine().trim();

            for (String n : j.getNombrePersonajes()) {
                if (n.equals(usu)) esValido = true;
            }

            if (!esValido) System.out.println("Nombre no encontrado. Prueba de nuevo.");
        } while (!esValido);

        return j.getPersonajePorNombre(usu);
    }

    private static Personaje selecionPersonaje(Personaje p, Jugadores j, Scanner sc) {
        String usu;
        boolean esValido = false;

        do {
            System.out.print("Nombre del personaje: ");
            usu = sc.nextLine().trim();

            for (String n : j.getNombrePersonajes()) {
                if (n.equals(usu)) esValido = true;
            }

            if (j.getPersonajePorNombre(usu) == p) esValido = false;
            if (!esValido) System.out.println("Nombre no encontrado. Prueba de nuevo.");
        } while (!esValido);

        return j.getPersonajePorNombre(usu);
    }

    private static Herramienta seleccionHerramienta(Personaje p, Scanner sc) {
        String selec;
        boolean esValido = false;
        Herramienta herramienta = null;

        System.out.print(p.getNombre()+": ");
        System.out.println("Selecciona herramienta:");
        for (Herramienta h : p.getMochila()) {
            System.out.println(h);
        }

        do {
            System.out.print("Nombre de la herramienta: ");
            selec = sc.nextLine().trim();

            for (Herramienta h : p.getMochila()) {
                if (h.getNombre().equals(selec)) {
                    esValido = true;
                    herramienta = h;
                }
            }

            if (!esValido) System.out.println("Herramienta no encontrada. Vuelve a intentarlo.");
        } while (!esValido);

        return herramienta;
    }

    private static void jugar(Personaje pInicial, Jugadores j, Scanner sc) {
        int vicInicial = 0;
        int vicContra = 0;
        Personaje pContra;
        Personaje ganador;
        Herramienta hInicial;
        Herramienta hContra;

        imprimirPeronajes(pInicial, j);
        pContra = selecionPersonaje(pInicial, j, sc);

        j.genValores(pInicial);
        j.genValores(pContra);

        while (vicInicial < 2 && vicContra < 2) {
            hInicial = seleccionHerramienta(pInicial, sc);
            hContra = seleccionHerramienta(pContra, sc);

            if (hInicial.getValor() == hContra.getValor()) {
                System.out.println("Empate. Volver a seleccionar.");
                System.out.println("Se ha vuelto a generar los valores.");
                j.genValores(pInicial);
                j.genValores(pContra);
            } else if (hInicial.getValor() > hContra.getValor()) {
                System.out.println(pInicial.getNombre() + " ha ganado.");
                System.out.println(pInicial.getNombre() + " ha perdido su " + hInicial.getNombre());
                j.eliminarHerramienta(pInicial, hInicial);
                vicInicial++;
            } else {
                System.out.println(pContra.getNombre() + " ha ganado.");
                System.out.println(pContra.getNombre() + " ha perdido su " + hContra.getNombre());
                j.eliminarHerramienta(pContra, hContra);
                vicContra++;
            }

            System.out.print(pInicial.getNombre() + ": ");
            System.out.println(vicInicial);
            System.out.print(pContra.getNombre() + ": ");
            System.out.println(vicContra);
        }

        ganador = (vicInicial > vicContra) ? pInicial : pContra;

        System.out.println("Ha ganado la batalla: " + ganador.getNombre());
        System.out.println(ganador.getNombre() + "ha ganado 10pts de vida.");

        j.aumentarVida(ganador);

        j.desGenValores(pInicial);
        j.desGenValores(pContra);
    }
}

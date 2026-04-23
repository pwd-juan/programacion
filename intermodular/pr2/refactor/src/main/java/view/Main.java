package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;

        System.out.println("Gestión de DB \"Sistema de reserva\"");
        do {
            System.out.println("1. USUARIO");
            System.out.println("2. DISPONIBLEEN");
            System.out.println("3. HORARIO");
            System.out.println("4. RECURSO");
            System.out.println("5. RESERVA");
            System.out.println("---");
            System.out.println("0. Salir");

            System.out.print("> ");
            entrada = sc.nextLine().trim();

            switch (entrada) {
                case "4" -> {
                    RecursoView.menu(sc);
                }
                case "0" -> {
                    System.out.println("Saliendo del programa.");
                }
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
        } while (!entrada.equals("0"));
        sc.close();
    }
}

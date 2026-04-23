package view;

import controller.HorarioController;
import model.Horario;

import java.util.ArrayList;
import java.util.Scanner;

public class HorarioView {
    public static void menu(Scanner sc) {
        String entrada;

        do {
            System.out.println("1. Añadir horario");
            System.out.println("2. Eliminar horario");
            System.out.println("3. Modificar horario");
            System.out.println("4. Ver todos los horarios");
            System.out.println("0. Salir");

            System.out.print("> ");
            entrada = sc.nextLine().trim();

            switch (entrada) {
                case "1" -> {

                }
                case "2" -> {}
                case "3" -> {}
                case "4" -> {
                    ArrayList<Horario> datos = HorarioController.select();
                    datos.forEach(System.out::println);
                }
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
        } while (!entrada.equals("0"));
    }
}

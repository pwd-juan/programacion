package Supermercado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCompra lista = new ListaCompra();
        boolean tiempoEjecucion = true;
        String entrada;
        String ticket;

        while (tiempoEjecucion){
            System.out.println("Productos disponibles: ");
            System.out.println(lista.toStringProductos());

            entrada = sacarProducto(sc);

            if (lista.existeProducto(entrada)) {
                int cantidad = sacarCantidad(sc);

                if (lista.anadirProductoLista(entrada, cantidad)) {
                    System.out.println("Producto añadido correctamente.");
                } else {
                    System.out.println("No se pudo añadir el producto.");
                }
            } else if (entrada.equals("fin")) {
                tiempoEjecucion = false;
            } else {
                System.out.println("Producto no encontrado.");
            }
        }

        ticket = lista.generarTicket(sacarDescuento(sc));

        sc.close();

        guardarTicketGlobal(ticket, "src/Supermercado/");
        guardarTicketSeparado(ticket, "src/Supermercado/");
    }

    public static String sacarProducto(Scanner sc){
        System.out.print("Producto: ");
        return sc.nextLine().trim().toLowerCase();
    }

    public static int sacarCantidad(Scanner sc){
        int cantidad = -1;
        boolean valorNoValido = true;

        while(valorNoValido) {
            try {
                System.out.print("Cantidad: ");
                cantidad = sc.nextInt();
                if (cantidad > 0) {
                    valorNoValido = false;
                } else {
                    System.out.println("Al menos tienes que comprar una unidad.");
                }
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Solo es valido introducir números.");
                sc.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Has introducido demasiados elementos.");
                sc.nextLine();
            }
            System.out.print("\n");
        }

        return cantidad;
    }

    public static int sacarDescuento(Scanner sc) {
        int descuento = 0;
        String entrada;

        System.out.print("Código de descuento (INTRO para salir): ");
        entrada = sc.nextLine();

        if (entrada.equalsIgnoreCase("promoeco")) descuento = 10;

        return descuento;
    }

    public static void guardarTicketGlobal(String ticket, String path){
        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter (
                            new FileWriter(path + "global", true)
                    )
            );

            pw.println("");
            pw.print(ticket);

            pw.close();
        } catch (IOException e) {
            System.err.println("No se encontró la ruta.");
        }
    }

    public static void guardarTicketSeparado(String ticket, String path) {
        int anyo = LocalDateTime.now().getYear();
        int mes = LocalDateTime.now().getMonthValue();
        int dia = LocalDateTime.now().getDayOfMonth();
        int hora = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();
        String sufijo =
            "-" +
            dia + "_" +
            mes + "_" +
            anyo + "_" +
            hora + "-" +
            min
        ;

        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter (
                            new FileWriter(path + "ticket" + sufijo, true)
                    )
            );

            pw.print(ticket);
            pw.close();
        } catch (IOException e) {
            System.err.println("No se encontró la ruta.");
        }
    }
}

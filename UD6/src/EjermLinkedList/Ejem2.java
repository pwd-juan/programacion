package EjermLinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ejem2 {
    public static void main(String[] args) {
        LinkedList<String> lugares = new LinkedList<String>();
        lugares.add("Roma");
        lugares.add("París");
        lugares.add("Amsterdam");
        lugares.add("Toronto");
        lugares.add("Miami");

        visitarLugar(lugares);
    }

    public static void visitarLugar(LinkedList<String> lugares) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        ListIterator<String> it = lugares.listIterator();

        if (lugares.isEmpty()) {
            System.out.println("No hay lugares visitados");
            return;
        } else {
            System.out.println("Visitando " + it.next());
            imprimirMenu();
        }

        boolean haciaAdelante = true;
        while(continuar) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Se acabaron las vacaciones");
                    continuar = false;
                    break;
                case 1:
                    if (!haciaAdelante) {
                        if (it.hasNext())
                            it.next();
                        haciaAdelante = true;
                    }
                    if (it.hasNext()) {
                        System.out.println("Visitando " + it.next());
                    } else {
                        System.out.println("Ya no hay más ciudades");
                        haciaAdelante = false;
                    }
                    break;
                case 2:
                    if(haciaAdelante) {
                        if (it.hasPrevious())
                            it.previous();
                        haciaAdelante = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("Visitando " + it.previous());
                    } else {
                        System.out.println("Primera ciudad");
                        haciaAdelante = true;
                    }
                    break;
                case 3:
                    imprimirMenu();
                    break;
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("0 - Para salir\n" +
                "1 - para ir a la siguiente ciudad\n" +
                "2 - para ir a la ciudad anterior\n" +
                "3 - imprimir el menú");
    }
}

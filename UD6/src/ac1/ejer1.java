package ac1;

import java.util.ArrayList;
import java.util.Scanner;

public class ejer1 {
    public static void main(String[] args) {
        final String ANSI_ROJO = "\u001B[31m";
        final String ANSI_VERDE = "\u001B[32m";
        final String ANSI_AMARILLO = "\u001B[33m";
        final String ANSI_CIAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";

        Scanner sc = new Scanner(System.in);
        TelefonoMovil telf = new TelefonoMovil("123456789");
        boolean tiempoEjecucion = true;
        String entradaUsuario;

        do {
            System.out.println(ANSI_AMARILLO + "-- MENU --" + ANSI_RESET);
            System.out.printf("%s0.%s Salir\n", ANSI_CIAN, ANSI_RESET);
            System.out.printf("%s1.%s Imprimir contactos.\n", ANSI_CIAN, ANSI_RESET);
            System.out.printf("%s2.%s Agregar nuevo contacto.\n", ANSI_CIAN, ANSI_RESET);
            System.out.printf("%s3.%s Actualizar contacto existente.\n", ANSI_CIAN, ANSI_RESET);
            System.out.printf("%s4.%s Eliminar contacto de la lista.\n", ANSI_CIAN, ANSI_RESET);
            System.out.printf("%s5.%s Buscar contacto por nombre.\n", ANSI_CIAN, ANSI_RESET);
            System.out.printf("%s6.%s Volver a imprimir las opciones.\n", ANSI_CIAN, ANSI_RESET);

            System.out.print("Selecciona: ");
            entradaUsuario = sc.nextLine();

            switch (entradaUsuario) {
                case "1" -> telf.printContacts();
                case "2" -> {
                    System.out.print("\n");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Número: ");
                    String num = sc.nextLine();

                    Contacto c = new Contacto(nombre, num);
                    if (formatoTelefonico(num) && telf.addNewContact(c)) {
                        System.out.println(ANSI_VERDE + "Contacto añadido con éxito." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_ROJO + "Error al añadir el contacto." + ANSI_RESET);
                    }

                    if (!formatoTelefonico(num))
                        System.out.println(ANSI_ROJO + "Revisa el formato del número." + ANSI_RESET);

                    System.out.print("\n");
                }
                case "3" -> {
                    System.out.print("\n");
                    System.out.print("Nombre del contacto a cambiar: ");
                    String nombre = sc.nextLine();

                    if (telf.queryContact(nombre) != null) {
                        System.out.print("Nuevo nombre: ");
                        String nombreN = sc.nextLine();

                        System.out.print("Nuevo número: ");
                        String telfN = sc.nextLine();

                        Contacto nuevoContanto = new Contacto(nombreN, telfN);

                        if (
                                formatoTelefonico(telfN) &&
                                telf.updateContact(telf.queryContact(nombre), nuevoContanto)
                        ){
                            System.out.println(ANSI_VERDE + "Contacto actualizado con éxito." + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_ROJO + "Error al actualizar el contacto." + ANSI_RESET);
                        }

                        if (!formatoTelefonico(telfN))
                            System.out.println(ANSI_ROJO + "Revisa el formato del número." + ANSI_RESET);

                    } else {
                        System.out.println(ANSI_ROJO + "Error al encontrar el contacto." + ANSI_RESET);
                    }

                    System.out.print("\n");
                }
                case "4" -> {
                    System.out.print("\n");

                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombre = sc.nextLine();

                    if (
                            telf.queryContact(nombre) != null &&
                            telf.removeContact(telf.queryContact(nombre))
                    ) {
                        System.out.println(ANSI_VERDE + "Contacto eliminado." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_ROJO + "Se ha producido un error al eliminar." + ANSI_RESET);
                    }

                    System.out.print("\n");
                }
                case "5" -> {
                    System.out.print("\n");

                    System.out.print("Nombre del contacto: ");
                    String nombre = sc.nextLine();

                    if (telf.queryContact(nombre) != null) {
                        System.out.printf(
                                "%s -> %s\n",
                                telf.queryContact(nombre).getName(),
                                telf.queryContact(nombre).getPhoneNumber()
                        );
                    } else {
                        System.out.println(ANSI_ROJO + "No se ha encontrado el nombre del contacto." + ANSI_RESET);
                    }

                    System.out.print("\n");
                }
                case "6" -> System.out.print("\n");
                case "0" -> tiempoEjecucion = false;
                default -> {
                    System.out.println("\n");
                    System.out.println(ANSI_ROJO + "** Selecciona una opción validad. **" + ANSI_RESET);
                }
            }

        } while (tiempoEjecucion);

        sc.close();
    }

    public static boolean formatoTelefonico(String n) {
        boolean valido = true;

        if (n.length() != 9) valido = false;
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i))) valido = false;
        }

        return valido;
    }
}

// a.)
class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact(String nombre, String numero) {
        return new Contacto(nombre, numero);
    }

    @Override
    public boolean equals(Object c){
        Contacto cN = (Contacto) c;
        return (name.equals(cN.getName()) || phoneNumber.equals(cN.getPhoneNumber()));
    }
}

// b.)
class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto c) {
        boolean existe = false;
        if (!myContacts.contains(c) && !c.getPhoneNumber().equals(myNumber)) {
            myContacts.add(c);
            existe = true;
        }
        return existe;
    }

    public boolean updateContact(Contacto cA, Contacto cN) {
        boolean esRepetido = false;
        boolean e = false;

        for (Contacto c : myContacts) {
            if (c.equals(cA)) continue;

            if (
                c.getPhoneNumber().equals(cN.getPhoneNumber()) ||
                c.getName().equals(cN.getName())
            ) {
                esRepetido = true;
            }
        }

        if (!esRepetido && myContacts.contains(cA) && !cN.getPhoneNumber().equals(myNumber)) {
            myContacts.set(myContacts.indexOf(cA), cN);
            e = true;
        }
        return e;
    }

    public boolean removeContact(Contacto c) {
        return myContacts.remove(c);
    }

    private int findContact(Contacto c) {
        return myContacts.indexOf(c);
    }

    private int findContact(String nombre) {
        int existe = -1;

        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(nombre)) existe = i;
        }

        return existe;
    }

    public Contacto queryContact(String nombre) {
        return (findContact(nombre) == -1) ? null : myContacts.get(findContact(nombre));
    }

    public void printContacts() {
        System.out.print("\n");
        System.out.println("Lista de contactos:");

        if (myContacts.isEmpty()) System.out.println("No existe ningún contacto todavía.");

        for (int i = 0; i < myContacts.size(); i++) {
            System.out.printf(
                    "%d. %s -> %S\n",
                    i+1,
                    myContacts.get(i).getName(),
                    myContacts.get(i).getPhoneNumber()
            );
        }

        System.out.print("\n");
    }
}

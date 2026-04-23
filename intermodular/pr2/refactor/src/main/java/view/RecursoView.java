package view;

import controller.RecursoController;
import model.Horario;
import model.Recurso;
import org.checkerframework.checker.units.qual.A;
import view.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import static view.utils.Utils.fragmentadorDeStrings;

public class RecursoView {
    public static void menu(Scanner sc) {
        String entrada;

        do {
            System.out.println("1. Alta de un recurso");
            System.out.println("2. Baja de un recurso");
            System.out.println("3. Modificar recurso");
            System.out.println("4. Listar todos los recursos");
            System.out.println("5. Buscar por nombre");
            System.out.println("0. Salir");

            System.out.print("> ");
            entrada = sc.nextLine().trim();

            switch(entrada) {
                case "1" -> {
                    String nombre; String desc;
                    String ubi; String cap;

                    System.out.println("Creando un nuevo recurso");

                    System.out.print("(Nombre Recurso) > ");
                    nombre = sc.nextLine().trim();

                    System.out.print("(Descripción Recurso) > ");
                    desc = sc.nextLine().trim();

                    System.out.print("(Ubicación Recurso) > ");
                    ubi = sc.nextLine().trim();

                    do {
                        System.out.print("(Capacidad Recurso) > ");
                        cap = sc.nextLine().trim();

                        if (!Utils.validarEnteroPositivo(cap)) {
                            System.out.println("Entrada no valida");
                        }
                    } while (!Utils.validarEnteroPositivo(cap));

                    RecursoController.insert(new Recurso(
                       nombre,
                       desc,
                       ubi,
                       Integer.parseInt(cap)
                    ));
                }
                case "2" -> {
                    String idRecurso;

                    RecursoController.selectTodo().forEach(System.out::println);

                    do {
                        System.out.print("(ID Recurso Eliminar) > ");
                        idRecurso = sc.nextLine().trim();

                        if (!Utils.validarEnteroPositivo(idRecurso)){
                            System.out.println("Formato ID no valido.");
                        }
                    } while (!Utils.validarEnteroPositivo(idRecurso));

                    RecursoController.delete(Integer.parseInt(idRecurso));
                }
                case "3" -> {
                    String idRecurso;
                    String nombre; String desc;
                    String ubi; String cap;

                    RecursoController.selectTodo().forEach(System.out::println);

                    do {
                        System.out.print("(ID Recurso Modificar) > ");
                        idRecurso = sc.nextLine().trim();

                        if (!Utils.validarEnteroPositivo(idRecurso)){
                            System.out.println("Formato ID no valido.");
                        }
                        if (
                            Utils.validarEnteroPositivo(idRecurso) &&
                            !RecursoController.idExistente(Integer.parseInt(idRecurso))
                        ) {
                            System.out.println("ID no existente.");
                        }
                    } while (
                        !Utils.validarEnteroPositivo(idRecurso) ||
                        !RecursoController.idExistente(Integer.parseInt(idRecurso))
                    );

                    System.out.print("(Nuevo nombre Recurso) > ");
                    nombre = sc.nextLine().trim();

                    System.out.print("(Nueva descripción Recurso) > ");
                    desc = sc.nextLine().trim();

                    System.out.print("(Nueva ubicación Recurso) > ");
                    ubi = sc.nextLine().trim();

                    do {
                        System.out.print("(Nuevo capacidad Recurso) > ");
                        cap = sc.nextLine().trim();

                        if (!Utils.validarEnteroPositivo(cap)) {
                            System.out.println("Formato capacidad no valida.");
                        }
                    } while (!Utils.validarEnteroPositivo(cap));

                    RecursoController.update(new Recurso(
                        Integer.parseInt(idRecurso),
                        nombre,
                        desc,
                        ubi,
                        Integer.parseInt(cap)
                    ));
                }
                case "4" -> {
                    ArrayList<Recurso> datos = RecursoController.selectTodo();
                    if (datos != null) {
                        imprimirTablaDatos(datos);
                    } else {
                        System.out.println("No datos encontrados.");
                    }
                }
                case "5" -> {
                    System.out.print("(Nombre recurso) > ");
                    ArrayList<Recurso> datos = RecursoController.selectWhereNombre(sc.nextLine().trim());
                    if (datos != null) {
                        imprimirTablaDatos(datos);
                    } else {
                        System.out.println("No datos encontrados.");
                    }
                }
                default -> {
                    System.out.println("Opción no valida.");
                }
            }
        } while (!entrada.equals("0"));
    }

    public static void imprimirTablaDatos(ArrayList<Recurso> r) {
        int cantLineas = 0;
        ArrayList<ArrayList> arrayLetras = new ArrayList<>();
        ArrayList<String> fragmentosNombre = new ArrayList<>();
        ArrayList<String> fragmentosDesc = new ArrayList<>();
        ArrayList<String> fragmentosUbi = new ArrayList<>();
        String id; String nombre;
        String desc; String ubi;
        String capacidad;

        imprimirTopBajos("/*", '-', "*\\", 102);
        imprimirTitulos("id_recurso", "nombre", "descripción", "ubicación", "capacidad");
        imprimirSeparador('-', '|', 104);

        // Datos
        for (int i = 0; i < r.size(); i++) {
            arrayLetras.clear();
            fragmentosNombre.clear();
            fragmentosDesc.clear();
            fragmentosUbi.clear();

            if (r.get(i).getNombre().length() > 13) {
                fragmentadorDeStrings(fragmentosNombre, r.get(i).getNombre(), 13);
                arrayLetras.add(fragmentosNombre);
            }

            if (r.get(i).getDesc().length() > 34) {
                fragmentadorDeStrings(fragmentosDesc, r.get(i).getDesc(), 34);
                arrayLetras.add(fragmentosDesc);
            }

            if (r.get(i).getUbi().length() > 34) {
                fragmentadorDeStrings(fragmentosUbi, r.get(i).getUbi(), 34);
                arrayLetras.add(fragmentosUbi);
            }

            if (!arrayLetras.isEmpty()) {
                for (ArrayList x : arrayLetras) {
                    if (x.size() > cantLineas) {cantLineas = x.size();}
                }

                for (int j = 0; j < cantLineas; j++) {
                    // Supongo que los números no superarán los límites de la cuadrícula.
                    id = (j == 0) ? String.valueOf(r.get(i).getId()) : "";
                    capacidad = (j == 0) ? String.valueOf(r.get(i).getCapacidad()) : "";

                    nombre = anadirElementoArray(fragmentosNombre, r.get(i).getNombre(), j);
                    desc = anadirElementoArray(fragmentosDesc, r.get(i).getNombre(), j);
                    ubi = anadirElementoArray(fragmentosUbi, r.get(i).getNombre(), j);

                    imprimirDatos(id, nombre, desc, ubi, capacidad);
                }
            } else {
                id = String.valueOf(r.get(i).getId());
                nombre = r.get(i).getNombre();
                desc = r.get(i).getDesc();
                ubi = r.get(i).getUbi();
                capacidad = String.valueOf(r.get(i).getCapacidad());

                imprimirDatos(id, nombre, desc, ubi, capacidad);
            }

            if (i != r.size() - 1) {imprimirSeparador('-', '|', 104);}
        }

        imprimirTopBajos("\\*", '-', "*/", 102);
    }

    private static void imprimirSeparador(char relleno, char paredes, int cantRelleno){
        System.out.print(paredes);
        for (int i = 0; i < cantRelleno; i++) {
            System.out.print(relleno);
        }
        System.out.println(paredes);
    }

    private static void imprimirTopBajos(String esquinaIzquierda, char separador, String esquinaDerecha, int relleno) {
        System.out.print(esquinaIzquierda);
        for (int i = 0; i < relleno; i++) {
            System.out.print(separador);
        }
        System.out.println(esquinaDerecha);
    }

    private static void imprimirTitulos(String col1, String col2, String col3, String col4, String col5) {
        System.out.printf("|%-10s|%-13s|%-34s|%-34s|%-9s|%n", col1, col2, col3, col4, col5);
    }

    private static void imprimirDatos(String col1, String col2, String col3, String col4, String col5) {
        System.out.printf("|%10s|%-13s|%-34s|%-34s|%-9s|%n", col1, col2, col3, col4, col5);
    }

    private static String anadirElementoArray(ArrayList<String> arrayFragmentos, String alternativa, int indice) {
        String nombre;
        if (!arrayFragmentos.isEmpty() && indice < arrayFragmentos.size()) {
            nombre = arrayFragmentos.get(indice);
        } else if (!arrayFragmentos.isEmpty()) {
            nombre = "";
        } else if (indice == 0) {
            nombre = alternativa;
        } else {
            nombre = "";
        }

        return nombre;
    }
}

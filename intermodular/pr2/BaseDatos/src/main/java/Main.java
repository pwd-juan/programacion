import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean tiempoEjecucion = true;
        boolean opcionNoValida = false;
        String entrada; String opcion;
        Connection cnx;
        ResultSet rs;
        String nombreRecurso;

        try {
            cnx = DriverManager.getConnection(
                "jdbc:mariadb://172.21.13.247/sistema_reservas",
                "admin",
                "admin"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.print("\n");

        while (tiempoEjecucion) {
            menuPrincipal();
            System.out.print("Tabla: ");
            entrada = sc.nextLine().trim();

            try {
                switch (entrada) {
                    case "1", "2", "3", "4", "5", "6" -> System.out.println("NO IMPLEMENTADO");
                    case "7" -> {
                        do {
                            menuTablas("recurso");
                            System.out.print("Opción: ");
                            opcion = sc.nextLine().trim();

                            switch (opcion) {
                                case "1", "2" -> {
                                    opcionNoValida = false;
                                    System.out.println("NO IMPLEMENTADO");
                                }
                                case "3" -> {
                                    opcionNoValida = false;

                                    select(cnx, "RECURSO");
                                    System.out.print("Selecciona la ID posible:");
                                    nombreRecurso = sc.nextLine().trim();


                                }
                                case "4" -> {
                                    opcionNoValida = false;
                                    select(cnx, "RECURSO");
                                }
                                case "5" -> {
                                    opcionNoValida = false;

                                    System.out.print("Nombre del recurso: ");
                                    nombreRecurso = sc.nextLine().trim();

                                    select(cnx, "RECURSO", nombreRecurso);
                                }
                                case "0" -> {
                                    opcionNoValida = false;
                                    tiempoEjecucion = false;
                                    System.out.println("Saliendo... ");
                                    sc.close();
                                }
                                default -> {
                                    opcionNoValida = true;
                                    System.out.print("\n");
                                    System.out.println("Selecciona una opción valida.");
                                }
                            }
                        } while (opcionNoValida);
                    }
                    case "0" -> {
                        System.out.println("Saliendo... ");
                        sc.close();
                        tiempoEjecucion = false;
                    }
                    default -> {
                        System.out.print("\n");
                        System.out.println("Selecciona una tabla.");
                    }
                }
            } catch (SQLTimeoutException e) {

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private static void menuPrincipal() {
        System.out.println("[1] USUARIO");
        System.out.println("[2] ADMINISTRADOR");
        System.out.println("[3] USUARIONORMAL");
        System.out.println("[4] RECURSO");
        System.out.println("[5] HORARIO");
        System.out.println("[6] DISPONIBLEEN");
        System.out.println("[7] RESERVA");
        System.out.println("[0] SALIR");
    }

    private static void menuTablas(boolean genero, String nombre) {
        String articulo = (genero) ? "un" : "una";

        System.out.printf("[1] Alta de %s %s. \n", articulo, nombre);
        System.out.printf("[2] Alta de %s %s. \n", articulo, nombre);
        System.out.printf("[3] Alta de %s %s. \n", articulo, nombre);
        System.out.printf("[4] Listar todos %s %s. \n", articulo, nombre);
        System.out.println("[5] Buscar por nombre.");
        System.out.println("[0] Salir.");
    }

    private static void menuTablas(String nombre) {
        menuTablas(true, nombre);
    }

    private static void select(Connection cnx, String tabla) throws SQLException {
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM " + tabla);

        while (rs.next()) {
            System.out.printf(
                    "%d | %s | %s | %s | %d \n",
                    rs.getInt("id_recurso"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("ubicacion"),
                    rs.getInt("capacidad")
            );
        }

        stm.close();
    }

    private static void select(Connection cnx, String tabla, String nombreRecurso) throws SQLException {
        PreparedStatement pstm = cnx.prepareStatement(String.format("SELECT * FROM %s WHERE nombre = ?", tabla));
        pstm.setString(1, nombreRecurso);

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.printf(
                    "%d | %s | %s | %s | %d \n",
                    rs.getInt("id_recurso"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("ubicacion"),
                    rs.getInt("capacidad")
            );
        }

        pstm.close();
    }

    private static void update(Connection cnx, String tabla, String id, String[] datos) throws SQLException {
        if (datos.length != 4) return;

        PreparedStatement pstm = cnx.prepareStatement(
            String.format(
                "UPDATE %s SET nombre = ?, descripcion = ?, ubicacion = ?, capacidad = ? WHERE id_recurso = ?",
                tabla
            )
        );

        pstm.setString(1, datos[0]);
        pstm.setString(2, datos[1]);
        pstm.setString(3, datos[2]);
        pstm.setString(4, datos[3]);
        pstm.setString(5, id);

        pstm.executeUpdate();
    }

    private static int stringToInt(String datos) {
        return Integer.parseInt(datos.trim());
    }
}

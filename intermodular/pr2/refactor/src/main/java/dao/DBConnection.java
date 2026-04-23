package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url="jdbc:mariadb://127.0.0.1:3306/sistema_reservas";
    private static final String user="root";
    private static final String password="admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

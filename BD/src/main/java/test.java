import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://172.21.13.247:3306/empresa";
        String usu = "admin";
        String passwd = "admin";

        try {
            Connection cnx = DriverManager.getConnection(url, usu, passwd);
            System.out.println("Estado conexión: ");
            System.out.println(cnx.isClosed()?"cerrada":"abierta");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

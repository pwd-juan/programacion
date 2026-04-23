package dao;

import model.Administrador;

import java.sql.*;
import java.util.ArrayList;

public class AdministradorDao {

    public static int insert(Administrador a) throws SQLException {
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("INSERT INTO ADMINISTRADOR VALUES (?, ?)");
        int id;

        id = UsuarioDao.insert(a);
        ps.setInt(1, id);
        ps.setString(2, a.getTlfGuardia());
        ps.executeUpdate();

        ps.close();
        cnx.close();

        return id;
    }

    public static int delete(int id) throws SQLException {
        int colMod;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("DELETE FROM ADMINISTRADOR WHERE id_usuario = ?");

        ps.setInt(1, id);
        colMod = ps.executeUpdate();

        if (colMod == 1) {
            UsuarioDao.delete(id);
        }

        ps.close();
        cnx.close();

        return colMod;
    }

    public static int update(Administrador a) throws SQLException {
        int colMod;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("UPDATE ADMINISTRADOR SET telefono_guardia = ? WHERE id_usuario = ?");

        ps.setInt(2, a.getId());
        ps.setString(1, a.getTlfGuardia());

        colMod = ps.executeUpdate();

        if (colMod == 1) {
            UsuarioDao.update(a);
        }

        ps.close();
        cnx.close();

        return colMod;
    }

    public static ArrayList<Administrador> select() throws SQLException {
        Connection cnx = DBConnection.getConnection();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM USUARIO JOIN ADMINISTRADOR USING (id_usuario)");

        return resultSetToArrayList(rs);
    }

    public static ArrayList<Administrador> resultSetToArrayList(ResultSet rs) throws SQLException {
        ArrayList<Administrador> datos = new ArrayList<>();

        while (rs.next()) {
            datos.add(new Administrador(
                rs.getInt("id_usuario"),
                rs.getString("correo_electronico"),
                rs.getString("contrasena"),
                rs.getString("nombre"),
                rs.getDate("fecha_nacimiento").toLocalDate(),
                rs.getString("telefono_guardia")
            ));
        }

        return datos;
    }
}

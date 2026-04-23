package dao;

import model.Administrador;
import model.Normal;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao {

    public static int insert(Usuario u) throws SQLException {
        int id;
        String tipoUsuario = (u.getClass() == Normal.class) ? "Normal" : "Administrador";
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement(
            "INSERT INTO USUARIO (correo_electronico, contrasena, nombre, fecha_nacimiento, tipo_usuario) VALUES (?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );

        ps.setString(1, u.getCorreo());
        ps.setString(2, u.getContrasena());
        ps.setString(3, u.getNombre());
        ps.setDate(4, Date.valueOf(u.getFechaNacimiento()));
        ps.setString(5, tipoUsuario);

        id = ps.executeUpdate();
        return id;
    }

    public static int delete(int id) throws SQLException {
        int colMod;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("DELETE FROM USUARIO WHERE id_usuario = ?");

        ps.setInt(1, id);
        colMod = ps.executeUpdate();

        return colMod;
    }

    public static int update(Usuario u) throws SQLException {
        int colMod;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("UPDATE RECURSO SET correo_electronico = ?, contrasena = ?, nombre = ? WHERE id_usuario = ?");

        ps.setInt(4, u.getId());
        ps.setString(1, u.getCorreo());
        ps.setString(2, u.getContrasena());
        ps.setString(3, u.getNombre());
        colMod = ps.executeUpdate();

        ps.close();
        cnx.close();
        return colMod;
    }

    public static ArrayList<Usuario> select() throws SQLException {
        Connection cnx = DBConnection.getConnection();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM USUARIO LEFT JOIN USUARIONORMAL USING (id_usuario) LEFT JOIN ADMINISTRADOR USING (id_usuario)");

        stm.close();
        cnx.close();
        return resultSetToArrayList(rs);
    }

    private static ArrayList<Usuario> resultSetToArrayList(ResultSet rs) throws SQLException {
        ArrayList<Usuario> datos = new ArrayList<>();
        Usuario u;

        while (rs.next()) {
            if (rs.getString("tipo_usuario").equals("Administrador")) {
                u = new Administrador(
                        rs.getInt("id_usuario"),
                        rs.getString("correo_electronico"),
                        rs.getString("contrasena"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("telefono_guardia")
                );
            } else {
                u = new Normal(
                        rs.getInt("id_usuario"),
                        rs.getString("correo_electronico"),
                        rs.getString("contrasena"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("direccion"),
                        rs.getString("telefono_movil"),
                        rs.getString("fotografia")
                );
            }

            datos.add(u);
        }

        return datos;
    }
}

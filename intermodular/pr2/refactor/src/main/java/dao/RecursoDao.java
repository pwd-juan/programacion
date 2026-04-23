package dao;

import model.Recurso;

import java.sql.*;
import java.util.ArrayList;

public class RecursoDao {
    public static Recurso encontrarPorId(int id) throws SQLException {
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM RECURSO WHERE id_recurso = ?");
        ResultSet rs;
        ArrayList<Recurso> datos;
        Recurso resultado = null;

        ps.setInt(1, id);
        rs = ps.executeQuery();

        ps.close();
        cnx.close();

        datos = resultSetToArrayList(rs);

        if (!datos.isEmpty()) {
            resultado = datos.getFirst();
        }

        return resultado;
    }

    public static int insert(Recurso recurso) throws SQLException {
        ResultSet rsId;
        int id = -1;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement(
            "INSERT INTO RECURSO (nombre, descripcion, ubicacion, capacidad) VALUES (?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );

        ps.setString(1, recurso.getNombre());
        ps.setString(2, recurso.getDesc());
        ps.setString(3, recurso.getUbi());
        ps.setInt(4, recurso.getCapacidad());

        ps.executeUpdate();
        rsId = ps.getGeneratedKeys();
        if (rsId.next()) {id = rsId.getInt(1);}

        ps.close();
        cnx.close();

        return id;
    }

    public static int delete(int id) throws SQLException {
        int filasMod;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps;

        ps = cnx.prepareStatement("DELETE FROM RECURSO WHERE id_recurso = ?");
        ps.setInt(1, id);
        filasMod = ps.executeUpdate();

        ps.close();
        cnx.close();
        return filasMod;
    }

    public static int update(Recurso recurso) throws SQLException {
        Connection cnx = DBConnection.getConnection();
        PreparedStatement pr;
        int filasMod;

        pr = cnx.prepareStatement("UPDATE RECURSO SET nombre = ?, descripcion = ?, ubicacion = ?, capacidad = ? WHERE id_recurso = ?");
        pr.setInt(5, recurso.getId());
        pr.setString(1, recurso.getNombre());
        pr.setString(2, recurso.getDesc());
        pr.setString(3, recurso.getUbi());
        pr.setInt(4, recurso.getCapacidad());
        filasMod = pr.executeUpdate();

        cnx.close();
        return filasMod;
    }

    public static ArrayList<Recurso> selectRecurso() throws SQLException {
        Connection cnx = DBConnection.getConnection();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM RECURSO");

        stm.close();
        cnx.close();

        return resultSetToArrayList(rs);
    }

    public static ArrayList<Recurso> selectRecursoPorNombre(String nombre) throws SQLException {
        ArrayList<Recurso> recursos = new ArrayList<>();
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM RECURSO WHERE LOWER(nombre) LIKE ?");
        ps.setString(1, nombre.toLowerCase());

        ResultSet rs = ps.executeQuery();
        ps.close();
        cnx.close();

        return resultSetToArrayList(rs);
    }

    private static ArrayList<Recurso> resultSetToArrayList(ResultSet rs) throws SQLException {
        ArrayList<Recurso> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(
                new Recurso(
                    rs.getInt("id_recurso"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("ubicacion"),
                    rs.getInt("capacidad")
                )
            );
        }

        return lista;
    }
}

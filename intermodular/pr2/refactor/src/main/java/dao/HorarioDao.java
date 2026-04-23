package dao;

import model.Horario;

import java.sql.*;
import java.util.ArrayList;

public class HorarioDao {
    public static Horario encontrarPorId(int id) throws SQLException {
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("SELECT * FROM HORARIO WHERE id_horario = ?");
        ResultSet rs;
        Horario objetivo = null;

        ps.setInt(1, id);
        rs = ps.executeQuery();

        ps.close();
        cnx.close();

        if (rs.next()) {
            objetivo = new Horario(
                rs.getInt(1),
                Horario.DiasSemana.Lunes,
                rs.getTime(3).toLocalTime(),
                rs.getTime(4).toLocalTime()
            );
        }

        return objetivo;
    }

    public static int insert(Horario horario) throws SQLException {
        ResultSet rs;
        int id = -1;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement(
            "INSERT INTO HORARIO (dia_semana, hora_inicio, hora_fin) VALUES (?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );

        // ps.setString(1, horario.getDia_semana());
        ps.setTime(2, Time.valueOf(horario.getHoraInicio()));
        ps.setTime(3, Time.valueOf(horario.getHoraFin()));

        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        if (rs.next()) {id = rs.getInt(1);}

        return id;
    }

    public static int update(Horario h) throws SQLException {
        int filasMod;
        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement("UPDATE HORARIO SET dia_semana = ?, hora_inicio = ?, hora_fin = ? WHERE id_horario = ?");

        ps.setInt(4, h.getId());
        //ps.set(1, h);
        ps.setTime(2, Time.valueOf(h.getHoraInicio()));
        ps.setTime(3, Time.valueOf(h.getHoraFin()));
        filasMod = ps.executeUpdate();

        ps.close();
        cnx.close();

        return filasMod;
    }

    public static int delete(int id) throws SQLException {
        int filasEliminadas;

        Connection cnx = DBConnection.getConnection();
        PreparedStatement ps = cnx.prepareStatement(
            "DELETE FROM HORARIO WHERE id_horario = ?",
            PreparedStatement.RETURN_GENERATED_KEYS
        );

        ps.setInt(1, id);
        filasEliminadas = ps.executeUpdate();

        ps.close();
        cnx.close();
        return filasEliminadas;
    }

    public static ArrayList<Horario> select() throws SQLException {
        Connection cnx = DBConnection.getConnection();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM HORARIO");
        cnx.close();

        return resultSetToArrayList(rs);
    }

    private static ArrayList<Horario> resultSetToArrayList(ResultSet rs) throws SQLException {
        ArrayList<Horario> datos = new ArrayList<>();

        while (rs.next()) {
            datos.add(new Horario(
                rs.getInt("id_horario"),
                Horario.strToDiasSemana(rs.getString("dia_semana")),
                rs.getTime("hora_inicio").toLocalTime(),
                rs.getTime("hora_fin").toLocalTime()
            ));
        }

        return datos;
    }
}

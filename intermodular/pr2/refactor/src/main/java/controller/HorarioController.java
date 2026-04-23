package controller;

import dao.HorarioDao;
import model.Horario;

import java.sql.SQLException;
import java.util.ArrayList;

public class HorarioController {
    public static ArrayList<Horario> select() {
        try {
            return HorarioDao.select();
        } catch (SQLException e) {
            System.err.println("Se produjo un error.");
            return null;
        }
    }
}

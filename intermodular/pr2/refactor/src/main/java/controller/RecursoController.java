package controller;

import dao.RecursoDao;
import model.Recurso;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecursoController {
    public static int insert(Recurso recurso) {
        try {
            return RecursoDao.insert(recurso);
        } catch (SQLException e) {
            System.err.println("Se produjo un error.");
            return -1;
        }
    }

    public static int delete(int id) {
        try {
            return RecursoDao.delete(id);
        } catch (SQLException e) {
            System.err.println("Se produjo un error.");
            return -1;
        }
    }

    public static int update(Recurso recurso) {
        try {
            return RecursoDao.update(recurso);
        } catch (SQLException e) {
            System.err.println("Se produjo un error.");
            return -1;
        }
    }

    public static ArrayList<Recurso> selectTodo() {
        try {
            return RecursoDao.selectRecurso();
        } catch (SQLException e) {
            System.err.println("Se produjo un error.");
            return null;
        }
    }

    public static ArrayList<Recurso> selectWhereNombre(String nombre) {
        try {
            return RecursoDao.selectRecursoPorNombre(nombre);
        } catch (SQLException e) {
            System.err.println("Se produjo un error.");
            return null;
        }
    }

    public static boolean idExistente(int id) {
        boolean existe = false;
        ArrayList<Recurso> recursos = selectTodo();

        for (Recurso r : recursos) {
            if (r.getId() == id) {
                existe = true;
            }
        }

        return existe;
    }
}

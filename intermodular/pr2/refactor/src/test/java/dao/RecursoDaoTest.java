package dao;

import model.Recurso;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RecursoDaoTest {

    @Test
    void encontrarPorId() throws SQLException {
        Recurso r = new Recurso("Nombre", "Descripción", "Ubicación", 24);
        int id = dao.RecursoDao.insert(r);
        assertNotNull(dao.RecursoDao.encontrarPorId(id));
        dao.RecursoDao.delete(id);
    }

    @Test
    void insert() throws SQLException {
        Recurso r = new Recurso("Nombre", "Descripción", "Ubicación", 24);
        int id = dao.RecursoDao.insert(r);

        Recurso rComprobar = dao.RecursoDao.encontrarPorId(id);

        assertNotNull(rComprobar);
        assertEquals("Nombre", rComprobar.getNombre());
        assertEquals("Descripción", rComprobar.getDesc());
        assertEquals("Ubicación", rComprobar.getUbi());
        assertEquals(24, rComprobar.getCapacidad());

        dao.RecursoDao.delete(id);
    }

    @Test
    void delete() throws SQLException {
        int id;
        Recurso r = new Recurso("Nombre", "Descripción", "Ubicación", 24);
        id = dao.RecursoDao.insert(r);
        dao.RecursoDao.delete(id);
        assertNull(dao.RecursoDao.encontrarPorId(id));
    }

    @Test
    void update() throws SQLException {
        int id;
        Recurso r = new Recurso("Nombre", "Descripción", "Ubicación", 24);
        id = dao.RecursoDao.insert(r);
        Recurso r2 = new Recurso(id, "Nombre 2", "Descripción 2", "Ubicación 2", 80);
        dao.RecursoDao.update(r2);

        Recurso prueba = dao.RecursoDao.encontrarPorId(id);
        assertNotNull(prueba);
        assertEquals("Nombre 2", prueba.getNombre());
        assertEquals("Descripción 2", prueba.getDesc());
        assertEquals("Ubicación 2", prueba.getUbi());
        assertEquals(80, prueba.getCapacidad());

        dao.RecursoDao.delete(id);
    }
}
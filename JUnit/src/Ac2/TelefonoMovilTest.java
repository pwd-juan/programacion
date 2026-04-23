package Ac2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoMovilTest {

    @Test
    void addNewContact() {
        TelefonoMovil t = new TelefonoMovil("123456789");

        assertTrue(t.addNewContact(new Contacto("Pedro", "12345")));
        assertTrue(t.addNewContact(new Contacto("Roque", "12346")));
        assertFalse(t.addNewContact(new Contacto("Pedro", "00000")));
        assertFalse(t.addNewContact(new Contacto("Manolo", "12346")));
        assertFalse(t.addNewContact(new Contacto("Manolo", "123456789")));
    }

    @Test
    void updateContact() {
        TelefonoMovil t = new TelefonoMovil("123456789");

        t.addNewContact(new Contacto("Alberto", "0000"));

        assertTrue(t.updateContact(
                new Contacto("Alberto", "0000"),
                new Contacto("Alberto", "1111")
        ));
        assertTrue(t.updateContact(
                new Contacto("Alberto", "1111"),
                new Contacto("Nuevo Alberto", "0000")
        ));
        assertTrue(t.updateContact(
                new Contacto("Nuevo Alberto", "0000"),
                new Contacto("Alberto", "1111")
        ));

        t = new TelefonoMovil("123456789");
        t.addNewContact(new Contacto("Alberto", "0000"));
        t.addNewContact(new Contacto("Raúl", "1111"));

        assertFalse(t.updateContact(
                new Contacto("Alberto", "0000"),
                new Contacto("Alberto", "1111")
        ));
        assertFalse(t.updateContact(
                new Contacto("Alberto", "0000"),
                new Contacto("Raúl", "0000")
        ));
        assertFalse(t.updateContact(
                new Contacto("Alberto", "0000"),
                new Contacto("Alberto", "123456789")
        ));
    }

    @Test
    void removeContact() {
        TelefonoMovil t = new TelefonoMovil("123456789");
        t.addNewContact(new Contacto("Lukas", "0000"));

        assertTrue(t.removeContact(new Contacto("Lukas", "0000")));
        assertFalse(t.removeContact(new Contacto("Juan Pablo", "2222")));
    }

    @Test
    void queryContact() {
        TelefonoMovil t = new TelefonoMovil("123456789");
        t.addNewContact(new Contacto("Lukas", "0000"));

        assertEquals(new Contacto("Lukas", "0000"), t.queryContact("Lukas"));
        assertEquals(null, t.queryContact("Victor"));
    }
}
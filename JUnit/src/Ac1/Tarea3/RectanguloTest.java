package Ac1.Tarea3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectanguloTest {

    @Test
    void testArea() {
        Rectangulo r = new Rectangulo(30, 30);
        Rectangulo r2 = new Rectangulo(60, 35);

        assertEquals(900, r.area());
        assertEquals(2.100, r2.area());
    }
}
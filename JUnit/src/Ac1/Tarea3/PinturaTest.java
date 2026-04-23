package Ac1.Tarea3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinturaTest {
    @Test
    void testCantPintura() {
        Cilindro c = new Cilindro(20, 50);
        Esfera e = new Esfera(20);
        Rectangulo r = new Rectangulo(30, 30);

        Pintura p = new Pintura(500);

        assertEquals(c.area()/500, p.cantPintura(c), 0.0001);
        assertEquals(e.area()/500, p.cantPintura(e), 0.0001);
        assertEquals(r.area()/500, p.cantPintura(r), 0.0001);
    }
}
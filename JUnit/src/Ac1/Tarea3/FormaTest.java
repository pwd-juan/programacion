package Ac1.Tarea3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormaTest {
    @Test
    void testToString() {
        Cilindro c = new Cilindro(20, 50);
        Esfera e = new Esfera(20);
        Rectangulo r = new Rectangulo(30, 30);

        assertEquals("Cilindro", c.toString());
        assertEquals("Esfera", e.toString());
        assertEquals("Rectángulo", r.toString());
    }
}
package Ac1.Tarea3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CilindroTest {

    @Test
    void area() {
        Cilindro c = new Cilindro(20, 40);
        Cilindro c2 = new Cilindro(35, 35);

        assertEquals(50265.4824, c.area(), 0.0001);
        assertEquals(134695.785, c2.area(), 0.0001);
    }
}
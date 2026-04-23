package Ac1.Tarea3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EsferaTest {

    @Test
    void area() {
        Esfera e = new Esfera(35);
        Esfera e2 = new Esfera(60);

        assertEquals(15393.804, e.area(), 0.0001);
        assertEquals(45238.9342, e2.area(), 0.0001);
    }
}
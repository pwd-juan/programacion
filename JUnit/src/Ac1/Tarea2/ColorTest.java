package Ac1.Tarea2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    @Test
    public void testQueColorSoy() {
        assertEquals("rojo", Color.queColorSoy("Antonio"));
        assertEquals("rojo", Color.queColorSoy("Bernardo"));
        assertEquals("rojo", Color.queColorSoy("Catalina"));
        assertEquals("rojo", Color.queColorSoy("Diana"));
        assertEquals("rojo", Color.queColorSoy("Efrén"));
        assertEquals("rojo", Color.queColorSoy("Francisco"));
        assertEquals("verde", Color.queColorSoy("Gemma"));
        assertEquals("verde", Color.queColorSoy("Helena"));
        assertEquals("verde", Color.queColorSoy("Iván"));
        assertEquals("verde", Color.queColorSoy("José Andrés"));
        assertEquals("verde", Color.queColorSoy("Kenia"));
        assertEquals("verde", Color.queColorSoy("Lourdes"));
        assertEquals("verde", Color.queColorSoy("Manuel"));
        assertEquals("azul", Color.queColorSoy("Nicolás"));
        assertEquals("azul", Color.queColorSoy("Ofelia"));
        assertEquals("azul", Color.queColorSoy("Patricia"));
        assertEquals("azul", Color.queColorSoy("Quasimodo"));
        assertEquals("azul", Color.queColorSoy("Ramón"));
        assertEquals("azul", Color.queColorSoy("Sonia"));
        assertEquals("amarillo", Color.queColorSoy("Tamara"));
        assertEquals("amarillo", Color.queColorSoy("Unai"));
        assertEquals("amarillo", Color.queColorSoy("Víctor"));
        assertEquals("amarillo", Color.queColorSoy("Wendy"));
        assertEquals("amarillo", Color.queColorSoy("Xacinta"));
        assertEquals("amarillo", Color.queColorSoy("Yerai"));
        assertEquals("amarillo", Color.queColorSoy("Zacarías"));
    }

}
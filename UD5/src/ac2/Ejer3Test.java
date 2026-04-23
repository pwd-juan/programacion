package ac2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejer3Test {
    @Test
    void testImprimirDobleCaraActivada() {
        boolean isDobleCara = true;
        Impresora impresora = new Impresora(new Tonel("ASD-132", 100), isDobleCara);
        int entrada = 10;
        int salidaEsperada = 5;
        int salidaRecibida = impresora.imprimir(entrada);
        assertEquals(salidaEsperada, salidaRecibida);
    }
}
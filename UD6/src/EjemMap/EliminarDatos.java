package EjemMap;

import java.util.HashMap;
import java.util.Map;

public class EliminarDatos {
    public static void main(String[] args) {
        Map<String, String> idiomas = new HashMap<>();
        idiomas.put("es", "Español");
        idiomas.put("en", "English EEUU");
        idiomas.put("ca", "English Canadá");
        idiomas.put("de", "Aleman");
        idiomas.put("fr", "Francés");

        //Forma 1
        String eliminado = idiomas.remove("fr");

        //Forma 2
        if (idiomas.remove("de", "Ingles")) {
            System.out.println("de ha sido eliminado");
        } else {
            System.out.println("No existe un par clave-valor con de-Ingles");
        }

        System.out.println(eliminado);
        System.out.println(idiomas);
    }
}

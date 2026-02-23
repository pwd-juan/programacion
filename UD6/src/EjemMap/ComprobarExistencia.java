package EjemMap;

import java.util.HashMap;
import java.util.Map;

public class ComprobarExistencia {
    public static void main(String[] args) {
        Map<String, String> idiomas = new HashMap<>();
        idiomas.put("es", "Español");
        idiomas.put("en", "English EEUU");
        idiomas.put("ca", "English Canadá");
        idiomas.put("de", "Aleman");
        idiomas.put("fr", "Francés");

        if (idiomas.containsKey("es")) {
            System.out.println("La clave es ya existe");
        }

        if (idiomas.containsValue("Español")) {
            System.out.println("El idioma español ya existe");
        }
    }
}

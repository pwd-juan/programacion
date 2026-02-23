package EjemMap;

import java.util.HashMap;
import java.util.Map;

public class CrearMap {
    public static void main(String[] args) {
        Map<String, String> idiomas = new HashMap<>();
        idiomas.put("es", "Español");
        idiomas.put("en", "English EEUU");
        idiomas.put("ca", "English Canadá");
        idiomas.put("de", "Aleman");
        idiomas.put("fr", "Francés");

        System.out.println(idiomas.put("it", "Italian")); //devuelve null
        System.out.println(idiomas.put("it", "Italiano")); //devuelve el valor previo "Italian", lo que significa que se ha sobreescrito

        System.out.println(idiomas);
    }
}

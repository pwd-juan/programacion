package EjemMap;

import java.util.HashMap;
import java.util.Map;

public class ImprimirMaps {
    public static void main(String[] args) {
        Map<String, String> idiomas = new HashMap<>();
        idiomas.put("es", "Español");
        idiomas.put("en", "English EEUU");
        idiomas.put("ca", "English Canadá");
        idiomas.put("de", "Aleman");
        idiomas.put("fr", "Francés");

        for(String key: idiomas.keySet()) {
            System.out.println(key + " " + idiomas.get(key));
        }

        System.out.println("---");

        for (Map.Entry<String, String> entradaMapa: idiomas.entrySet()) {
            System.out.println(entradaMapa.getKey() + " " + entradaMapa.getValue());
        }
    }
}

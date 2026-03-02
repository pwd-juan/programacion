package Arte;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Artista {
    private final String Nombre;
    private final String Nacionalidad;
    private LinkedList<Map> obras;

    public Artista(String nombre, String nacionalidad) {
        this.Nombre = nombre;
        this.Nacionalidad = nacionalidad;
        obras = new LinkedList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public LinkedList<Map> getObras() {
        return obras;
    }

    public boolean setObra(String nombre, String tipo, String precio, String anyoRealizacion) {
        Map<String, String> obra = new HashMap<>();
        obra.put("Nombre", nombre);
        obra.put("Tipo", tipo);
        obra.put("Precio", precio);
        obra.put("Realizacion", anyoRealizacion);
        return obras.add(obra);
    }

    public Map<String, Integer> getPrecioObras() {
        Map<String, Integer> precios = new HashMap<>();

        for (Map obra : obras) {
            precios.put(
                (String) obra.get("Nombre"),
                normalizarPreciosObras((String) obra.get("Precio"))
            );
        }

        return precios;
    }

    private int normalizarPreciosObras(String precio) {
        String subPrecio1;
        String subPrecio2;

        while (precio.contains(",")) {
            subPrecio1 = precio.substring(0, precio.indexOf(','));
            subPrecio2 = precio.substring(precio.indexOf(','), precio.length() - 1);

            precio = subPrecio1 + subPrecio2;
        }

        if (precio.charAt(precio.length() - 1) == 'M') {
            precio = precio.substring(0, precio.length() - 1);
            precio = precio + "000000";
        }

        for (int i = 0; i < precio.length(); i++){
            if (!Character.isDigit(precio.charAt(i)))
                throw new RuntimeException("El precio contiene elementos no convertibles.");
        }

        return Integer.parseInt(precio);
    }
}

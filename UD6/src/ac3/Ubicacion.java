package ac3;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String descripcion;
    private Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
        exits = new HashMap<>();
    }

    public boolean addExit(String direccion, int idUbicacion){
        if (direccion.length() != 1) return false;

        exits.put(direccion, idUbicacion);
        return true;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
}

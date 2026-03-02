package Arte2;

import java.util.LinkedList;

public class Artista {
    private final String Nombre;
    private final String Nacionalidad;
    private LinkedList obras;

    public Artista (String nombre, String nacionalidad) {
        this.Nombre = nombre;
        this.Nacionalidad = nacionalidad;
        obras = new LinkedList<>();
    }
}

package Arte2;

public class Artista {
    private final String Nombre;
    private final String Nacionalidad;

    public Artista (String nombre, String nacionalidad) {
        this.Nombre = nombre;
        this.Nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    @Override
    public String toString() {
        return this.Nombre + " | " + this.Nacionalidad;
    }
}

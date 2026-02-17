package ac2;

public class Cancion {
    private final String titulo;
    private final double duracion;

    public Cancion(String titulo, double duracion){
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + ": " +duracion;
    }
}

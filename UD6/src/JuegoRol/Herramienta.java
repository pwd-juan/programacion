package JuegoRol;

public class Herramienta {
    private String nombre;
    private int valor;

    public Herramienta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor() {
        this.valor = (int)(Math.random() * 4) + 1;
    }

    public void limpiarValor() {
        this.valor = 0;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

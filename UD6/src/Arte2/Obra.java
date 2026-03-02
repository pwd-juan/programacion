package Arte2;

public class Obra {
    private final String Nombre;
    private final String Tipo;
    private int precio;
    private final int anyoCreacion;

    public Obra(String nombre, String tipo, int precio, int anyoCreacion) {
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.anyoCreacion = anyoCreacion;
        this.precio = precio;
    }

    public Obra(String nombre, String tipo, String precio, int anyoCreacion) {
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.anyoCreacion = anyoCreacion;
        this.precio = normalizarPrecio(precio);
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public int getAnyoCreacion() {
        return anyoCreacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPrecio(String precio) {
        this.precio = normalizarPrecio(precio);
    }

    private int normalizarPrecio(String precio) {
        if (precio.charAt(precio.length() - 1) == 'M') {
            precio = precio.substring(0, precio.length() - 1);
            precio += "000000";
        }

        for (int i = 0; i < precio.length(); i++) {
            if (!Character.isDigit(precio.charAt(i)))
                throw new RuntimeException("Caracteres no convertibles en precio de obra.");
        }

        return Integer.parseInt(precio);
    }

    @Override
    public String toString() {
        return Nombre + " | " +
                Tipo + " | " +
                precio + " | " +
                anyoCreacion;
    }
}

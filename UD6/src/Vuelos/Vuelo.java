package Vuelos;

public class Vuelo {
    private final String numero;
    private final String origen;
    private final String destino;
    private final String dia;
    private final String clase;

    public Vuelo (String numero, String origen, String destino, String dia, String clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
    }

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDia() {
        return dia;
    }

    public String getClase() {
        return clase;
    }

    @Override
    public String toString() {
        return "Numero='" + numero + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", dia='" + dia + '\'' +
                ", clase='" + clase
                ;
    }
}

package Vuelos;

import java.util.HashMap;
import java.util.Map;

public class Vuelo {
    private String numero;
    private String origen;
    private String destino;
    private String dia;
    private String clase;
    private Map<String, String> valores;

    public Vuelo () {
        valores = new HashMap<>();
    }

    public Vuelo (String numero, String origen, String destino, String dia, String clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
        valores = new HashMap<>();
        generarValores(valores);
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

    public Map<String, String> getValores() {return valores;}

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Numero: " + numero +
                ", origen: " + origen +
                ", destino: " + destino +
                ", dia: " + dia +
                ", clase: " + clase
                ;
    }

    private void generarValores(Map<String, String> v) {
        v.put("NÚMERO", numero);
        v.put("ORIGEN", origen);
        v.put("DESTINO", destino);
        v.put("DÍA", dia);
        v.put("CLASE", clase);
    }
}

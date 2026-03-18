package Ac10;

import java.util.Objects;

public class Jugador {
    private int rango;
    private String nombre;
    private boolean utilizaHotel;
    private boolean esCV;

    public Jugador(int rango, String nombre, boolean utilizaHotel, boolean esCV) {
        this.rango = rango;
        this.nombre = nombre;
        this.utilizaHotel = utilizaHotel;
        this.esCV = esCV;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isUtilizaHotel() {
        return utilizaHotel;
    }

    public void setUtilizaHotel(boolean utilizaHotel) {
        this.utilizaHotel = utilizaHotel;
    }

    public boolean isEsCV() {
        return esCV;
    }

    public void setEsCV(boolean esCV) {
        this.esCV = esCV;
    }
}

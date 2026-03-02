package JuegoRol;

import java.util.ArrayList;

public class Personaje {
    public enum Tipo {
        INVENTOR,
        GUERRERA,
        RASTREADOR,
        MAGA,
        SABIO,
        EXPLORADORA
    }

    private String nombre;
    private Tipo tipo;
    private ArrayList<Herramienta> mochila;
    private int vida;

    public Personaje(String nombre, Tipo tipo, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        mochila = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public ArrayList<Herramienta> getMochila() {
        return mochila;
    }

    public boolean anyadirHerramienta(String h) {
        return anyadirHerramienta(new Herramienta(h));
    }

    public boolean anyadirHerramienta(Herramienta h) {
        return mochila.add(h);
    }

    public boolean eliminarHerramienta(Herramienta h) {
        return mochila.remove(h);
    }

    public void aumentarVida(int i) {
        this.vida = this.vida + i;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", mochila=" + mochila +
                ", vida=" + vida +
                '}';
    }
}

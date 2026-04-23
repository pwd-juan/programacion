package Ejer11;

public class Jugador {
    private String nombre;
    private int ranking;
    private int ELO;
    private double puntos;

    public Jugador(String nombre, int ELO, double puntos) {
        this.nombre = nombre;
        this.ELO = ELO;
        this.puntos = puntos;
    }

    public Jugador(int ranking, int ELO, double puntos) {
        this.ranking = ranking;
        this.ELO = ELO;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getELO() {
        return ELO;
    }

    public void setELO(int ELO) {
        this.ELO = ELO;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}

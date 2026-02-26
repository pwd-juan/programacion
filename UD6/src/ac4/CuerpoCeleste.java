package ac4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste{
        ESTRELLA,
        PLANETA,
        PLANETA_ENANO,
        LUNA,
        COMETA,
        ASTEROIDE
    }

    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo){
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        satelites = new HashSet<>();
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(satelites);
    }

    public boolean addSatelite(CuerpoCeleste cuerpo) {
        return satelites.add(cuerpo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        CuerpoCeleste cuerpo = (CuerpoCeleste) o;
        return this.nombre.equals(cuerpo.getNombre()) && this.tipoCuerpo == cuerpo.getTipoCuerpo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo) + (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", " + this.periodoOrbital;
    }
}

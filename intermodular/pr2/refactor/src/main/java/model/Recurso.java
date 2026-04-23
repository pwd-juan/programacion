package model;

import java.util.Objects;

public class Recurso {
    private int id;
    private String nombre;
    private String desc;
    private String ubi;
    private int capacidad;

    public Recurso(int id, String nombre, String desc, String ubi, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.desc = desc;
        this.ubi = ubi;
        this.capacidad = capacidad;
    }

    public Recurso(String nombre, String desc, String ubi, int capacidad) {
        this.nombre = nombre;
        this.desc = desc;
        this.ubi = ubi;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUbi() {
        return ubi;
    }

    public void setUbi(String ubi) {
        this.ubi = ubi;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Recurso: " +
                id + " " +
                nombre + " " +
                desc + " " +
                ubi + " " +
                capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recurso recurso = (Recurso) o;
        return id == recurso.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

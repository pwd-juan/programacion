package model;

import java.time.LocalDate;

public class Administrador extends Usuario {
    private String tlfGuardia;


    public Administrador(int id, String correo, String contrasena, String nombre, LocalDate fechaNacimiento, String tlfGuardia) {
        super(id, correo, contrasena, nombre, fechaNacimiento);
        this.tlfGuardia = tlfGuardia;
    }

    public String getTlfGuardia() {
        return tlfGuardia;
    }

    public void setTlfGuardia(String tlfGuardia) {
        this.tlfGuardia = tlfGuardia;
    }
}

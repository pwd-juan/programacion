package model;

import java.time.LocalDate;

public class Normal extends Usuario {
    private String direccion;
    private String tlf_movil;
    private String fotografia;

    public Normal(int id, String correo, String contrasena, String nombre, LocalDate fechaNacimiento, String direccion, String tlf_movil, String fotografia) {
        super(id, correo, contrasena, nombre, fechaNacimiento);
        this.direccion = direccion;
        this.tlf_movil = tlf_movil;
        this.fotografia = fotografia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTlf_movil() {
        return tlf_movil;
    }

    public void setTlf_movil(String tlf_movil) {
        this.tlf_movil = tlf_movil;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
}

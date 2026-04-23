package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int idRecurso;
    private int idReserva;
    private int idUsuario;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private double coste;
    private int numPlazas;
    private String motivo;
    private String observaciones;

    public Reserva(int idRecurso, int idReserva, int idUsuario, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, double coste, int numPlazas, String motivo, String observaciones) {
        this.idRecurso = idRecurso;
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.coste = coste;
        this.numPlazas = numPlazas;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

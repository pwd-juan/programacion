package model;

import java.time.LocalTime;

public class Horario {

    public enum DiasSemana {Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo}

    private int id;
    private DiasSemana diasSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(int id, DiasSemana diasSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.diasSemana = diasSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiasSemana getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(DiasSemana diasSemana) {
        this.diasSemana = diasSemana;
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

    public static DiasSemana strToDiasSemana(String dia) {
        DiasSemana r;

        switch (dia.toLowerCase()) {
            case "lunes" -> r = DiasSemana.Lunes;
            case "martes" -> r = DiasSemana.Martes;
            case "miércoles", "miercoles" -> r = DiasSemana.Miércoles;
            case "jueves" -> r = DiasSemana.Jueves;
            case "viernes" -> r = DiasSemana.Viernes;
            case "sábado", "sabado" -> r = DiasSemana.Sábado;
            case "domingo" -> r = DiasSemana.Domingo;
            default -> throw new RuntimeException("No se valora para el día indicado.");
        }

        return r;
    }
}

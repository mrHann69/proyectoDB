package laboratoio.clinico.modelo;

import java.time.LocalDate;

public class OrdenExamen {
    private String consecutivo, examen;
    LocalDate fechaCita, fechaRealizacion;

    public OrdenExamen() {

    }

    public OrdenExamen(String consecutivo, String examen, LocalDate fechaCita, LocalDate fechaRealizacion) {
        this.consecutivo = consecutivo;
        this.examen = examen;
        this.fechaCita = fechaCita;
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
}

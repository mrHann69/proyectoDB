
package modelo;

import java.time.LocalDate;

public class Orden {
        private String consecutivo;
        private int cedulaPaciente;
        private LocalDate fechaSolicitud;
        private LocalDate fechaIngreso;
        private int cedulaMedico;
        private String numOrdenMed;

    public Orden(String consecutivo, int cedulaPaciente, LocalDate fechaSolicitud, LocalDate fechaIngreso, int cedulaMedico, String numOrdenMed) {
        this.consecutivo = consecutivo;
        this.cedulaPaciente = cedulaPaciente;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaIngreso = fechaIngreso;
        this.cedulaMedico = cedulaMedico;
        this.numOrdenMed = numOrdenMed;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(int cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getCedulaMedico() {
        return cedulaMedico;
    }

    public void setCedulaMedico(int cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }

    public String getNumOrdenMed() {
        return numOrdenMed;
    }

    public void setNumOrdenMed(String numOrdenMed) {
        this.numOrdenMed = numOrdenMed;
    }
    
        
}


package modelo;

import java.time.LocalDate;

public class OrdenMedica {
        private int consecutivo;
        private LocalDate fechaingreso;    
        private String medicoTratante ;
        private int numeroOrden;
        private LocalDate fechaSolicitud;

    public OrdenMedica(int consecutivo, LocalDate fechaingreso, String medicoTratante, int numeroOrden, LocalDate fechaSolicitud) {
        this.consecutivo = consecutivo;
        this.fechaingreso = fechaingreso;
        this.medicoTratante = medicoTratante;
        this.numeroOrden = numeroOrden;
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public LocalDate getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(LocalDate fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getMedicoTratante() {
        return medicoTratante;
    }

    public void setMedicoTratante(String medicoTratante) {
        this.medicoTratante = medicoTratante;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    
}

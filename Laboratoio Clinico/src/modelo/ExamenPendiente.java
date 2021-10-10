
package modelo;

import java.time.LocalDate;

public class ExamenPendiente {
    private int cedula;
    private String nombre;
    private String apellido;
    private String consecutivo;
    private String examen;
    private String fechaCita;

    public ExamenPendiente(int cedula, 
                            String nombre,
                            String apellido,
                            String consecutivo,
                            String examen,
                            String fechaCita) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.consecutivo = consecutivo;
        this.examen = examen;
        this.fechaCita = fechaCita;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
    
}
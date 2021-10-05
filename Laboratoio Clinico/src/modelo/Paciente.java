
package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Paciente {
    private int cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String POS;
    private String telefonoContacto;
    private String cedulaContacto;
    
    public Paciente(int cedula, String nombre, String apellido, LocalDate fechaNacimiento, String POS, String telefonoContacto, String cedulaContacto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.POS = POS;
        this.telefonoContacto = telefonoContacto;
        this.cedulaContacto = cedulaContacto;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPOS() {
        return POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCedulaContacto() {
        return cedulaContacto;
    }

    public void setCedulaContacto(String cedulaContacto) {
        this.cedulaContacto = cedulaContacto;
    }
    
}

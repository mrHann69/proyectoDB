
package modelo;

import java.time.LocalDate;

public class Paciente {
    private int cedula;
    private LocalDate fechaNacimiento;
    private String POS;
    private String telefonoContacto;
    private String cedulaContacto;

    public Paciente(int cedula, LocalDate fechaNacimiento, String POS, String telefonoContacto, String cedulaContacto) {
        this.cedula = cedula;
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


package modelo;

public class Contacto {
    private String cedulaContacto;
    private String nombreContacto;
    private String telefonoContacto;

    public Contacto(String cedulaContacto, String nombreContacto, String telefonoContacto) {
        this.cedulaContacto = cedulaContacto;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
    }

    public String getCedulaContacto() {
        return cedulaContacto;
    }

    public void setCedulaContacto(String cedulaContacto) {
        this.cedulaContacto = cedulaContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
}

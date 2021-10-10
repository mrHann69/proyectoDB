
package modelo;

public class Login {
    private String cedula;
    private String contraseña;

    public Login(String cedula, String contraseña) {
        this.cedula = cedula;
        this.contraseña = contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}

package laboratoio.clinico.modelo;

public class Examen {
    private String tipoExamen;
    private double precio;

    public Examen() {

    }

    public Examen(String tipoExamen, double precio) {
        this.tipoExamen = tipoExamen;
        this.precio = precio;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

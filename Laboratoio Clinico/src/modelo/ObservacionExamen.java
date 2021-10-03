package modelo;

public class ObservacionExamen {
    private String numeroOrden, tipoExamen, observacion;

    public ObservacionExamen() {

    }

    public ObservacionExamen(String numeroOrden, String tipoExamen, String observacion) {
        this.numeroOrden = numeroOrden;
        this.tipoExamen = tipoExamen;
        this.observacion = observacion;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}

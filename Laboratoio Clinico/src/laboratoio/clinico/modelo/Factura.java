package laboratoio.clinico.modelo;
import java.time.LocalDate;

import javax.swing.SizeRequirements;

public class Factura {
    private String numeroFactura, conseOrden, estadoFactura;
    private double valorPago;
    private LocalDate fechaRealizacion;

    public Factura() {

    };

    public Factura(String numeroFactura, String conseOrden, LocalDate fechaRealizacion, double valorPago, String estadoFactura) {
        this.numeroFactura = numeroFactura;
        this.conseOrden = conseOrden;
        this.fechaRealizacion = fechaRealizacion;
        this.valorPago = valorPago;
        this.estadoFactura = estadoFactura;
    };

    public String getNumFactura() {
        return numeroFactura;
    }

    public String getConseOrden () {
        return conseOrden;
    }

    public String getEstFactura () {
        return estadoFactura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setNumFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setConseOrden(String conseOrden) {
        this.conseOrden = conseOrden;
    }

    public void setEstFactura (String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setFechaRealizacion (LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
}
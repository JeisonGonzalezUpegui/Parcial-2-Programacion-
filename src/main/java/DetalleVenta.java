public class DetalleVenta {
    private int cantidad;
    private double precioUnitarioFinal;
    private double subtotal;

    public DetalleVenta(int cantidad, double precioUnitarioFinal, double subtotal) {
        this.cantidad = cantidad;
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public void setPrecioUnitarioFinal(double precioUnitarioFinal) {
        this.precioUnitarioFinal = precioUnitarioFinal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

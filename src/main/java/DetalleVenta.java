public class DetalleVenta {
    private Inventario inventario;
    private int cantidad;
    private double precioUnitarioFinal;
    private double subtotal;

    public DetalleVenta(Inventario inventario, int cantidad, Cliente cliente) {
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.precioUnitarioFinal = calcularPrecioUnitarioFinal(cliente);
        this.subtotal = calcularSubtotal();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public double getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "Prenda: " + inventario.getPrenda().getNombre()
                + "\nTalla: " + inventario.getTalla()
                + "\nColor: " + inventario.getColor()
                + "\nCantidad: " + cantidad
                + "\nPrecio unitario final: " + precioUnitarioFinal
                + "\nSubtotal: " + subtotal;
    }
    //precio con recargo menos el descuento del cliente
    public double calcularPrecioUnitarioFinal(Cliente cliente) {
        double precioConRecargo = inventario.getPrenda().calcularPrecioConRecargo();
        double precioFinal = precioConRecargo - (precioConRecargo * cliente.calcularDescuento());
        precioUnitarioFinal = precioFinal;
        return precioFinal;
    }

    public double calcularSubtotal() {
        subtotal = precioUnitarioFinal * cantidad;
        return subtotal;
    }
}
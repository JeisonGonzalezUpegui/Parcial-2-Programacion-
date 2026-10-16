import java.util.ArrayList;

public class Inventario {
    private Prenda prenda;
    private Sucursal sucursal;
    private Talla talla;
    private String color;
    private int cantidad;
    private ArrayList<DetalleVenta> listaDetalles;

    public Inventario(Prenda prenda, Sucursal sucursal, Talla talla, String color, int cantidad) {
        this.prenda = prenda;
        this.sucursal = sucursal;
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
        listaDetalles = new ArrayList<>();
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
    @Override
    public String toString() {
        return "Prenda: " + prenda.getNombre()
                + "\nCodigo: " + prenda.getCodigo()
                + "\nTalla: " + talla
                + "\nColor: " + color
                + "\nCantidad disponible: " + cantidad;
    }

    //verificar que alcance la cantidad pedida
    public boolean hayExistencias(int cantidadSolicitada) {
        boolean hay = false;
        if (cantidad >= cantidadSolicitada) {
            hay = true;
        }
        return hay;
    }

    //descontar unidades del inventario
    public void descontar(int cantidadVendida) {
        cantidad = cantidad - cantidadVendida;
    }

    public boolean estaAgotado() {
        boolean agotado = false;
        if (cantidad == 0) {
            agotado = true;
        }
        return agotado;
    }

    //guardar el detalle en el historial de ventas
    public void agregarDetalle(DetalleVenta detalle) {
        listaDetalles.add(detalle);
    }

    //total de unidades vendidas de este inventario
    public int unidadesVendidas() {
        int total = 0;
        for (DetalleVenta detalle : listaDetalles) {
            total = total + detalle.getCantidad();
        }
        return total;
    }
}
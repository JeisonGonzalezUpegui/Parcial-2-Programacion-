import java.util.ArrayList;

public class Inventario {
    private Talla talla;
    private String color;
    private int cantidad;
    private ArrayList<DetalleVenta> listaDetalleVentas;

    public Inventario(Talla talla, String color, int cantidad, ArrayList<DetalleVenta> listaDetalleVentas) {
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
        this.listaDetalleVentas = listaDetalleVentas;
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

    public ArrayList<DetalleVenta> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(ArrayList<DetalleVenta> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }
}

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private String codigo;
    private LocalDate fecha;
    private ArrayList<DetalleVenta> listaDetalleVentas;

    public Venta(String codigo, LocalDate fecha, ArrayList<DetalleVenta> listaDetalleVentas) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.listaDetalleVentas = listaDetalleVentas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<DetalleVenta> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(ArrayList<DetalleVenta> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }
}

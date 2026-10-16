import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private String codigoAfiliacion;
    private CategoriaCliente categoriaCliente;
    private List<Venta> compras;

    public Cliente(String documento, String nombreCompleto, String correo, String telefono,
                   String codigoAfiliacion, CategoriaCliente categoria) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoria;
        this.compras = new ArrayList<>();
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoria() {
        return categoriaCliente;
    }

    public void setCategoria(CategoriaCliente categoria) {
        this.categoriaCliente = categoria;
    }

    public double calcularDescuento() {
        return categoriaCliente.getDescuento();
    }

    public List<Venta> consultarCompras() {
        return compras;
    }
}

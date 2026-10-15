import java.util.ArrayList;

public class Cliente extends Persona{
    private String codigoAfiliacion;
    private CategoriaCliente categoriaCliente;
    private ArrayList<Venta> listaVentas;

    public Cliente(String codigoAfiliacion, CategoriaCliente categoriaCliente, ArrayList<Venta> listaVentas) {
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoriaCliente;
        this.listaVentas = listaVentas;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}

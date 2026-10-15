import java.util.ArrayList;

public class Sucursal {
    private String nombre;
    private String codigo;
    private String direccion;
    private String ciudad;
    private ArrayList<Vendedor> listaVendedores;
    private ArrayList<Inventario> listaInventarios;
    private ArrayList<Venta> listaVentas;

    public Sucursal(String nombre, String codigo, String direccion, String ciudad, ArrayList<Vendedor> listaVendedores, ArrayList<Inventario> listaInventarios, ArrayList<Venta> listaVentas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.listaVendedores = listaVendedores;
        this.listaInventarios = listaInventarios;
        this.listaVentas = listaVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public ArrayList<Inventario> getListaInventarios() {
        return listaInventarios;
    }

    public void setListaInventarios(ArrayList<Inventario> listaInventarios) {
        this.listaInventarios = listaInventarios;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}

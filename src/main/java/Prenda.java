import java.util.ArrayList;

public class Prenda {
    private String nombre;
    private String codigo;
    private String marca;
    private double precioBase;
    private CategoriaPrenda categoriaPrenda;
    private ArrayList<Inventario> listaInventarios;

    public Prenda(String nombre, String codigo, String marca, double precioBase, CategoriaPrenda categoriaPrenda, ArrayList<Inventario> listaInventarios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoriaPrenda = categoriaPrenda;
        this.listaInventarios = listaInventarios;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return categoriaPrenda;
    }

    public void setCategoriaPrenda(CategoriaPrenda categoriaPrenda) {
        this.categoriaPrenda = categoriaPrenda;
    }

    public ArrayList<Inventario> getListaInventarios() {
        return listaInventarios;
    }

    public void setListaInventarios(ArrayList<Inventario> listaInventarios) {
        this.listaInventarios = listaInventarios;
    }
}

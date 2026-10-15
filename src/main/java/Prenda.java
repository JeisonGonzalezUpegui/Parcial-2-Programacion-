import java.util.ArrayList;

public class Prenda {
    private String nombre;
    private String codigo;
    private String marca;
    private double precioBase;
    private CategoriaPrenda categoria;
    private ArrayList<Inventario> listaInventarios;

    public Prenda(String nombre, String codigo, String marca, double precioBase, CategoriaPrenda categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoria = categoria;
        listaInventarios = new ArrayList<>();
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

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Inventario> getListaInventarios() {
        return listaInventarios;
    }
    @Override
    public String toString() {
        return "Prenda: " + nombre
                + "\nCodigo: " + codigo
                + "\nMarca: " + marca
                + "\nPrecio base: " + precioBase
                + "\nCategoria: " + categoria;
    }

    //precio base + recargo de la categoria
    public double calcularPrecioConRecargo() {
        return precioBase + (precioBase * categoria.getRecargo());
    }
    //total de unidades vendidas de la prenda en todas las sucursales
    public int calcularUnidadesVendidas() {
        int total = 0;
        for (Inventario inventario : listaInventarios) {
            total = total + inventario.unidadesVendidas();
        }
        return total;
    }
}
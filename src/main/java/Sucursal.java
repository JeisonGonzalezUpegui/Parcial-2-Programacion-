import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String nombre;
    private String codigo;
    private String direccion;
    private String ciudad;

    private ArrayList<Inventario> listaInventarios;
    private ArrayList<Vendedor> listaVendedores;
    private ArrayList<Venta> listaVentas;

    public Sucursal(String nombre, String codigo, String direccion, String ciudad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;

        listaInventarios = new ArrayList<>();
        listaVendedores = new ArrayList<>();
        listaVentas = new ArrayList<>();
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

    public ArrayList<Inventario> getListaInventarios() {
        return listaInventarios;
    }

    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    // registrar existencias de una prenda sin duplicar referencia, talla y color
    public boolean registrarExistencia(Prenda prenda, Talla talla, String color, int cantidad) {
        boolean agregado = false;
        boolean tallaValida = false;
        boolean esTallaRopa = false;

        if (talla == Talla.XS || talla == Talla.S ||
                talla == Talla.M || talla == Talla.L ||
                talla == Talla.XL) {
            esTallaRopa = true;
        }

        if (prenda.getCategoria() == CategoriaPrenda.CALZADO) {
            tallaValida = esTallaRopa == false;
        } else {
            tallaValida = esTallaRopa;
        }

        Inventario existente = buscarInventario(prenda, talla, color);

        if (existente == null && tallaValida && cantidad >= 0) {
            Inventario inventario = new Inventario(
                    prenda, this, talla, color, cantidad
            );

            listaInventarios.add(inventario);
            prenda.getListaInventarios().add(inventario);

            agregado = true;
        }

        return agregado;
    }
    //buscar inventario por prenda, talla y color
    public Inventario buscarInventario(Prenda prenda, Talla talla, String color) {
        for (Inventario inventario : listaInventarios) {
            if (inventario.getPrenda().getCodigo().equals(prenda.getCodigo())
                    && inventario.getTalla() == talla
                    && inventario.getColor().equalsIgnoreCase(color)) {
                return inventario;
            }
        }
        return null;
    }

    //prendas con unidades disponibles
    public List<Inventario> consultarPrendasDisponibles() {
        List<Inventario> disponibles = new ArrayList<>();
        for (Inventario inventario : listaInventarios) {
            if (inventario.estaAgotado() == false) {
                disponibles.add(inventario);
            }
        }
        return disponibles;
    }

    //prendas agotadas
    public List<Inventario> consultarPrendasAgotadas() {
        List<Inventario> agotadas = new ArrayList<>();
        for (Inventario inventario : listaInventarios) {
            if (inventario.estaAgotado()) {
                agotadas.add(inventario);
            }
        }
        return agotadas;
    }

    //ingresos de la sucursal
    public double calcularIngresosTotales() {
        double total = 0;
        for (Venta venta : listaVentas) {
            total = total + venta.calcularTotal();
        }
        return total;
    }
    // buscar vendedor por documento
    public Vendedor buscarVendedor(String documento) {
        Vendedor vendedorEncontrado = null;

        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getDocumento().equals(documento)) {
                vendedorEncontrado = vendedor;
                break;
            }
        }

        return vendedorEncontrado;
    }

    // inventarios disponibles de una prenda
    public List<Inventario> consultarDisponiblesPorPrenda(String codigoPrenda) {
        List<Inventario> resultado = new ArrayList<>();

        for (Inventario inventario : consultarPrendasDisponibles()) {
            if (inventario.getPrenda().getCodigo().equals(codigoPrenda)) {
                resultado.add(inventario);
            }
        }

        return resultado;
    }
}
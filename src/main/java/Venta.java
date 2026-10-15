import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private String codigo;
    private LocalDate fecha;
    private boolean confirmada;
    private Cliente cliente;
    private Vendedor vendedor;
    private Sucursal sucursal;
    private ArrayList<DetalleVenta> listaDetalles;

    public Venta(String codigo, LocalDate fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.confirmada = false;
        listaDetalles = new ArrayList<>();
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

    public boolean isConfirmada() {
        return confirmada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public ArrayList<DetalleVenta> getListaDetalles() {
        return listaDetalles;
    }
    @Override
    public String toString() {
        return "Venta: " + codigo
                + "\nFecha: " + fecha
                + "\nCliente: " + cliente.getNombreCompleto()
                + "\nVendedor: " + vendedor.getNombreCompleto()
                + "\nSucursal: " + sucursal.getNombre()
                + "\nTotal: " + calcularTotal();
    }

    //agregar un detalle a la venta
    public DetalleVenta agregarDetalle(Inventario inventario, int cantidad) {
        DetalleVenta detalle = null;
        if (confirmada == false && cliente != null && cantidad > 0) {
            detalle = new DetalleVenta(inventario, cantidad, cliente);
            listaDetalles.add(detalle);
        }
        return detalle;
    }

    //validar sucursal y existencias suma las cantidades repetidas del mismo inventario
    public boolean validarExistencias() {
        boolean valido = true;
        if (listaDetalles.isEmpty()) {
            valido = false;
        }
        for (DetalleVenta detalle : listaDetalles) {
            Inventario inventario = detalle.getInventario();
            int cantidadTotal = 0;
            for (DetalleVenta otro : listaDetalles) {
                if (otro.getInventario() == inventario) {
                    cantidadTotal = cantidadTotal + otro.getCantidad();
                }
            }
            if (inventario.getSucursal().getCodigo().equals(sucursal.getCodigo()) == false) {
                valido = false;
            }
            if (inventario.hayExistencias(cantidadTotal) == false) {
                valido = false;
            }
        }
        return valido;
    }

    //confirmar la venta descuenta inventario y guarda historiales
    public boolean confirmar() {
        boolean exito = false;
        boolean datosCompletos = cliente != null && vendedor != null && sucursal != null;
        if (confirmada == false && datosCompletos && sucursal.getListaVendedores().contains(vendedor) && validarExistencias()) {
            for (DetalleVenta detalle : listaDetalles) {
                detalle.getInventario().descontar(detalle.getCantidad());
                detalle.getInventario().agregarDetalle(detalle);
            }
            confirmada = true;
            cliente.consultarCompras().add(this);
            vendedor.consultarVentas().add(this);
            sucursal.getListaVentas().add(this);
            exito = true;
        }
        return exito;
    }

    //valor total = suma de subtotales
    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta detalle : listaDetalles) {
            total = total + detalle.getSubtotal();
        }
        return total;
    }
}
import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private String nit;
    private String direccionPrincipal;
    private ArrayList<Sucursal> listaSucursales;
    private ArrayList<Prenda> listaPrendas;
    private ArrayList<Cliente> listaClientes;

    public Empresa(String nombre, String nit, String direccionPrincipal, ArrayList<Sucursal> listaSucursales, ArrayList<Prenda> listaPrendas, ArrayList<Cliente> listaClientes) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccionPrincipal = direccionPrincipal;
        this.listaSucursales = listaSucursales;
        this.listaPrendas = listaPrendas;
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public ArrayList<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(ArrayList<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public ArrayList<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(ArrayList<Prenda> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    // verificar Prenda
    public boolean verificarPrenda(String codigo) {
        boolean existe = false;
        for (Prenda prenda : listaPrendas) {
            if (prenda.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // agregar Prenda
    public boolean agregarPrenda(Prenda prenda) {
        boolean agregado = false;
        boolean existe = verificarPrenda(prenda.getCodigo());
        if (existe == false) {
            listaPrendas.add(prenda);
            agregado = true;
        }
        return agregado;
    }

    // verificar documento
    public boolean verificarDocumento(String documento) {
        boolean existe = false;

        // Verificar en la lista de clientes
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumento().equals(documento)) {
                existe = true;
                break;
            }
        }

        // Verificar en los vendedores de cada sucursal
        if (existe == false) {
            for (Sucursal sucursal : listaSucursales) {
                for (Vendedor vendedor : sucursal.getListaVendedores()) {
                    if (vendedor.getDocumento().equals(documento)) {
                        existe = true;
                        break;
                    }
                }

                if (existe == true) {
                    break;
                }
            }
        }

        return existe;
    }
    // agregar cliente
    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        boolean existe = verificarDocumento(cliente.getDocumento());

        if (existe == false) {
            listaClientes.add(cliente);
            agregado = true;
        }

        return agregado;
    }
    // buscar sucursal
    public Sucursal buscarSucursal(String codigo) {
        Sucursal sucursalEncontrada = null;

        for (Sucursal sucursal : listaSucursales) {
            if (sucursal.getCodigo().equals(codigo)) {
                sucursalEncontrada = sucursal;
                break;
            }
        }

        return sucursalEncontrada;
    }
    // agregar vendedor
    public boolean agregarVendedor(Sucursal sucursal, Vendedor vendedor) {
        boolean agregado = false;
        boolean existe = verificarDocumento(vendedor.getDocumento());

        Sucursal sucursalEncontrada = buscarSucursal(sucursal.getCodigo());

        if (existe == false && sucursalEncontrada != null) {
            sucursalEncontrada.getListaVendedores().add(vendedor);
            agregado = true;
        }

        return agregado;
    }
    // buscar prenda por codigo
    public Prenda buscarPrenda(String codigo) {
        Prenda prendaEncontrada = null;

        for (Prenda prenda : listaPrendas) {
            if (prenda.getCodigo().equals(codigo)) {
                prendaEncontrada = prenda;
                break;
            }
        }

        return prendaEncontrada;
    }
}
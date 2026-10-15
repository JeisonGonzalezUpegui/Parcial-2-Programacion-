import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Aplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa("ModaStyle", "676767", "calle 19 manzana 10", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Sucursal sucursal= new Sucursal("Centro","6776","calle 20 mazana 30","Armenia",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        empresa.getListaSucursales().add(sucursal);
        int opcion;
        do {
            System.out.println("=====Menú Empresa=====");

            System.out.println("---Prenda---");
            System.out.println("1. Agregar Prenda");

            System.out.println("---Registro---");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Agregar Vendedor");

            System.out.println();
            System.out.println("0. Salir");

            System.out.println("Seleccione la opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("---Agregar Prenda---");

                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.println("Codigo: ");
                    String codigo = sc.nextLine();

                    System.out.println("Marca: ");
                    String marca = sc.nextLine();

                    System.out.println("Precio base: ");
                    double precioBase = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Categoria: 1.Camiseta 2.Pantalon 3.Vestido 4.Chaqueta 5.Calzado");
                    int opcionCategoria = sc.nextInt();
                    sc.nextLine();

                    CategoriaPrenda categoriaPrenda = null;
                    if (opcionCategoria == 1) {
                        categoriaPrenda = CategoriaPrenda.CAMISETA;
                    } else if (opcionCategoria == 2) {
                        categoriaPrenda = CategoriaPrenda.PANTALON;
                    } else if (opcionCategoria == 3) {
                        categoriaPrenda = CategoriaPrenda.VESTIDO;
                    } else if (opcionCategoria == 4) {
                        categoriaPrenda = CategoriaPrenda.CHAQUETA;
                    } else if (opcionCategoria == 5) {
                        categoriaPrenda = CategoriaPrenda.CALZADO;
                    }
                    if (categoriaPrenda == null) {
                        System.out.println("Categoria invalida");
                        break;
                    }
                    Prenda prenda = new Prenda(nombre, codigo, marca, precioBase, categoriaPrenda, new ArrayList<>()
                    );
                    if (empresa.agregarPrenda(prenda)) {
                        System.out.println("La prenda se agrego exitosamente");
                    } else {
                        System.out.println("La prenda ya existe");
                    }
                    break;
                case 2:
                    System.out.println("---Agregar Cliente");

                    System.out.println("Documento: ");
                    String documento = sc.nextLine();

                    System.out.println("Nombre completo: ");
                    String nombreCompleto=sc.nextLine();

                    System.out.println("Correo:" );
                    String correo=sc.nextLine();

                    System.out.println("Telefono: ");
                    String telefono=sc.nextLine();

                    System.out.println("Codigo de afiliacion: ");
                    String codigoAfiliacion=sc.nextLine();

                    System.out.println("Categoria: 1.bronce, 2.plata, 3.oro");
                    int opcionCategoriaCliente = sc.nextInt();
                    sc.nextLine();

                    CategoriaCliente categoriaCliente = null;
                    if (opcionCategoriaCliente == 1) {
                        categoriaCliente = CategoriaCliente.BRONCE;
                    } else if (opcionCategoriaCliente == 2) {
                        categoriaCliente = CategoriaCliente.PLATA;
                    } else if (opcionCategoriaCliente == 3) {
                        categoriaCliente = CategoriaCliente.ORO;
                    }
                    if (categoriaCliente == null) {
                        System.out.println("Categoria invalida");
                        break;
                    }

                    Cliente cliente= new Cliente(documento, nombreCompleto, correo, telefono, codigoAfiliacion, categoriaCliente,new ArrayList<>()
                    );
                    if (empresa.agregarCliente(cliente)) {
                        System.out.println("El cliente se agrego exitosamente");
                    } else {
                        System.out.println("El cliente ya existe");
                    }
                    break;

                case 3: {
                    System.out.println("---Agregar Vendedor---");

                    System.out.println("Codigo de la sucursal:");
                    String codigoSucursal = sc.nextLine();

                    Sucursal sucursalSeleccionada = empresa.buscarSucursal(codigoSucursal);

                    if (sucursalSeleccionada == null) {
                        System.out.println("La sucursal no existe");
                        break;
                    }

                    System.out.println("Documento:");
                    String documentoVendedor = sc.nextLine();

                    System.out.println("Nombre completo:");
                    String nombreCompletoVendedor = sc.nextLine();

                    System.out.println("Correo:");
                    String correoVendedor = sc.nextLine();

                    System.out.println("Telefono:");
                    String telefonoVendedor = sc.nextLine();

                    System.out.println("Codigo de empleado:");
                    String codigoEmpleado = sc.nextLine();

                    System.out.println("Fecha de contratacion (AAAA-MM-DD):");
                    String fecha = sc.nextLine();
                    LocalDate fechaContratacion = LocalDate.parse(fecha);

                    System.out.println("Salario basico:");
                    double salarioBasico = sc.nextDouble();
                    sc.nextLine();

                    Vendedor vendedor = new Vendedor(
                            documentoVendedor,
                            nombreCompletoVendedor,
                            correoVendedor,
                            telefonoVendedor,
                            codigoEmpleado,
                            fechaContratacion,
                            salarioBasico,
                            new ArrayList<>()
                    );

                    if (empresa.agregarVendedor(sucursalSeleccionada, vendedor)) {
                        System.out.println("El vendedor se agrego exitosamente");
                    } else {
                        System.out.println("El documento ya existe");
                    }

                    break;
                }
                case 0:
                    System.out.println("Saliendo...");

                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 0) ;
    }
}

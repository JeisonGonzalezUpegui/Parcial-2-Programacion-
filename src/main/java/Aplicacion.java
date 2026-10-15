import java.util.Scanner;
public class Aplicacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa("ModaStyle", "676767", "calle 19 manzana 10");

        int opcion;
        do {
            System.out.println("=====Menú Empresa=====");

            System.out.println("---Prenda---");
            System.out.println("1. Agregar Prenda");

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
                        categoriaPrenda= categoriaPrenda.CALZADO;

                    if (categoriaPrenda == null) {
                        System.out.println("Categoria invalida");
                        break;
                    }
                    Prenda prenda= new prenda(nombre, codigo, marca, precioBase,categoriaPrenda);
                    if(empresa.agregarPrenda(prenda)) {
                        System.out.println("La prenda se agrego exitosamente");
                    } else{
                        System.out.println("La prenda ya existe");
                    }

                    break;
                case 0:
                    break;
                default:

                    break;
            }
        } while (opcion != 0);

    }
}

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


                    break;
                case 0:
                    break;
                default:

                    break;
            }
        } while (opcion != 0);

    }
}

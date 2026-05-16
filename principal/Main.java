package principal;

import dao.ProductoDAO;
import modelo.Producto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductoDAO dao = new ProductoDAO();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA INVENTARIO =====");

            System.out.println("1. Registrar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();

                    Producto producto =
                            new Producto(nombre, precio, cantidad);

                    dao.insertarProducto(producto);

                    break;

                case 2:

                    dao.consultarProductos();

                    break;

                case 3:

                    System.out.print("ID producto: ");
                    int idActualizar = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();

                    Producto productoActualizar =
                            new Producto(
                                    nuevoNombre,
                                    nuevoPrecio,
                                    nuevaCantidad
                            );

                    productoActualizar.setId(idActualizar);

                    dao.actualizarProducto(productoActualizar);

                    break;

                case 4:

                    System.out.print("ID eliminar: ");

                    int idEliminar = scanner.nextInt();

                    dao.eliminarProducto(idEliminar);

                    break;

                case 5:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);
    }
}

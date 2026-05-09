package principal;

import dao.ProductoDAO;
import modelo.Producto;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // INSERTAR
        Producto producto = new Producto("Arroz", 3500, 20);

        dao.insertarProducto(producto);

        // CONSULTAR
        dao.consultarProductos();

        // ACTUALIZAR
        dao.actualizarProducto(1, "Arroz Diana");

        // ELIMINAR
        dao.eliminarProducto(1);
    }
}
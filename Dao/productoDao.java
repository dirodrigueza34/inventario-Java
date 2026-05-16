package dao;

import conexion.ConexionBD;
import modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    Connection conexion;

    public ProductoDAO() {
        conexion = ConexionBD.conectar();
    }

    // INSERTAR
public void actualizarProducto(Producto producto) {

    String sql =
            "UPDATE productos SET nombre=?, precio=?, cantidad=? WHERE id=?";

    try {

        PreparedStatement statement =
                conexion.prepareStatement(sql);

        statement.setString(1, producto.getNombre());

        statement.setDouble(2, producto.getPrecio());

        statement.setInt(3, producto.getCantidad());

        statement.setInt(4, producto.getId());

        statement.executeUpdate();

        System.out.println("Producto actualizado");

    } catch (Exception e) {

        System.out.println(
                "Error al actualizar: "
                        + e.getMessage()
        );
    }
}

    // CONSULTAR
    public void consultarProductos() {

        String sql = "SELECT * FROM productos";

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {

                System.out.println(
                        resultado.getInt("id") + " - "
                        + resultado.getString("nombre") + " - "
                        + resultado.getDouble("precio") + " - "
                        + resultado.getInt("cantidad")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizarProducto(int id, String nombre) {

        String sql = "UPDATE productos SET nombre=? WHERE id=?";

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);

            statement.setString(1, nombre);
            statement.setInt(2, id);

            statement.executeUpdate();

            System.out.println("Producto actualizado");

        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarProducto(int id) {

        String sql = "DELETE FROM productos WHERE id=?";

        try {

            PreparedStatement statement = conexion.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
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

    //  INSERTAR
    public void insertarProducto(Producto producto) {
        
        String sql = "INSERT INTO producto (id_producto, codigo, nombre, precio, stock, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, producto.getId());
            statement.setString(2, "P00" + (int)(Math.random()*100)); 
            statement.setString(3, producto.getNombre());
            statement.setDouble(4, producto.getPrecio());
            statement.setInt(5, producto.getCantidad()); 
            statement.setInt(6, 1); 
            statement.executeUpdate();
            System.out.println(" Producto insertado correctamente");

        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    // CONSULTAR 
    public void consultarProductos() {
        String sql = "SELECT * FROM producto";

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                System.out.println(
                        resultado.getInt("id_producto") + " - " 
                        + resultado.getString("codigo") + " - "
                        + resultado.getString("nombre") + " - "
                        + resultado.getDouble("precio") + " - "
                        + resultado.getInt("stock") 
                );
            }

        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // ACTUALIZAR 
    public void actualizarProductoCompleto(Producto producto) {
        String sql = "UPDATE producto SET nombre=?, precio=?, stock=? WHERE id_producto=?";

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getCantidad());
            statement.setInt(4, producto.getId());

            statement.executeUpdate();
            System.out.println("Producto actualizado por completo");

        } catch (Exception e) {
            System.out.println("Error al actualizar completo: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM producto WHERE id_producto=?";

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            System.out.println(" Producto eliminado");

        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}


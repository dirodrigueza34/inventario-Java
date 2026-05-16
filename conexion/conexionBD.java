package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/sistem_invent";

    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection conectar() {
        Connection conexion = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexion exitosa");

        } catch (Exception e) {

            System.out.println(
                    "Error de conexion: "
                            + e.getMessage()
            );
        }

        return conexion;
    }
public static void main(String[] args) {
        conectar();
    }
}

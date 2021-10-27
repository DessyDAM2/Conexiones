package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static  String url = "jdbc:mysql://localhost:3306/";
    private static final String usuario = "Alvaro";
    private static final String contraseña = "admin1234";

    public static Connection conectarBase(String id){
        Connection conexion = null;
        url = url + id;
        try {

            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion OK");

        } catch (SQLException e) {

            System.out.println("No se ha podido conectar");

        }
        return conexion;
    }
}

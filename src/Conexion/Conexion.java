package Conexion;

import java.sql.*;

public class Conexion {

    private static final String url = "jdbc:mysql://localhost:3306/abcesos";
    private static final String usuario = "Alvaro";
    private static final String contraseña = "admin1234";


    public static Connection conectar() {
        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion OK");

        } catch (SQLException e) {

            System.out.println("No se ha podido conectar");

        }
        return conexion;
    }

    public static void main(String[] args) {

        Connection micon = conectar();
    }
}

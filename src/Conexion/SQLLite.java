package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLLite {
        private static final String URL = "jdbc:sqlite:C:/Users/Alumno_Fp/Desktop/SQLLite/chinook.db";

    public static Connection conectar(){
        Connection con = null;
        try {

            con = DriverManager.getConnection(URL);
            System.out.println("Conexion OK");

        } catch (SQLException e) {

            System.out.println("Subnormal");

        }
        return con;
    }
    public static void main(String[] args) {
        Connection micon = conectar();
    }
}

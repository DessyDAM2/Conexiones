package Conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLLite {
    private static String URL = "jdbc:sqlite:C:/Users/Alumno_Fp/Desktop/BaseDatos/";

    public static Connection conectarSQLlite(String id){
        Connection con = null;
        URL = URL + id;
        try {

            con = DriverManager.getConnection(URL);
            System.out.println("Conexion OK");

        } catch (SQLException e) {

            System.out.println("No se ha podido conectar");

        }
        return con;
    }
}

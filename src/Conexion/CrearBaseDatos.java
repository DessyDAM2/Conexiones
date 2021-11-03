package Conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {
    private static File f1 = new File("C:/Users/Alumno_Fp/Desktop/BaseDatos/Acceso.db");

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/Users/Alumno_FP/Desktop/BaseDatos/" + fileName;

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (f1.exists()) {
            f1.delete();
        }
        createNewDatabase("Acceso.db");
    }
}

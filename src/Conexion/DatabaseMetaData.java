package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaData {


    public static void main(String[] args) throws SQLException {
        Connection micon = Conexion.conectar();
        java.sql.DatabaseMetaData dbmd = micon.getMetaData();
        System.out.println(dbmd.getDatabaseProductName());
        System.out.println(dbmd.getDatabaseProductVersion());
        System.out.println(dbmd.getDriverName());
        System.out.println(dbmd.getURL());
        System.out.println(dbmd.getUserName());
        System.out.println();
        String[] tipos = {"TABLE"};
        ResultSet tablas = dbmd.getTables(null, null, null, tipos);
        while (tablas.next()) {
            String catalogo = tablas.getString("TABLE_CAT");
            String esquema = tablas.getString("TABLE_SCHEM");
            String nombre = tablas.getString("TABLE_NAME");
            String tipo = tablas.getString("TABLE_TYPE");

        }
    }
}

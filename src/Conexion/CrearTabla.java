package Conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void main(String[] args) throws SQLException {
        Connection micon = Conexion.conectar();
        String consulta = "CREATE TABLE CLIENTES(DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY (DNI))";

        try{
            Statement s = micon.createStatement();
            s.execute(consulta);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

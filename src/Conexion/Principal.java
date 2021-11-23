package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        try {
            Connection miCon = Conexion.conectar();
            PreparedStatement stmt = miCon.prepareStatement("select* from persona where nombre like 'Juan'");
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                System.out.println("Nombre " + results.getString("nombre"));
                System.out.println("Edad " + results.getString("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

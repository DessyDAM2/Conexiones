package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            try {
                Connection miCon = Conexion.conectar();
                String nombre = sc.next();
                int edad = sc.nextInt();

                PreparedStatement insertar = miCon.prepareStatement("INSERT INTO `persona` (`nombre`,`edad`) values (?,?)");
                insertar.setString(1,nombre);
                insertar.setString(2, String.valueOf(edad));
                insertar.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}

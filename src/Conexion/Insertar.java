package Conexion;

import Menu.Personas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            try {
                Connection miCon = Conexion.conectar();
                Personas p = new Personas();
                String nombre = sc.next();
                int edad = sc.nextInt();

                PreparedStatement insertar = miCon.prepareStatement("INSERT INTO `persona` (`nombre`,`edad`) values (?,?)");
                insertar.setString(1,nombre);
                insertar.setString(2, String.valueOf(edad));
                insertar.executeUpdate();
                miCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}

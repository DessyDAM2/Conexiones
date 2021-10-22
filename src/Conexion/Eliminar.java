package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Eliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseas eliminar algún dato de la base de datos (Inidicalo con un si o un no)");
        String decision = sc.nextLine();

        if(decision.equals("si")) {
            try {
                Connection miCon = Conexion.conectar();
                PreparedStatement eliminar = miCon.prepareStatement("DELETE FROM `persona` WHERE nombre = (?)");
                System.out.println("Introduce el nombre del usuario que quieres eliminar");
                String nombre = sc.next();
                eliminar.setString(1, nombre);
                eliminar.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else;
    }
}

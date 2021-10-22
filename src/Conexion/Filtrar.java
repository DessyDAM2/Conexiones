package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Filtrar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deseas insertar algún dato de la base de datos (Inidicalo con un si o un no)");
        String decision = sc.nextLine();

        if(decision.equals("si")) {
            try {
                Connection miCon = Conexion.conectar();
                //String nombre = sc.next();
                //int edad = sc.nextInt();
                PreparedStatement filtrar = miCon.prepareStatement("select * from `persona` order by 1");
                //filtrar.setString(1,nombre);
                //filtrar.setString(2, String.valueOf(edad));
                ResultSet results= filtrar.executeQuery();
                while (results.next()) {
                    System.out.println("Nombre " + results.getString("nombre"));
                    System.out.println("Edad " + results.getString("edad"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else;
    }
}

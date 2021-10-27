package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBiblioteca {
    public static void main(String[] args) {
        String bd = "Biblioteca";
        Connection miCon = SQLLite.conectarSQLlite("C:/Users/Alumno_FP/Deskto/SQLLite/sqlite-tools-win32-x86-3360000/sqlite3.exe");
        String consulta = "CREATE DATABASE "+bd;
        SQLLite.conectarSQLlite("Biblioteca");
        try{
            Statement crearBD =  miCon.prepareStatement(consulta);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

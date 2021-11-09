package Conexion;

import java.sql.Connection;

public class IntroducirDatos {


    public static void main(String[] args) {
        Connection micon = SQLLite.conectarSQLlite("Acceso.db");
        
    }
}

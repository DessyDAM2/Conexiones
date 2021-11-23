package Conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void main(String[] args) throws SQLException {
        Connection micon = SQLLite.conectarSQLlite("Acceso.db");
        String tabla1 = "CREATE TABLE IF NOT EXISTS LIBROS(COD INT NOT NULL, TITULO VARCHAR(200), AUTOR VARCHAR(200), EDITORIAL VARCHAR(200),AÑO INT, ISBN VARCHAR(200) NOT NULL , N_EJEM INT, N_PAG INT, PRIMARY KEY(COD), UNIQUE(ISBN))";
        String tabla2 = "CREATE TABLE IF NOT EXISTS SOCIO (COD INT NOT NULL, NOMBRE VARCHAR(20), APELLIDO VARCHAR(20),FECHANAC DATE, DOMICILIO VARCHAR(200), TELF VARCHAR(20), PRIMARY KEY(COD))";
        String tabla3 = "CREATE TABLE IF NOT EXISTS PRESTAMO (CODLIBRO INT NOT NULL, CODSOCIO INT NOT NULL, FECHAINICIO DATE, FECHAFIN DATE, PRIMARY KEY (CODLIBRO, CODSOCIO) ,FOREIGN KEY(CODLIBRO) REFERENCES LIBROS(COD), FOREIGN KEY(CODSOCIO) REFERENCES SOCIO(COD))";

        try {
            Statement s = micon.createStatement();
            s.execute(tabla1);
            s.execute(tabla2);
            s.execute(tabla3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

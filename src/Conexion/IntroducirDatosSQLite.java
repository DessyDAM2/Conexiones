package Conexion;

import org.javatuples.Octet;
import org.javatuples.Quartet;
import org.javatuples.Sextet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IntroducirDatosSQLite {


    public static void main(String[] args) throws SQLException {
        Connection micon = SQLLite.conectarSQLlite("Acceso.db");
        Date fecha = new Date(2021);
        Date nacimiento = new Date(2001-3-11);
        Date fechaInicio = new Date(2021-11-4);
        Date fechaFin = new Date(2021-11-15);
        Octet<Integer, String, String, String, Date, String, Integer,Integer> libro1 = Octet.with(12,"Las locas aventuras de Ricardo y Mauricio", "Pablo Matta","Editorial Planeta",fecha,"ISBN 12",127,432);
        Sextet<Integer, String, String, Date,String, String>autor1 = Sextet.with(12,"Alvaro","Dessy",nacimiento,"Calle Falsa 123","323 23 23 23");
        Quartet<Integer, Integer, Date, Date>prestamo1 = Quartet.with(12,12,fechaInicio,fechaFin);

        PreparedStatement pst = micon.prepareStatement("INSERT INTO `LIBROS` (`COD`, `TITULO`, `AUTOR`, `EDITORIAL`, `AÑO`, `ISBN`, `N_EJEM`, `N_PAG`) values (?, ?, ?, ?, ?, ?, ?, ?)" );
        pst.setString(1, String.valueOf(libro1.getValue0()));
        pst.setString(2, libro1.getValue1());
        pst.setString(3, libro1.getValue2());
        pst.setString(4, libro1.getValue3());
        pst.setString(5, String.valueOf(libro1.getValue4()));
        pst.setString(6, libro1.getValue5());
        pst.setString(7, String.valueOf(libro1.getValue6()));
        pst.setString(8, String.valueOf(libro1.getValue7()));
    }
}



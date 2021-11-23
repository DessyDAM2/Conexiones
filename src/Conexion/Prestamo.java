package Conexion;

import java.util.Date;

public class Prestamo {
    Integer codLibro;
    Integer codSocio;
    Date fechaInicio;
    Date fechaDevolcion;

    public Prestamo(Integer codLibro, Integer codSocio,Date fechaInicio, Date fechaDevolcion){
        this.codLibro = codLibro;
        this.codSocio = codSocio;
        this.fechaInicio = fechaInicio;
        this.fechaDevolcion = fechaDevolcion;
    }
}

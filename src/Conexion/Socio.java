package Conexion;

import java.util.Date;

public class Socio {
    Integer codigo;
    String nombre;
    String apellido;
    Date fechaNac;
    String domicilio;
    String telefono;

    public Socio(Integer codigo,String nombre, String apellido, Date fechaNac,String domicilio, String telefono){
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
}

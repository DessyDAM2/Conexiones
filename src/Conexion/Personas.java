package Conexion;

import java.io.Serializable;

public class Personas implements Serializable{
    private  String nombre;
    private String  edad;
    private static final long serialVersionUID = 1L;



    public Personas(){

    }

    public Personas(String nombre,String edad){
        this.edad=edad;
        this.nombre = nombre;

    }

    public void setNombre(){
        this.nombre = nombre;
    }
    public void setEdad(){
        this.edad=edad;
    }
    public String getNombre(){
        return nombre;
    }
    public String getEdad() {
        return edad;
    }

}

package Conexion;

import java.util.Date;

public class Libro {
    Integer cod;
    String titulo;
    String autor;
    String editorial;
    Date año;
    String ISBN;
    Integer numPags;
    Integer numEjms;

    public Libro(Integer cod,String titulo, String autor,String editorial,Date año, String ISBN, Integer numEjms, Integer numPags){
        this.cod = cod;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.año = año;
        this.ISBN = ISBN;
        this.numEjms = numEjms;
        this.numPags = numPags;
    }
}

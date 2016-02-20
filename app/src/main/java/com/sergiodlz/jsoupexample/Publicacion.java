package com.sergiodlz.jsoupexample;

/**
 * Created by sergio on 19/02/16.
 */
public class Publicacion {
    private int Id;
    private String Tipo;    //Libro, Articul, etc.
    private String Publicacion;
    private int ProfesorId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(String publicacion) {
        Publicacion = publicacion;
    }

    public int getProfesorId() {
        return ProfesorId;
    }

    public void setProfesorId(int profesorId) {
        ProfesorId = profesorId;
    }
}

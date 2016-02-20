package com.sergiodlz.jsoupexample.Entities;

/**
 * Created by sergio on 19/02/16.
 */
public class Publicacion implements IEntityBase{
    public int Id;
    public TipoPublicacion TipoPublicacion;    //Libro, Articul, etc.
    public String Nombre;
    public int Año;
    public Professor Profesor;

}

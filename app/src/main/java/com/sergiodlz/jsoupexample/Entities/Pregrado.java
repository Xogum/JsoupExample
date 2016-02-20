package com.sergiodlz.jsoupexample.Entities;

import java.lang.ref.SoftReference;

/**
 * Created by sergi on 20/02/2016.
 */
public class Pregrado implements IEntityBase {
    public int Id;
    public String Nombre;
    public String Url;
    public Categoria Categoria;
    public Departamento Departamento;
}

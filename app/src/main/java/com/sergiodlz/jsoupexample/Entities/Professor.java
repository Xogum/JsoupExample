package com.sergiodlz.jsoupexample.Entities;

import java.util.ArrayList;

/**
 * Created by sergio on 19/02/16.
 */
public class Professor implements IEntityBase {
    public int Id;
    public String Nombre;
    public TipoContrato TipoContrato;
    public Departamento Departamento;
    public String Perfil;
    public Contacto Contacto;
    public ArrayList<Pregrado> Pregrados;
    public ArrayList<Estudio> Estudios;
    public ArrayList<Publicacion> Publicaciones;
    public ArrayList<Asignatura> Asignaturas;
}

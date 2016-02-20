package com.sergiodlz.jsoupexample;

import java.util.ArrayList;

/**
 * Created by sergio on 19/02/16.
 */
public class Professor {
    private int Id;
    private String Nombre;
    private int TipoId;
    private int DepartamentoId;
    private Departamento Departamento;
    private String Perfil;
    private int ContactoId;
    private Contacto Contacto;
    private ArrayList<Estudio> Estudios;
    private ArrayList<Publicacion> Publicaciones;
    private ArrayList<Asignatura> Asignaturas;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getTipoId() {
        return TipoId;
    }

    public void setTipoId(int tipoId) {
        TipoId = tipoId;
    }

    public int getDepartamentoId() {
        return DepartamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        DepartamentoId = departamentoId;
    }

    public com.sergiodlz.jsoupexample.Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(com.sergiodlz.jsoupexample.Departamento departamento) {
        Departamento = departamento;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String perfil) {
        Perfil = perfil;
    }

    public int getContactoId() {
        return ContactoId;
    }

    public void setContactoId(int contactoId) {
        ContactoId = contactoId;
    }

    public com.sergiodlz.jsoupexample.Contacto getContacto() {
        return Contacto;
    }

    public void setContacto(com.sergiodlz.jsoupexample.Contacto contacto) {
        Contacto = contacto;
    }

    public ArrayList<Estudio> getEstudios() {
        return Estudios;
    }

    public void setEstudios(ArrayList<Estudio> estudios) {
        Estudios = estudios;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return Publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        Publicaciones = publicaciones;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        Asignaturas = asignaturas;
    }
}

package com.sergiodlz.jsoupexample;

/**
 * Created by sergio on 19/02/16.
 */
public class Asignatura {
    private int Id;
    private String Asignatura;
    private int ProfesorId;

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

    public int getProfesorId() {
        return ProfesorId;
    }

    public void setProfesorId(int profesorId) {
        ProfesorId = profesorId;
    }

    public int getId() {

        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

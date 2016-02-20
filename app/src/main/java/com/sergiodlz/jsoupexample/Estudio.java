package com.sergiodlz.jsoupexample;

/**
 * Created by sergio on 19/02/16.
 */
public class Estudio {
    private int Id;
    private String Estudio;
    private String Universidad;
    private int ProfesorId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEstudio() {
        return Estudio;
    }

    public void setEstudio(String estudio) {
        Estudio = estudio;
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String universidad) {
        Universidad = universidad;
    }

    public int getProfesorId() {
        return ProfesorId;
    }

    public void setProfesorId(int profesorId) {
        ProfesorId = profesorId;
    }
}

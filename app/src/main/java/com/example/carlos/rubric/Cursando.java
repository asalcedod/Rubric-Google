package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by carlos on 17/04/17.
 */
@Table(database = AppDatabase.class)
public class Cursando extends BaseModel {
    @PrimaryKey
    String Estudiante;
    @Column
    String Asignatura;

    public Cursando() {

    }

    public Cursando(String estudiante, String asignatura) {
        Estudiante = estudiante;
        Asignatura = asignatura;
    }

    public String getEstudiante() {
        return Estudiante;
    }

    public void setEstudiante(String estudiante) {
        Estudiante = estudiante;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

    @Override
    public String toString() {
        return Estudiante;
    }
}

package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by carlos on 16/04/17.
 */
@Table(database = AppDatabase.class)
public class Estudiante extends BaseModel {
    @PrimaryKey
    String nombre;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

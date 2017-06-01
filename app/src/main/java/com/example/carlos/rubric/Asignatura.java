package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by carlos on 3/04/17.
 */
@Table(database = AppDatabase.class)
public class Asignatura extends BaseModel {

    @PrimaryKey
    String Nombre;

    public void Asignatura(String nombre) {
        this.Nombre = nombre;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}

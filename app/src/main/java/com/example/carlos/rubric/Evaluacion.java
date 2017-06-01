package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by carlos on 16/04/17.
 */
@Table(database = AppDatabase.class)
public class Evaluacion extends BaseModel {
    @PrimaryKey(autoincrement = true)
    int number;
    @Column
    String Rubrica;
    @Column
    String Asignatura;

    public Evaluacion( String rubrica) {
        Rubrica = rubrica;
    }

    public Evaluacion() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

    public String getRubrica() {
        return Rubrica;
    }

    public void setRubrica(String rubrica) {
        Rubrica = rubrica;
    }

    @Override
    public String toString() {
        return Rubrica;
    }
}


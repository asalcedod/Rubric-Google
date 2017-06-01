package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by antonio on 15/04/17.
 */
@Table(database = AppDatabase.class)
public class Rubric extends BaseModel{
    @PrimaryKey
    String Rubric;

    @Column
    String Asignatura;

    @Column
    int cat;

    @Column
    int lvl;

    public Rubric() {

    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getRubric() {
        return Rubric;
    }

    public void setRubric(String rubric) {
        Rubric = rubric;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

    @Override
    public String toString() {
        return Rubric;
    }
}

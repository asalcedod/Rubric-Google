package com.example.carlos.rubric;

/**
 * Created by antonio on 15/04/17.
 */

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by antonio on 15/04/17.
 */
@Table(database = AppDatabase.class)
public class Category extends BaseModel{
    @PrimaryKey(autoincrement = true)
    int id;
    @Column
    String Categoria;
    @Column
    String Rubrica;
    @Column
    int nE;

    public String getRubrica() {
        return Rubrica;
    }

    public void setRubrica(String rubrica) {
        Rubrica = rubrica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getnE() {
        return nE;
    }

    public void setnE(int nE) {
        this.nE = nE;
    }

}

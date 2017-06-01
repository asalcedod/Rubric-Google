package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by antonio on 15/04/17.
 */
@Table(database = AppDatabase.class)
public class Elements extends BaseModel{
    @PrimaryKey(autoincrement = true)
    int id;
    @Column
    String Elemento;
    @Column
    String Categoria;
    @Column
    int nN;
    @Column
    int peso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElemento() {
        return Elemento;
    }

    public void setElemento(String elemento) {
        Elemento = elemento;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getnN() {
        return nN;
    }

    public void setnN(int nN) {
        this.nN = nN;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}

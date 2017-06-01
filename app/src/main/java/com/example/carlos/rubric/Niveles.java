package com.example.carlos.rubric;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by antonio on 15/04/17.
 */
@Table(database = AppDatabase.class)
public class Niveles extends BaseModel{
    @PrimaryKey(autoincrement = true)
    int id;
    @Column
    String Nivel;
    @Column
    String Elemento;

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public String getElemento() {
        return Elemento;
    }

    public void setElemento(String elemento) {
        Elemento = elemento;
    }
}
